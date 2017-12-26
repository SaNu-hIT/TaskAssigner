package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Fragment.LeaveListing.Message;
import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceListLeave {
    void OnListLeaveFaild(String s);

    void OnListLeaveSuccessTrue(String success, boolean b, List<Message> ticketsInfoList);
}
