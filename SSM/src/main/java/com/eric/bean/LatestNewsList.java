package com.eric.bean;

import java.util.List;

/**
 * Created by run on 16/7/12.
 */
public class LatestNewsList {


    public String getDate() {
        return date;
    }

    public LatestNewsList setDate(String date) {
        this.date = date;
        return this;
    }

    public List<Stories> getStories() {
        return stories;
    }

    public LatestNewsList setStories(List<Stories> stories) {
        this.stories = stories;
        return this;
    }

    public List<Top_Stories> getTop_stories() {
        return top_stories;
    }

    public LatestNewsList setTop_stories(List<Top_Stories> top_stories) {
        this.top_stories = top_stories;
        return this;
    }

    public LatestNewsList(String date, List<Stories> stories, List<Top_Stories> top_stories) {
        this.date = date;
        this.stories = stories;
        this.top_stories = top_stories;
    }

    @Override
    public String toString() {
        return "LatestNewsList{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }

    public String date;
    public List<Stories> stories;
    public List<Top_Stories> top_stories;
}
