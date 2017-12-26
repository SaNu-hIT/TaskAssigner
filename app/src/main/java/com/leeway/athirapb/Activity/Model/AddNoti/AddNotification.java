package com.leeway.athirapb.Activity.Model.AddNoti;

/**
 * Created by intellyelabs on 19/09/17.
 */


import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class AddNotification {

    @SerializedName("status")
    @Expose
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}