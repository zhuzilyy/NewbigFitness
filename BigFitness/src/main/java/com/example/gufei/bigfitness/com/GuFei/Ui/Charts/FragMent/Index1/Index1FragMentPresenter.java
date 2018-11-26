package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AdddayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.comeSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForDayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.tDailyMemberLessonSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.google.gson.Gson;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:日报表 P层
 */

public class Index1FragMentPresenter extends RxPresenter<Index1FragMentContract.View> implements Index1FragMentContract.Presenter {


    private Api api;


    @Inject
    public Index1FragMentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updata(String IsDepartManager, String personType, String ClubList, String UserLevel, int UserId, String token, String SearchData, String ReadUserId) {

        Subscription subscription = api.reportMemberCardSaleSum(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<reportMemberCardSaleSumBean>rxSchedulerHelper())

                .subscribe(new Action1<reportMemberCardSaleSumBean>() {
                    @Override
                    public void call(reportMemberCardSaleSumBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed(normalResponse,0);
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
        addSubscription(subscription);



        Subscription subscription1 = api.getDailyMemberLessonSumReport(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<tDailyMemberLessonSumReportBean>rxSchedulerHelper())

                .subscribe(new Action1<tDailyMemberLessonSumReportBean>() {
                    @Override
                    public void call(tDailyMemberLessonSumReportBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed1(normalResponse,1);
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

        Subscription subscription2 = api.comeSumReport(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<comeSumReportBean>rxSchedulerHelper())

                .subscribe(new Action1<comeSumReportBean>() {
                    @Override
                    public void call(comeSumReportBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed2(normalResponse,1);
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

        Subscription subscription3 = api.getAddSumReport(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ReadUserId)

                .compose(RxUtil.<AddSumReportBean>rxSchedulerHelper())

                .subscribe(new Action1<AddSumReportBean>() {
                    @Override
                    public void call(AddSumReportBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed3(normalResponse,1);
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
        Subscription subscription4 = api.getDayAddCustomerReportForManager(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData)
                .compose(RxUtil.<AdddayBean>rxSchedulerHelper())
                .subscribe(new Action1<AdddayBean>() {
                    @Override
                    public void call(AdddayBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed4(normalResponse,1);
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
        addSubscription(subscription4);
    }
}