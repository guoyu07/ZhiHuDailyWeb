package com.eric.bean;

import java.util.List;

/**
 * Created by run on 16/7/12.
 */
public class Stories {

    public Stories(List<String> images, String type, String id, String ga_prefix, String title, String multipic) {
        this.images = images;
        this.type = type;
        this.id = id;
        this.ga_prefix = ga_prefix;
        this.title = title;
        this.multipic = multipic;
    }

    public List<String> getImages() {

        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMultipic() {
        return multipic;
    }

    public void setMultipic(String multipic) {
        this.multipic = multipic;
    }

    public List<String> images;
    public String type;
    public String id;
    public String ga_prefix;
    public String title;
    public String multipic;
}
