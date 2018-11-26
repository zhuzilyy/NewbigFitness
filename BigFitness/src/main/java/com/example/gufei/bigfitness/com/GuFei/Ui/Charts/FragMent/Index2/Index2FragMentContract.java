package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthAddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberLessonSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthSalesReportByLabelIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ReportMonthComeSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMonthMemberCardSaleSumBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:月报表 接口
 */


public interface Index2FragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(reportMonthMemberCardSaleSumBean reportMonthMemberCardSaleSumBean);
        void succeed0(reportForMonthBean reportForMonthBean);
//        void succeedReportMonthMemberCardSaleSum(reportMonthMemberCardSaleSumBean reportMonthMemberCardSaleSum);
        void succeed1(MonthMemberLessonSumReportBean monthMemberLessonSumReportBean);
        void succeed2(ReportMonthComeSumBean reportMonthComeSumBean);

        void succeed3(MonthAddSumReportBean monthAddSumReportBean);
        void succeed4(MonthAddSumReportBean MonthAddSumReportBean);
        void succeed5(MonthSalesReportByLabelIdBean monthSalesReportByLabelIdBean);

        void MainPagesucceed(SineForMainPageBean sineForMainPageBean);

    }

    interface Presenter extends BasePresenter<View> {
        void updata(
                String IsDepartManager  ,
                String personType  ,
                String ClubList  ,
                String UserLevel  ,
                int UserId  ,
                String token  ,
                String SearchData,
                String ReadUserId,
                String ClubId
                );
    }
}
