package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.Code;

import java.util.List;

/**
 * Created by user on 8/30/2017.
 */

public interface OnHttpResponceForLogin {
    void OnLoginSuccess(String stautus,Boolean success);
    void OnLoginFaild(Throwable throwable);

    void OnLoginSuccessTrue(String success, boolean b, Code code);
}
