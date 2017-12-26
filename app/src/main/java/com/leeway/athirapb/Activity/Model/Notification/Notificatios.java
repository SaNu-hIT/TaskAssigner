package com.leeway.athirapb.Activity.Model.Notification;

import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Notificatios {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("Notification")
    @Expose
    private List<Notification> notification = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Notification> getNotification() {
        return notification;
    }

    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }

}