package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberNumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherLessonRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.google.gson.Gson;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:排名 P层
 */
public class Index4FragMentPresenter extends RxPresenter<Index4FragMentContract.View> implements Index4FragMentContract.Presenter {


    private Api api;


    @Inject
    public Index4FragMentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getMonthMemberRanking(String IsDepartManager, String personType, String ClubList, String UserLevel, int UserId, String token, String SearchData) {
        Subscription subscription = api.getMonthMemberRanking(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData)

                .compose(RxUtil.<MonthMemberRankingBean>rxSchedulerHelper())

                .subscribe(new Action1<MonthMemberRankingBean>() {
                    @Override
                    public void call(MonthMemberRankingBean normalResponse) {

                        mView.showError(new Gson().toJson(normalResponse));
                        if (normalResponse.getCode() == 0) {

                            mView.succeed(normalResponse);
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
    }

    @Override
    public void getMonthTeacherRanking(String IsDepartManager, String personType, String ClubList, String UserLevel, int UserId, String token, String SearchData) {
        Subscription subscription = api.getMonthTeacherRanking(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData)

                .compose(RxUtil.<MonthTeacherRankingBean>rxSchedulerHelper())

                .subscribe(new Action1<MonthTeacherRankingBean>() {
                    @Override
                    public void call(MonthTeacherRankingBean normalResponse) {

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
        addSubscription(subscription);
    }

    @Override
    public void getMonthTeacherLessonRanking(String IsDepartManager, String personType, String ClubList, String UserLevel, int UserId, String token, String SearchData,int ClubId) {
        Subscription subscription = api.getMonthTeacherLessonRanking(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,SearchData,ClubId)

                .compose(RxUtil.<MonthTeacherLessonRankingBean>rxSchedulerHelper())

                .subscribe(new Action1<MonthTeacherLessonRankingBean>() {
                    @Override
                    public void call(MonthTeacherLessonRankingBean normalResponse) {

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
        addSubscription(subscription);
    }
}