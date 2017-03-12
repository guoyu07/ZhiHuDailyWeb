package com.eric.controller;

import com.cn.hnust.util.ImageUtil;
import com.cn.hnust.util.dataUtil;
import com.eric.bean.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/zhihu")
public class ZhdataController {
	//启动图
	@RequestMapping("/getstart_image")
	public String getstart_image(HttpServletRequest request,HttpServletResponse response) {
		String httpUrl = "http://news-at.zhihu.com/api/4/start-image/1080*1776";
		String result = dataUtil.request(httpUrl,"");
		setParam(response);
		writeData(response, result);
		return null;
	}
	//最新新闻
	@RequestMapping(value="/getNews")
	@ResponseBody
	public LatestNewsList getNews(HttpServletRequest request,HttpServletResponse response) {
		String httpUrl = "http://news-at.zhihu.com/api/4/news/latest";
		String result = dataUtil.request(httpUrl,"");
		LatestNewsList newList = new Gson().fromJson(result,LatestNewsList.class);

		if(newList!=null){
			List<Top_Stories> top_storiesList = newList.getTop_stories();
			List<Stories> storiesList = newList.getStories();

			if(storiesList!=null){
				for (int i=0;i<storiesList.size();i++){
					List<String> imgList = storiesList.get(i).getImages();
					List<String> tempList = new ArrayList<String>();
					for (int j=0;j<imgList.size();j++){
						ImageUtil.saveImg(imgList.get(j),request);
						tempList.add("upload/"+ImageUtil.cutFileName(imgList.get(j)));
					}
					//处理结束后应把处理结果放回
					storiesList.get(i).setImages(tempList);
				}
			}
			if(top_storiesList!=null){

				for (int k=0;k<top_storiesList.size();k++){
					String imageUrl = top_storiesList.get(k).getImage();
					ImageUtil.saveImg(imageUrl,request);
                    //处理结束后应把处理结果放回
					top_storiesList.get(k).setImage("upload/"+ImageUtil.cutFileName(imageUrl));
				}
			}

		}


		//String url = "http://pic2.zhimg.com/467d67351e0f11e158a385456b0d5635.jpg";

//		setParam(response);
//		writeData(response, result);
		
		return newList;
	}
	//根据id获得新闻内容
	@RequestMapping("/getNews_content")
	public String getNews_content(HttpServletRequest request,HttpServletResponse response) {
		String id=request.getParameter("storiesid");
		String httpUrl = "http://news-at.zhihu.com/api/4/news/"+id;
		String result = dataUtil.request(httpUrl,"");
		setParam(response);
		writeData(response, result);
		return null;
	}
	//根据日期获得之前的新闻 日期格式20131119 小于20130520为空
	@RequestMapping("/getNews_before")
	public String getNews_before(HttpServletRequest request,HttpServletResponse response) {
		String date=request.getParameter("date");
		String httpUrl = "http://news.at.zhihu.com/api/4/news/before/"+date;
		String result = dataUtil.request(httpUrl,"");
		setParam(response);
		writeData(response, result);
		return null;
	}
	//根据新闻id获得长评论总数 popularity : 点赞总数 short_comments : 短评论总数 comments : 评论总数
	@RequestMapping("/getNews_extra")
	public String getNews_extra(HttpServletRequest request,HttpServletResponse response) {
		String id=request.getParameter("storiesid");
		
		String httpUrl = "http://news-at.zhihu.com/api/4/story-extra/"+id;
		String result = dataUtil.request(httpUrl,"");
		setParam(response);
		writeData(response, result);
		return null;
	}
	//获取评论内容
	@RequestMapping("/getNews_comments")
	public String getNews_comments(HttpServletRequest request,HttpServletResponse response) {
		String id=request.getParameter("storiesid");
		String comments = request.getParameter("comments");
		String httpUrl = "http://news-at.zhihu.com/api/4/story/"+id+"/"+comments;
		String result = dataUtil.request(httpUrl,"");
		setParam(response);
		writeData(response, result);
		return null;
	}
	//获取主题日报
    @ResponseBody
	@RequestMapping("/getthemes")
	public Theme getthemes(HttpServletRequest request,HttpServletResponse response) {
		String httpUrl = "http://news-at.zhihu.com/api/4/themes";
		String result = dataUtil.request(httpUrl,"");

        Theme theme = new Gson().fromJson(result,Theme.class);
        List<Others> resultList = theme.getOthers();
        System.out.println(resultList.size()+"hheheheh");
        for(int i=0; i<resultList.size(); i++){
            Others temp = resultList.get(i);
            ImageUtil.saveImg(temp.getThumbnail(),request);
            theme.getOthers().get(i).setThumbnail("upload/"+ImageUtil.cutFileName(temp.getThumbnail()));
        }
		return theme;
	}
	//获取主题日报内容
	@ResponseBody
	@RequestMapping("/theme/{id}")
	public SubTheme getthemes_content(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		String httpUrl = "http://news-at.zhihu.com/api/4/theme/"+id;
		String result = dataUtil.request(httpUrl,"");
		System.out.println(id+"="+result);
		SubTheme themes = new Gson().fromJson(result,SubTheme.class);

		List<Editors> editorList = themes.getEditors();
		List<Stories> list = themes.getStories();
		if (list!=null){
			for (int i=1; i<list.size(); i++){
				List<String> imgList = list.get(i).getImages();
				if(imgList!=null){
					List<String> temp = new ArrayList<String>();
					for(int j=0; j<imgList.size(); j++){
						ImageUtil.saveImg(imgList.get(j),request);
						temp.add("upload/"+ImageUtil.cutFileName(imgList.get(j)));
					}
					themes.getStories().get(i).setImages(temp);
				}


			}
		}

		if(editorList!=null){
			for (int i=0; i<editorList.size(); i++){
				ImageUtil.saveImg(editorList.get(i).getAvatar(),request);
				themes.getEditors().get(i).setAvatar("upload/"+ImageUtil.cutFileName(editorList.get(i).getAvatar()));
			}
		}
		if(themes.getBackground()!=null){
			ImageUtil.saveImg(themes.getBackground(),request);
			themes.setBackground("upload/"+ImageUtil.cutFileName(themes.getBackground()));
		}
		if(themes.getImage()!=null){
			ImageUtil.saveImg(themes.getImage(),request);
			themes.setImage("upload/"+ImageUtil.cutFileName(themes.getImage()));
		}

		return themes;
	}
	//获取新闻推荐者
	@RequestMapping("/getrecommenders")
	public String getrecommenders(HttpServletRequest request,HttpServletResponse response) {
		
		String id=request.getParameter("storiesid");
		String httpUrl = "http://news-at.zhihu.com/api/4/story/"+id+"/recommenders";
		String result = dataUtil.request(httpUrl,"");
		setParam(response);
		writeData(response, result);
		return null;
	}
	public void setParam(HttpServletResponse response) {
		 response.setCharacterEncoding("UTF-8");  
		 response.addHeader("Access-Control-Allow-Origin", "*");
	}
	public void writeData(HttpServletResponse response,String jsonResult) {
		java.io.PrintWriter pw = null;  
		if(jsonResult=="")
		{
			 try{  
			        pw = response.getWriter();  
			        pw.write("");  
			    }catch (Exception e){  
			       
			    }finally{  
			        pw.close();  
			    }  
		}
		else {
			
		    try{  
		        pw = response.getWriter();  
		        pw.write(jsonResult);  
		    }catch (Exception e){  
		       
		    }finally{  
		        pw.close();  
		    }  
		}
		
	}
}
