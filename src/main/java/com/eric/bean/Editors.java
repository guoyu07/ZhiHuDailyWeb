package com.eric.bean;

/**
 * Created by run on 16/7/14.
 */
public class Editors {
    public String url;
    public String bio;
    public int id;
    public String avatar;
    public String name;

    public Editors(String url, String bio, int id, String avatar, String name) {
        this.url = url;
        this.bio = bio;
        this.id = id;
        this.avatar = avatar;
        this.name = name;
    }

    public String getUrl() {

        return url;
    }

    public Editors setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public Editors setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public int getId() {
        return id;
    }

    public Editors setId(int id) {
        this.id = id;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Editors setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public Editors setName(String name) {
        this.name = name;
        return this;
    }
}
