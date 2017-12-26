package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Model.ProjectInfo;
import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceTickets {
    void OnTicketsFaild(String s);

    void OnTicketsSuccessTrue(String success, boolean b, List<TicketInfo> ticketsInfoList);
}
