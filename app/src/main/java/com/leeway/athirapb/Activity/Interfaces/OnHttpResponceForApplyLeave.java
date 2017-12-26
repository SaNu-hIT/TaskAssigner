package com.leeway.athirapb.Activity.Interfaces;

/**
 * Created by user on 8/30/2017.
 */

public interface OnHttpResponceForApplyLeave {
    void AddApplyLeaveSuccess(String stautus, Boolean success);
    void AddApplyLeaveFaild(Throwable throwable);

    void AddApplyLeaveSuccessTrue(String success, boolean b);
}
