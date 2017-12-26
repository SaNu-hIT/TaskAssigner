
package com.leeway.athirapb.Activity.Fragment.LeaveListing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Message {

    @SerializedName("joining_date")
    private String mJoiningDate;
    @SerializedName("leave_date")
    private String mLeaveDate;
    @SerializedName("leave_days")
    private String mLeaveDays;
    @SerializedName("leave_desc")
    private String mLeaveDesc;
    @SerializedName("leave_id")
    private String mLeaveId;
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("username")
    private String mUsername;

    public String getJoiningDate() {
        return mJoiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        mJoiningDate = joiningDate;
    }

    public String getLeaveDate() {
        return mLeaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        mLeaveDate = leaveDate;
    }

    public String getLeaveDays() {
        return mLeaveDays;
    }

    public void setLeaveDays(String leaveDays) {
        mLeaveDays = leaveDays;
    }

    public String getLeaveDesc() {
        return mLeaveDesc;
    }

    public void setLeaveDesc(String leaveDesc) {
        mLeaveDesc = leaveDesc;
    }

    public String getLeaveId() {
        return mLeaveId;
    }

    public void setLeaveId(String leaveId) {
        mLeaveId = leaveId;
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
