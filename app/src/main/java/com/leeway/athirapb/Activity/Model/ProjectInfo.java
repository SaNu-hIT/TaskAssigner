
package com.leeway.athirapb.Activity.Model;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ProjectInfo {

    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("pro_name")
    @Expose
    private String proName;
    @SerializedName("pro_desc")
    @Expose
    private String proDesc;
    @SerializedName("assign_date")
    @Expose
    private String assignDate;
    @SerializedName("submission_date")
    @Expose
    private String submissionDate;
    @SerializedName("team_strength")
    @Expose
    private String teamStrength;
    @SerializedName("client_name")
    @Expose
    private String clientName;
    @SerializedName("client_phnumber")
    @Expose
    private String clientPhnumber;
    @SerializedName("estimated_cost")
    @Expose
    private String estimatedCost;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("project_Image")
    @Expose
    private List<ProjectImage> projectImage = null;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(String teamStrength) {
        this.teamStrength = teamStrength;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhnumber() {
        return clientPhnumber;
    }

    public void setClientPhnumber(String clientPhnumber) {
        this.clientPhnumber = clientPhnumber;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ProjectImage> getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(List<ProjectImage> projectImage) {
        this.projectImage = projectImage;
    }

}
