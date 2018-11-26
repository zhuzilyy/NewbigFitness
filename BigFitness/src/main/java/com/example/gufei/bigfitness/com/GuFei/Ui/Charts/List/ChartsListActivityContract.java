package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.appMemberNumReportDetailListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ChartsListActivityContract {

    interface View extends BaseView {

        void outLogin();

        void succeed(appMemberNumReportDetailListBean appMemberNumReportDetailListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void appMemberNumReportDetailList(
                int UserId  ,
                String token  ,
                int ClubId  ,
                int IsDepartManager  ,
                int departId  ,
                String ClubList  ,
                String UserLevel  ,
                int CurrentPage  ,
                int Type  ,
                String sort  ,
                String order  ,
                String TeacherId  ,
                String ManagerId  ,
                String Sex  ,
                String StartCardCreateTime  ,
                String EndCardCreateTime  ,
                String StartLastContactTime  ,
                String EndLastContactTime  ,
                String StartExpireTime  ,
                String EndExpireTime  ,
                String StartLessonCreateTime  ,
                String EndLessonCreateTime  ,
                String StartLessonStopTime  ,
                String EndLessonStopTime  ,
                String StartLessonBalance  ,
                String EndLessonBalance
        );

//        void appMemberNumReportDetailList(int Type  ,
//                                          String Sex  ,
//                                          String ManagerId  ,
//                                          String TeacherId  ,
//                                          String StartCardCreateTime  ,
//                                          String EndCardCreateTime  ,
//                                          String StartLastContactTinme  ,
//                                          String EndLastContactTime  ,
//                                          String StartExpireTime  ,
//                                          String EndExpireTime  ,
//                                          String StartLessonCreateTIme  ,
//                                          String EndLessonCreateTime  ,
//                                          String StartLessonStopTime  ,
//                                          String EndLessonStopTime  ,
//                                          String StartLessonBalance  ,
//                                          String EndLessonBalance  ,
//                                          String personType  ,
//                                          String ClubList  ,
//                                          int UserId  ,
//                                          String IsDepartManager  ,
//                                          String sort  ,
//                                          String order);



    }



}
