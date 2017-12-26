package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.ListUser.Userinfo;
import com.leeway.athirapb.Activity.Model.Notification.Notification;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceListUser {
    void OnListUserFail(String s);

    void OnListUserSuccessTrue(String success, boolean b, List<Userinfo> ticketsInfoList);
}
