
package com.leeway.athirapb.Activity.Model.SendJson;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ImageList {

    @SerializedName("fileName")
    private String mFileName;
    @SerializedName("imagedata")
    private String mImagedata;

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public String getImagedata() {
        return mImagedata;
    }

    public void setImagedata(String imagedata) {
        mImagedata = imagedata;
    }

}
