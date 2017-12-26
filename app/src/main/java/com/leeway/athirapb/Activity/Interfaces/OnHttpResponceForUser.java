package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.Code;

/**
 * Created by user on 9/8/2017.
 */

public interface OnHttpResponceForUser {
    void OnLoginSuccess(String stautus,Boolean success);
    void OnLoginFaild(Throwable throwable);

    void OnLoginSuccessTrue(String success, boolean b, Code code);
}
