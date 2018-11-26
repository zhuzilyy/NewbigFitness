package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthAddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberLessonSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthSalesReportByLabelIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ReportMonthComeSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.comeSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMonthMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.tDailyMemberLessonSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.google.gson.Gson;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:月报表 P层
 */

public class Index2FragMentPresenter extends RxPresenter<Index2FragMentContract.View> implements Index2FragMentContract.Presenter {


    private Api api;


    @Inject
    public Index2FragMentPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void updata(String IsDepartManager, String personType, String ClubList, String UserLevel, int UserId, String token, String SearchData, String ReadUserId,String ClubId) {

//
//        Subscription subscription0 = api.reportForMonth(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)
//
//                .compose(RxUtil.<reportForMonthBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<reportForMonthBean>() {
//                    @Override
//                    public void call(reportForMonthBean normalResponse) {
//
//                        mView.showError(new Gson().toJson(normalResponse));
//                        if (normalResponse.getCode() == 0) {
//
//                            mView.succeed0(normalResponse);
//                        } else if (normalResponse.getCode() == 250) {
//                            mView.outLogin();
//                        } else {
//
//                        }
//
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
//                        mView.showError(ErrMessages);
//
//
//                    }
//                });
//        addSubscription(subscription0);



        Subscription subscription0 = api.reportMonthMemberCardSaleSum(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<reportMonthMemberCardSaleSumBean>rxSchedulerHelper())

                .subscribe(new Action1<reportMonthMemberCardSaleSumBean>() {
                    @Override
                    public void call(reportMonthMemberCardSaleSumBean normalResponse) {


                        if (normalResponse.getCode() == 0) {

                            mView.succeed(normalResponse);
                        } else if (normalResponse.getCode() == 250) {
                            mView.outLogin();
                        } else {
                            mView.showError(new Gson().toJson(normalResponse));
                        }


                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        mView.showError(ErrMessages);


                    }
                });
        addSubscription(subscription0);



        Subscription subscription1 = api.getMonthMemberLessonSumReport(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<MonthMemberLessonSumReportBean>rxSchedulerHelper())

                .subscribe(new Action1<MonthMemberLessonSumReportBean>() {
                    @Override
                    public void call(MonthMemberLessonSumReportBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed1(normalResponse);
                        } else if (normalResponse.getCode() == 250) {
                            mView.outLogin();
                        } else {

                        }


                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        mView.showError(ErrMessages);


                    }
                });
        addSubscription(subscription1);




        Subscription subscription2 = api.getReportMonthComeSum(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<ReportMonthComeSumBean>rxSchedulerHelper())

                .subscribe(new Action1<ReportMonthComeSumBean>() {
                    @Override
                    public void call(ReportMonthComeSumBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed2(normalResponse);
                        } else if (normalResponse.getCode() == 250) {
                            mView.outLogin();
                        } else {

                        }


                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        mView.showError(ErrMessages);


                    }
                });
        addSubscription(subscription2);

        Subscription subscription3 = api.getMonthAddSumReport(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<MonthAddSumReportBean>rxSchedulerHelper())

                .subscribe(new Action1<MonthAddSumReportBean>() {
                    @Override
                    public void call(MonthAddSumReportBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {
                            mView.succeed3(normalResponse);
                        } else if (normalResponse.getCode() == 250) {
                            mView.outLogin();
                        } else {

                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        mView.showError(ErrMessages);


                    }
                });
        addSubscription(subscription3);





        Subscription subscription5 = api.getMonthSalesReportByLabelId(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId,ClubId)

                .compose(RxUtil.<MonthSalesReportByLabelIdBean>rxSchedulerHelper())

                .subscribe(new Action1<MonthSalesReportByLabelIdBean>() {
                    @Override
                    public void call(MonthSalesReportByLabelIdBean normalResponse) {
                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {
                            mView.succeed5(normalResponse);
                        } else if (normalResponse.getCode() == 250) {
                            mView.outLogin();
                        } else {

                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError(ErrMessages);
                    }
                });
        addSubscription(subscription5);


    }


}