package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AddMebersAppointmentActivityContract {



    interface View extends BaseView {     void outLogin();

        /**
         * 登录成功
         */
        void succeed(CodeBean codeBean);
        void unsucceed(CodeBean codeBean);
        void SaveSucceed(CodeBean codeBean);
//
//        /**
//         * 保存帐号密码
//         */
//        void remember(String account, String password);
//
//        /**
//         * 移除保存
//         */
//        void remove();

    }

    interface Presenter extends BasePresenter<View> {

        //        void login(String userName,String passWord);
//        void get(String type);

        void  saveMemberAppiontment(String UserName, int UserId, String token, int ClubId, String appointType, String AppointmentTypeId, String Content, String MemberId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String LessonId, String PlanInfo,String IsMakeUp, String AppointmentId);

        void saveAppointmentResultForMember(
                int UserId  ,String token  ,int ClubId  ,String UserName  ,String AppointmentId  ,String AppointmentResultId  ,String appType);
        void  appAddCustomerAppoint( String UserName  ,
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
    }


}
