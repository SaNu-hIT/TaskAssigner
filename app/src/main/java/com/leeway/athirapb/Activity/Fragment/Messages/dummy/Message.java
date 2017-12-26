
package com.leeway.athirapb.Activity.Fragment.Messages.dummy;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Message {

    @SerializedName("message_id")
    private String mMessageId;
    @SerializedName("message_title")
    private String mMessageTitle;
    @SerializedName("pro_id")
    private String mProId;
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("username")
    private String mUsername;

    public String getMessageId() {
        return mMessageId;
    }

    public void setMessageId(String messageId) {
        mMessageId = messageId;
    }

    public String getMessageTitle() {
        return mMessageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        mMessageTitle = messageTitle;
    }

    public String getProId() {
        return mProId;
    }

    public void setProId(String proId) {
        mProId = proId;
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
