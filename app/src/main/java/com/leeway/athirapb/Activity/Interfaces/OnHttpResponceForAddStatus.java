package com.leeway.athirapb.Activity.Interfaces;

/**
 * Created by user on 8/30/2017.
 */

public interface OnHttpResponceForAddStatus {
    void AddAddStatusSuccess(String stautus, Boolean success);
    void AddAddStatusFaild(Throwable throwable);

    void AddAddStatusSuccessTrue(String success, boolean b);
}
