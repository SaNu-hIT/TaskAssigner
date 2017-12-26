
package com.leeway.athirapb.Activity.Model;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ProjectList {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("project_info")
    @Expose
    private List<ProjectInfo> projectInfo = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProjectInfo> getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(List<ProjectInfo> projectInfo) {
        this.projectInfo = projectInfo;
    }

}
