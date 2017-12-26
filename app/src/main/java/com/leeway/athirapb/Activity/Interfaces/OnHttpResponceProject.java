package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.ProjectInfo;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceProject {
    void OnProjectFaild(String s);

    void OnProjectSuccessTrue(String success, boolean b, List<ProjectInfo> projectInfoList);
}
