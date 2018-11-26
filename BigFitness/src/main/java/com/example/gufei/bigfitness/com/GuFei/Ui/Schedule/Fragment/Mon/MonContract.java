package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon;



import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.IndexData;

/**
 * Description
 *
 * @author GuFei
 * @version 2016 10 12 16:05
 */

public interface MonContract {

    interface View extends BaseView {

        void outLogin();

        /**
         * 加载首页数据
         * @param appointmentListByMonthBean
         */
        void loadData(AppointmentListByMonthBean appointmentListByMonthBean);
        void loadList(AppointmentListByDateBean appointmentListByDateBean);



//        /**
//         * 修改城市名称
//         * @param name
//         */
//        void updateCity(String name);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 首页初始化
         */
        void getAppointmentListByMonth(

                int UserId  ,String token  ,int ClubId  ,String IsDepartManager  ,String date
        );

  void getAppointmentListByDate(

                 int UserId  ,String token  ,int ClubId  ,String IsDepartManager  ,String date
        );



    }

}
