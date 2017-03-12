package com.cn.hnust.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @说明 从网络获取图片到本地
 * @author 陈润发
 * @version 1.0
 * @since
 */
public class ImageUtil {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

    }
    /**
     * 将图片写入到磁盘
     * @param img 图片数据流
     * @param fileName 文件保存时的名称
     */
    public static void writeImageToDisk(byte[] img, String fileName,HttpServletRequest request){

        try {
            ServletContext context = request.getSession().getServletContext();
//            StringBuilder bb = new StringBuilder();
//            bb.append(context.getContextPath()).append("|").append(context.getRealPath("/WEB-INF/upload"));
//            System.out.println(bb.toString());



            StringBuilder sb = new StringBuilder(context.getRealPath("/WEB-INF/upload")+"/");
            String fileNameWithNotDir = fileName;
            if(fileName.lastIndexOf("/")!=-1){
                sb.append(fileName.substring(0,fileName.lastIndexOf("/")));
                fileName = fileName.substring(fileName.lastIndexOf("/"),fileName.length());
            }

            File uploadDir = new File(sb.toString());
            if(!uploadDir.exists() && !uploadDir.isFile()){
                uploadDir.mkdirs();
                System.out.println("create dir["+"]"+uploadDir.getAbsolutePath());
            }

            //确保首次存储
            if(!isExist(uploadDir,fileName)){
                sb.append(fileName);
                File uploadFile = new File(sb.toString());
                System.out.println("初次创建文件中"+sb.toString());
                //System.out.println(uploadDir+"+++"+fileName+"+++"+uploadFile.getAbsolutePath());
                FileOutputStream fops = new FileOutputStream(uploadFile);
                fops.write(img);
                fops.flush();
                fops.close();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(File folder,final String keyWord){
        System.out.println(folder.getAbsolutePath()+"====");
        String[] subFoldersFiles = folder.list();
        for (String str : subFoldersFiles){
            if(str.contains(keyWord)){
                return true;
            }
        }
        return false;
//        List<File> result = new ArrayList<File>();// 声明一个集合
//        System.out.println(subFolders.length);
//        for (int i = 0; i < subFolders.length; i++) {// 循环显示文件夹或文件
//            if (subFolders[i].isFile()) {// 如果是文件则将文件添加到结果列表中
//                result.add(subFolders[i]);
//            } else {// 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
//                File[] foldResult = searchFile(subFolders[i], keyWord);
//                for (int j = 0; j < foldResult.length; j++) {// 循环显示文件
//                    result.add(foldResult[j]);// 文件保存到集合中
//                }
//            }
//        }
//
//        File files[] = new File[result.size()];// 声明文件数组，长度为集合的长度
//        result.toArray(files);// 集合数组化


    }

    public static boolean saveImg(String url,HttpServletRequest request){
        byte[] btImg = ImageUtil.getImageFromNetByUrl(url);
        if(null != btImg && btImg.length > 0){
            //System.out.println("创建图片资源中---");
            ImageUtil.writeImageToDisk(btImg, cutFileName(url),request);

            return true;
        }
        return false;
    }

    public static String cutFileName(String url){
        return url.substring(url.indexOf("com")+4,url.length());
    }
    /**
     * 根据地址获得数据的字节流
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 从输入流中获取数据
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}