package com.leeway.athirapb.Activity.Interfaces;



import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.Message;

import java.util.List;

/**
 * Created by user on 9/12/2017.
 */

public interface OnHttpResponceListStatus {
    void OnListStatusFaild(String s);

    void OnListStatusSuccessTrue(String success, boolean b, List<Message> ticketsInfoList);
}
