package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.StarEvaluateBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class AppraiseActivityPresenter extends RxPresenter<AppraiseActivityContract.View> implements AppraiseActivityContract.Presenter {


    private Api api;


    @Inject
    public AppraiseActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getMyStarEvaluate( int UserId  ,String token  ,int CurrentPage  ,String EvaluateStar) {


        Subscription subscription = api.getMyStarEvaluate( UserId  ,token  ,CurrentPage  ,EvaluateStar)

                .compose(RxUtil.<StarEvaluateBean>rxSchedulerHelper())

                .subscribe(new Action1<StarEvaluateBean>() {
                    @Override
                    public void call(StarEvaluateBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);

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