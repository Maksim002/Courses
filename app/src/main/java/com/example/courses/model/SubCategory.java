package com.example.courses.model;

import com.google.gson.annotations.SerializedName;

public class SubCategory {
    private int id;
    private String title;
    @SerializedName("subcategory_image_url")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
