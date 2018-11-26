package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ReservationRecordActivityContract {

    interface View extends BaseView {

        void succeed(AppointmentByIdBean appointmentByIdBean);
        void savesucceed(CodeBean codeBean);

        void outLogin();


    }

    interface Presenter extends BasePresenter<View> {

        void getAppointmentById(String UserName, int UserId, String token, int ClubId,  String CustomerId,String AppointmentId);
        void appAddCustomerAppoint(
                String UserName  ,
                int UserId  ,
                String token  ,
                int ClubId  ,
                String AppointmentTypeId  ,
                String Content  ,
                String CustomerId  ,
                String EndTime  ,
                String StartTime  ,
                String Tipinterval  ,
                String Tipstarttime  ,
                String AppointmentId);


    void saveAppointmentResultForCustomer(
            int UserId  ,
            String token  ,
            int ClubId  ,
            String UserName  ,
            String AppointmentId  ,
            String AppointmentResultId  ,
            String appType);


    }
}
