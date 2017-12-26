package com.leeway.athirapb.Activity.Interfaces;

/**
 * Created by user on 8/30/2017.
 */

public interface OnHttpResponceForAddNotification {
    void AddNotificationSuccess(String stautus, Boolean success);
    void AddNotificationFaild(Throwable throwable);

    void AddNotificationSuccessTrue(String success, boolean b);
}
