
package com.leeway.athirapb.Activity.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ProjectImage {

    @SerializedName("Ids")
    private String mIds;
    @SerializedName("news_imageurl")
    private String mNewsImageurl;

    public String getIds() {
        return mIds;
    }

    public void setIds(String Ids) {
        mIds = Ids;
    }

    public String getNewsImageurl() {
        return mNewsImageurl;
    }

    public void setNewsImageurl(String newsImageurl) {
        mNewsImageurl = newsImageurl;
    }

}
