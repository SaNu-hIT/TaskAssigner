package com.leeway.athirapb.Activity.Interfaces;

/**
 * Created by user on 8/30/2017.
 */

public interface OnHttpResponceForAddProject {
    void AddProjectSuccess(String stautus, Boolean success);
    void AddProjectFaild(Throwable throwable);

    void AddProjectSuccessTrue(String success, boolean b);
}
