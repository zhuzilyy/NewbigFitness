package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateForOrderBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ClassOverBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.IndexData;


public interface ListContract {

    interface View extends BaseView {

        void outLogin();

        void succeed(AppointmentListByDateForOrderBean appointmentListByDateForOrderBean);

        void classsucceed(ClassOverBean classOverBean);

        void cancelsucceed(CodeBean codeBean);

        void confirmsucceed(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getAppointmentListByDateForOrder(
                int UserId  ,String token  ,int ClubId  ,String IsDepartManager  ,String date   ,int CurrentPage, int IsHistory, String doType
        );

        //下课
        void getClassOver( int AppointmentId, int ClubId, int MemberId, String token);

        //取消预约
        void getCancelLesson( int AppointmentId, String token);

        //确认预约
        void getConfirmLesson( int AppointmentId, String token);
    }

}
