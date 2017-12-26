package com.leeway.athirapb.Activity.Model.Tickets;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketInfo {

    @SerializedName("ticket_id")
    @Expose
    private String ticketId;
    @SerializedName("ticket_heading")
    @Expose
    private String ticketHeading;
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("ticket_desc")
    @Expose
    private String ticketDesc;
    @SerializedName("assign_date")
    @Expose
    private String assignDate;
    @SerializedName("submission_date")
    @Expose
    private String submissionDate;
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("open_close")
    @Expose
    private String openClose;
    @SerializedName("Ticket_Image")
    @Expose
    private List<TicketImage> ticketImage = null;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketHeading() {
        return ticketHeading;
    }

    public void setTicketHeading(String ticketHeading) {
        this.ticketHeading = ticketHeading;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getOpenClose() {
        return openClose;
    }

    public void setOpenClose(String openClose) {
        this.openClose = openClose;
    }

    public List<TicketImage> getTicketImage() {
        return ticketImage;
    }

    public void setTicketImage(List<TicketImage> ticketImage) {
        this.ticketImage = ticketImage;
    }

}