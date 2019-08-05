package com.example.courses.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Course {
    private int id;
    @SerializedName("subcategories")
    private List<SubCategory> subCategories;
    private String title;
    private String description;
    @SerializedName("main_image_url")
    private String mainImageUrl;
    @SerializedName("logo_image_url")
    private String logoImageUrl;
    private String status;
    private String tariff;

    public int getId() {
        return id;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getTariff() {
        return tariff;
    }
}
