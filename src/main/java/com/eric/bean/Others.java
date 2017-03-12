package com.eric.bean;

/**
 * Created by run on 16/7/13.
 */
public class Others {
    public String color;
    public String thumbnail;
    public String id;
    public String name;
    public String description;

    public String getColor() {
        return color;
    }

    public Others setColor(String color) {
        this.color = color;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Others setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getId() {
        return id;
    }

    public Others setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Others setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Others setDescription(String description) {
        this.description = description;
        return this;
    }

    public Others(String color, String thumbnail, String id, String name, String description) {

        this.color = color;
        this.thumbnail = thumbnail;
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
