package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.Code;

/**
 * Created by user on 8/30/2017.
 */

public interface OnHttpResponceForAddNews {
    void AddNewsSuccess(String stautus, Boolean success);
    void AddNewsFaild(Throwable throwable);

    void AddNewsSuccessTrue(String success, boolean b);
}
