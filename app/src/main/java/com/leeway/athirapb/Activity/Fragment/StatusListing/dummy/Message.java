
package com.leeway.athirapb.Activity.Fragment.StatusListing.dummy;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Message {

    @SerializedName("cur_date")
    private String mCurDate;
    @SerializedName("status_desc")
    private String mStatusDesc;
    @SerializedName("status_id")
    private String mStatusId;
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("username")
    private String mUsername;

    public String getCurDate() {
        return mCurDate;
    }

    public void setCurDate(String curDate) {
        mCurDate = curDate;
    }

    public String getStatusDesc() {
        return mStatusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        mStatusDesc = statusDesc;
    }

    public String getStatusId() {
        return mStatusId;
    }

    public void setStatusId(String statusId) {
        mStatusId = statusId;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
