package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.Notification.Notification;
import com.leeway.athirapb.Activity.Model.Notification.Notificatios;
import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceNotification {
    void OnNotificationFail (String s);

    void OnNotificationSuccessTrue(String success, boolean b, List<Notification> ticketsInfoList);
}
