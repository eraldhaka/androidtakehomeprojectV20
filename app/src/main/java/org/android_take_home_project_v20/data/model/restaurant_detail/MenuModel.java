package org.android_take_home_project_v20.data.model.restaurant_detail;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Erald Haka.
 */
public class MenuModel {

    @SerializedName("name")
    private String name;

    @SerializedName("subtitle")
    private String subtitle;

    @SerializedName("status")
    private String status;

    @SerializedName("status_type")
    private String status_type;

    public MenuModel(String name, String subtitle, String status, String status_type) {
        this.name = name;
        this.subtitle = subtitle;
        this.status = status;
        this.status_type = status_type;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusType() {
        return status_type;
    }
}
