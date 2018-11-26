package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CompleteLessonListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberBodyReportListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface LessonReportDocumentsListActivityContract {



    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(CompleteLessonListBean completeLessonListBean);
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
        void getCompleteLessonList(
                int UserId  ,
                String token  ,
                int ClubId  ,
                String MemberId  ,
                int CurrentPage  ,
                String LessonType  ,
                String LessonName  ,
                String TeacherId  ,
                String StartDate  ,
                String EndDate
        );
//        void getLessonInfoFromApponitment(
//                int UserId  ,
//                String token  ,
//                int ClubId  ,
//                String MemberId  ,
//                String LessonType  ,
//                String AppointmentId
//        );

    }
}
