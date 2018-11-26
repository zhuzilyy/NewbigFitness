package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherLessonRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:排名 接口
 */

public interface Index4FragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(MonthMemberRankingBean monthMemberRankingBean);
        void succeed1(MonthTeacherRankingBean monthTeacherRankingBean);
        void succeed2(MonthTeacherLessonRankingBean monthTeacherLessonRankingBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getMonthMemberRanking(
                String IsDepartManager  ,
                String personType  ,
                String ClubList  ,
                String UserLevel  ,
                int UserId  ,
                String token  ,
                String SearchData);


    void getMonthTeacherRanking(
                String IsDepartManager  ,
                String personType  ,
                String ClubList  ,
                String UserLevel  ,
                int UserId  ,
                String token  ,
                String SearchData);

    void getMonthTeacherLessonRanking(
                String IsDepartManager  ,
                String personType  ,
                String ClubList  ,
                String UserLevel  ,
                int UserId  ,
                String token  ,
                String SearchData,int ClubId);




    }
}
