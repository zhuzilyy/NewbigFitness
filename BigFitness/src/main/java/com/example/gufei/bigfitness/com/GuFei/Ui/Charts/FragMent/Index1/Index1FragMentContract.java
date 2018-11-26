package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1;

import com.bigkoo.pickerview.TimePickerView;
import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AdddayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.comeSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForDayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.tDailyMemberLessonSumReportBean;

/**
 * Created by GuFei_lyf on 2017/3/22
  * 报表:日报表 接口层
 */

public interface Index1FragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(reportMemberCardSaleSumBean reportDayBean , int  Type);
        void succeed0(reportForDayBean reportForDayBean , int  Type);
        void succeed1(tDailyMemberLessonSumReportBean tDailyMemberLessonSumReportBean , int  Type);
        void succeed2(comeSumReportBean comeSumReportBean , int  Type);
        void succeed3(AddSumReportBean addSumReportBean , int  Type);
        void succeed4(AdddayBean adddayBean , int  Type);
    }

    interface Presenter extends BasePresenter<View> {

        void updata(
                String IsDepartManager  ,
                String personType  ,
                String ClubList  ,
                String UserLevel  ,
                int UserId  ,
                String token  ,
                String SearchDtaa,
                String ReadUserId
            );



    }
}
