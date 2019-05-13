package org.android_take_home_project_v20.data.model.restaurant_data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Erald Haka.
 */
public class DataModel {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("cover_img_url")
    private String coverImageUrl;

    @SerializedName("status")
    private String status;

    @SerializedName("delivery_fee")
    private Integer deliveryFee;


    public DataModel(Integer id, String name, String description, String coverImageUrl, String status, Integer deliveryFee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.status = status;
        this.deliveryFee = deliveryFee;
    }

    public Integer getId() {
        return id;
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

    public String getStatus() {
        return status;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

}
