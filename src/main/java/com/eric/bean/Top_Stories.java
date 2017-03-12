package com.eric.bean;

/**
 * Created by run on 16/7/12.
 */
public class Top_Stories {

    public String getImage() {
        return image;
    }

    public Top_Stories setImage(String image) {
        this.image = image;
        return this;
    }

    public String getType() {
        return type;
    }

    public Top_Stories setType(String type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return id;
    }

    public Top_Stories setId(String id) {
        this.id = id;
        return this;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public Top_Stories setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Top_Stories setTitle(String title) {
        this.title = title;
        return this;
    }



    public Top_Stories(String image, String type, String id, String ga_prefix, String title) {
        this.image = image;
        this.type = type;
        this.id = id;
        this.ga_prefix = ga_prefix;
        this.title = title;

    }

    public String image;
    public String type;
    public String id;
    public String ga_prefix;
    public String title;
}
