package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.appMemberNumReportDetailListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ChartsListActivityPresenter extends RxPresenter<ChartsListActivityContract.View> implements ChartsListActivityContract.Presenter {


    private Api api;


    @Inject
    public ChartsListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appMemberNumReportDetailList(int UserId, String token, int ClubId, int IsDepartManager, int departId, String ClubList, String UserLevel, int CurrentPage, int Type, String sort, String order, String TeacherId, String ManagerId, String Sex, String StartCardCreateTime, String EndCardCreateTime, String StartLastContactTime, String EndLastContactTime, String StartExpireTime, String EndExpireTime, String StartLessonCreateTime, String EndLessonCreateTime, String StartLessonStopTime, String EndLessonStopTime, String StartLessonBalance, String EndLessonBalance) {
        Subscription subscription = api.appMemberNumReportDetailList( UserId  ,token  ,ClubId  ,IsDepartManager ,departId  ,ClubList  ,UserLevel  ,CurrentPage  ,Type  ,sort  ,order  ,TeacherId  ,ManagerId  ,Sex  ,StartCardCreateTime  ,EndCardCreateTime  ,StartLastContactTime  ,EndLastContactTime  ,StartExpireTime  ,EndExpireTime  ,StartLessonCreateTime  ,EndLessonCreateTime  ,StartLessonStopTime  ,EndLessonStopTime  ,StartLessonBalance  ,EndLessonBalance)

                .compose(RxUtil.<appMemberNumReportDetailListBean>rxSchedulerHelper())

                .subscribe(new Action1<appMemberNumReportDetailListBean>() {
                    @Override
                    public void call(appMemberNumReportDetailListBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        system.out.print(normalresponse.geturl());


                            mView.succeed(normalResponse);

                        }        if (normalResponse.getCode()==250){

                            mView.outLogin();

                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

//                        mView.showError(ErrMessages);+


                    }
                });
        addSubscription(subscription);
    }
}