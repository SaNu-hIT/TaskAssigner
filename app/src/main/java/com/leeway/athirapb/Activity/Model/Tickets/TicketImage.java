package com.leeway.athirapb.Activity.Model.Tickets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketImage {

    @SerializedName("Ids")
    @Expose
    private String ids;
    @SerializedName("news_imageurl")
    @Expose
    private String newsImageurl;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getNewsImageurl() {
        return newsImageurl;
    }

    public void setNewsImageurl(String newsImageurl) {
        this.newsImageurl = newsImageurl;
    }

}