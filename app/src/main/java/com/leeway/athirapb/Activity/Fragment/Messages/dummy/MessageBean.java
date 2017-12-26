
package com.leeway.athirapb.Activity.Fragment.Messages.dummy;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MessageBean {

    @SerializedName("message")
    private List<Message> mMessage;
    @SerializedName("status")
    private Status mStatus;

    public List<Message> getMessage() {
        return mMessage;
    }

    public void setMessage(List<Message> message) {
        mMessage = message;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
