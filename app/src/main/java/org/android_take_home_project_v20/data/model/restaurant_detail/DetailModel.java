package org.android_take_home_project_v20.data.model.restaurant_detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Erald Haka.
 */
public class DetailModel {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("cover_img_url")
    private String coverImageUrl;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("average_rating")
    private Double  averageRating;

    @SerializedName("menus")
    private List<MenuModel> menus = null;

    public DetailModel(String name, String description, String coverImageUrl, String phoneNumber, Double averageRating, List<MenuModel> menus) {
        this.name = name;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.phoneNumber = phoneNumber;
        this.averageRating = averageRating;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public List<MenuModel> getMenus() {
        return menus;
    }
}

