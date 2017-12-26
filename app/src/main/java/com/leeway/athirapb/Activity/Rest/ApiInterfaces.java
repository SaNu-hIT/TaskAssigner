package com.leeway.athirapb.Activity.Rest;


import com.leeway.athirapb.Activity.Fragment.LeaveListing.LeaveListStatus;
import com.leeway.athirapb.Activity.Fragment.Messages.dummy.MessageBean;
import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.StatusBeanList;
import com.leeway.athirapb.Activity.Model.AddNoti.AddNotification;
import com.leeway.athirapb.Activity.Model.AddProject.AddProjectBean;
import com.leeway.athirapb.Activity.Model.CreateUser;
import com.leeway.athirapb.Activity.Model.ListUser.ListUserModel;
import com.leeway.athirapb.Activity.Model.LoginStatus;
import com.leeway.athirapb.Activity.Model.Notification.Notificatios;
import com.leeway.athirapb.Activity.Model.ProjectList;
import com.leeway.athirapb.Activity.Model.SendJson.SendTickets;
import com.leeway.athirapb.Activity.Model.Status;
import com.leeway.athirapb.Activity.Model.Tickets.Tickets;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface ApiInterfaces {
//
    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginStatus> loginUser(@Field("username") String uername, @Field("password") String passoword);

    @FormUrlEncoded
    @POST("AddNotification")
    Call<AddNotification> addNews(@Field("Content") String message);

    @FormUrlEncoded
    @POST("createusers")
    Call<CreateUser> createusers(@Field("email") String mail, @Field("username") String username,@Field("password")String password,@Field("phone") String phone);


//    @FormUrlEncoded
//    @POST("create_project_json")
//    Call<Project> getProject();
    @FormUrlEncoded
   @POST("list_projects")
  Call<ProjectList> getProject(@Field("userId") String userid,@Field("pro_id") String project_id);

    @FormUrlEncoded
    @POST("list_tickets")
    Call<Tickets> getTickets(@Field("userId") String project_id,@Field("open_close")String openorclose);
     @FormUrlEncoded
    @POST("leaveDue")
    Call<AddNotification> AddLeave(@Field("userId") String userid,@Field("leave_desc")String leave_desc,@Field("leave_date") String leave_date,@Field("joining_date")String joining_date,@Field("leave_days")String leave_days);

    @FormUrlEncoded
    @POST("statusupdate")
    Call<AddNotification> AddStatus(@Field("userId") String userid,@Field("status_title")String status_title,@Field("status_desc") String status_desc,@Field("cur_date")String cur_date);


    @POST("listnotification")
    Call<Notificatios> getNotification();

    @POST("listusers")
    Call<ListUserModel> getUser();


    @POST("listleaves")
    Call<LeaveListStatus> getLeave();

    @POST("liststatus")
    Call<StatusBeanList> getStatus();


    @FormUrlEncoded
    @POST("listmessage")
    Call<MessageBean> getMessage(@Field("userId") String project_id);

    @POST("create_ticket_json")
    Call<AddNotification> AddTickets(@Body SendTickets sendTickets);

    @POST("create_project_json")
    Call<AddNotification> addProject(@Body AddProjectBean addProjectBean);




}
