package com.example.testtask.ui.home.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    public void setTitle(String title) {
        this.title = title;
    }

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("category")
    @Expose
    private int category;

}