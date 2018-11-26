package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PrivateLessonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class PrivateLesssonActivityPresenter extends RxPresenter<PrivateLesssonActivityContract.View> implements PrivateLesssonActivityContract.Presenter {


    private Api api;


    @Inject
    public PrivateLesssonActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getLessonInfoById(String UserName, int UserId, String token, int ClubId, int Id) {
        Subscription subscription = api.getLessonInfoById(UserName, UserId, token, ClubId, Id)

                .compose(RxUtil.<PrivateLessonInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<PrivateLessonInfoBean>() {
                    @Override
                    public void call(PrivateLessonInfoBean normalResponse) {


                        if (normalResponse.getCode() == 0) {

                            mView.succeed(normalResponse);


                        } else if (normalResponse.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(normalResponse.getMessage().toString());
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