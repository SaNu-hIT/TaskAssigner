
package com.leeway.athirapb.Activity.Model.AddProject;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AddProjectBean {

    @SerializedName("assign_date")
    private String mAssignDate;
    @SerializedName("client_name")
    private String mClientName;
    @SerializedName("client_phnumber")
    private String mClientPhnumber;
    @SerializedName("estimated_cost")
    private String mEstimatedCost;
    @SerializedName("image_list")
    private List<ImageList> mImageList;
    @SerializedName("pro_desc")
    private String mProDesc;
    @SerializedName("pro_name")
    private String mProName;
    @SerializedName("submission_date")
    private String mSubmissionDate;
    @SerializedName("team_strength")
    private String mTeamStrength;
    @SerializedName("users")
    private List<User> mUsers;

    public String getAssignDate() {
        return mAssignDate;
    }

    public void setAssignDate(String assignDate) {
        mAssignDate = assignDate;
    }

    public String getClientName() {
        return mClientName;
    }

    public void setClientName(String clientName) {
        mClientName = clientName;
    }

    public String getClientPhnumber() {
        return mClientPhnumber;
    }

    public void setClientPhnumber(String clientPhnumber) {
        mClientPhnumber = clientPhnumber;
    }

    public String getEstimatedCost() {
        return mEstimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        mEstimatedCost = estimatedCost;
    }

    public List<ImageList> getImageList() {
        return mImageList;
    }

    public void setImageList(List<ImageList> imageList) {
        mImageList = imageList;
    }

    public String getProDesc() {
        return mProDesc;
    }

    public void setProDesc(String proDesc) {
        mProDesc = proDesc;
    }

    public String getProName() {
        return mProName;
    }

    public void setProName(String proName) {
        mProName = proName;
    }

    public String getSubmissionDate() {
        return mSubmissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        mSubmissionDate = submissionDate;
    }

    public String getTeamStrength() {
        return mTeamStrength;
    }

    public void setTeamStrength(String teamStrength) {
        mTeamStrength = teamStrength;
    }

    public List<User> getUsers() {
        return mUsers;
    }

    public void setUsers(List<User> users) {
        mUsers = users;
    }

}
