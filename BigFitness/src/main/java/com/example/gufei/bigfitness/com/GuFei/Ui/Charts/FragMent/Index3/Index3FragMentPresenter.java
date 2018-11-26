package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberNumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.google.gson.Gson;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:统计报表 P层
 */



public class Index3FragMentPresenter extends RxPresenter<Index3FragMentContract.View> implements Index3FragMentContract.Presenter {


    private Api api;


    @Inject
    public Index3FragMentPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void updata(String IsDepartManager, String personType, String ClubList, String UserLevel, int UserId, String TeacherId, String ManagerId, String token, String SearchData) {
        Subscription subscription = api.getMemberNumReport(IsDepartManager  ,personType  ,ClubList  ,UserLevel  ,UserId  ,token,TeacherId,ManagerId,SearchData)

                .compose(RxUtil.<MemberNumReportBean>rxSchedulerHelper())

                .subscribe(new Action1<MemberNumReportBean>() {
                    @Override
                    public void call(MemberNumReportBean normalResponse) {

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
}