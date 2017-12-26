package com.leeway.athirapb.Activity.Interfaces;

import com.leeway.athirapb.Activity.Fragment.Messages.dummy.Message;
import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceMessage {
    void OnMessageFaild(String s);

    void OnMessageSuccessTrue(String success, boolean b, List<Message> ticketsInfoList);
}
