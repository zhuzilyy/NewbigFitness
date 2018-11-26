package com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdForMemberErrBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ReservationRecordMembersActivityContract {

    interface View extends BaseView {

        void succeed(AppointmentByIdForMemberBean appointmentByIdForMemberErrBean);
        void savesucceed(CodeBean codeBean);

        void outLogin();


    }

    interface Presenter extends BasePresenter<View> {

        void getAppointmentByIdForMember(
                int UserId  ,String token  ,int ClubId  ,String AppointmentId  ,String appType  ,String MemberId);
        //        void appAddCustomerAppoint(
//                String UserName,
//                int UserId,
//                String token,
//                int ClubId,
//                String AppointmentTypeId,
//                String Content,
//                String CustomerId,
//                String EndTime,
//                String StartTime,
//                String Tipinterval,
//                String Tipstarttime,
//                String AppointmentId);
//
        void  saveMemberAppiontment(String UserName, int UserId, String token, int ClubId, String appointType, String AppointmentTypeId, String Content, String MemberId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String LessonId, String PlanInfo,String IsMakeUp, String AppointmentId);

        void saveAppointmentResultForMember(
                int UserId,
                String token,
                int ClubId,
                String UserName,
                String AppointmentId,
                String AppointmentResultId,
                String appType);


    }
}
