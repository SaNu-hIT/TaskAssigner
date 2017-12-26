
package com.leeway.athirapb.Activity.Model.SendJson;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SendTickets {

    @SerializedName("assign_date")
    private String mAssignDate;
    @SerializedName("image_list")
    private List<ImageList> mImageList;
    @SerializedName("priority")
    private String mPriority;
    @SerializedName("pro_id")
    private String mProId;
    @SerializedName("submission_date")
    private String mSubmissionDate;
    @SerializedName("ticket_desc")
    private String mTicketDesc;
    @SerializedName("ticket_heading")
    private String mTicketHeading;
    @SerializedName("userId")
    private String mUserId;

    public String getAssignDate() {
        return mAssignDate;
    }

    public void setAssignDate(String assignDate) {
        mAssignDate = assignDate;
    }

    public List<ImageList> getImageList() {
        return mImageList;
    }

    public void setImageList(List<ImageList> imageList) {
        mImageList = imageList;
    }

    public String getPriority() {
        return mPriority;
    }

    public void setPriority(String priority) {
        mPriority = priority;
    }

    public String getProId() {
        return mProId;
    }

    public void setProId(String proId) {
        mProId = proId;
    }

    public String getSubmissionDate() {
        return mSubmissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        mSubmissionDate = submissionDate;
    }

    public String getTicketDesc() {
        return mTicketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        mTicketDesc = ticketDesc;
    }

    public String getTicketHeading() {
        return mTicketHeading;
    }

    public void setTicketHeading(String ticketHeading) {
        mTicketHeading = ticketHeading;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

}
