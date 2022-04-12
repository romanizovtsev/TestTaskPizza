package com.example.testtask.ui.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public String getImage() {
        return image;
    }

    public int getCategory() {
        return category;
    }

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("cost")
    @Expose
    private int cost;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("category")
    @Expose
    private int category;

}