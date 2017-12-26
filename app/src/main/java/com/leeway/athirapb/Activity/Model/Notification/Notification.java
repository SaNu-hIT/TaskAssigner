package com.leeway.athirapb.Activity.Model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("notifi_id")
    @Expose
    private Integer notifiId;
    @SerializedName("Content")
    @Expose
    private String content;

    public Integer getNotifiId() {
        return notifiId;
    }

    public void setNotifiId(Integer notifiId) {
        this.notifiId = notifiId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}