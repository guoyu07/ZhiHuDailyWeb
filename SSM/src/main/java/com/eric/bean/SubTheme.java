package com.eric.bean;
import java.util.List;
/**
 * Created by run on 16/7/14.
 */
public class SubTheme {

    public List<Stories> stories;
    public String description;
    public String color;
    public String name;
    public String background;
    public String image;
    public List<Editors> editors;
    public String image_source;

    public SubTheme(List<Stories> stories, String description, String color, String name, String background, String image, List<Editors> editors, String image_source) {
        this.stories = stories;
        this.description = description;
        this.color = color;
        this.name = name;
        this.background = background;
        this.image = image;
        this.editors = editors;
        this.image_source = image_source;
    }

    public List<Stories> getStories() {

        return stories;
    }

    public SubTheme setStories(List<Stories> stories) {
        this.stories = stories;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubTheme setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getColor() {
        return color;
    }

    public SubTheme setColor(String color) {
        this.color = color;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubTheme setName(String name) {
        this.name = name;
        return this;
    }

    public String getBackground() {
        return background;
    }

    public SubTheme setBackground(String background) {
        this.background = background;
        return this;
    }

    public String getImage() {
        return image;
    }

    public SubTheme setImage(String image) {
        this.image = image;
        return this;
    }

    public List<Editors> getEditors() {
        return editors;
    }

    public SubTheme setEditors(List<Editors> editors) {
        this.editors = editors;
        return this;
    }

    public String getImage_source() {
        return image_source;
    }

    public SubTheme setImage_source(String image_source) {
        this.image_source = image_source;
        return this;
    }
}
