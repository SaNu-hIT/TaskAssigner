
package com.leeway.athirapb.Activity.Model.ListUser;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ListUserModel {

    @SerializedName("status")
    private Status mStatus;
    @SerializedName("userinfo")
    private List<Userinfo> mUserinfo;

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public List<Userinfo> getUserinfo() {
        return mUserinfo;
    }

    public void setUserinfo(List<Userinfo> userinfo) {
        mUserinfo = userinfo;
    }

}
