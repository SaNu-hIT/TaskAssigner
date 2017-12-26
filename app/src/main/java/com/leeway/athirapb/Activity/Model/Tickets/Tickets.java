package com.leeway.athirapb.Activity.Model.Tickets;



import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Tickets {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("ticket_info")
    @Expose
    private List<TicketInfo> ticketInfo = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<TicketInfo> getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(List<TicketInfo> ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

}