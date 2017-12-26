
package com.leeway.athirapb.Activity.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LoginStatus {

    @SerializedName("code")
    private Code mCode;
    @SerializedName("status")
    private Status mStatus;

    public Code getCode() {
        return mCode;
    }

    public void setCode(Code code) {
        mCode = code;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
