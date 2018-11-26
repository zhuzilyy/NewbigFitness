package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MyInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/*
 * Created by Administrator on 2017/8/4.
 * Web页面
 */

public class MyCenterMainFragMentPresenter extends RxPresenter<MyCenterMainFragMentContract.View> implements MyCenterMainFragMentContract.Presenter {


    private Api api;


    @Inject
    public MyCenterMainFragMentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getMyInfo(int UserId, String token) {
//
        Subscription subscription = api.getMyInfo(UserId,token)

                .compose(RxUtil.<MyInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<MyInfoBean>() {
                    @Override
                    public void call(MyInfoBean normalResponse) {
                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);


                        }else if(normalResponse.getCode()==250){
                            mView.outLogin();


                        }else{
                            mView.showError(normalResponse.getMessage());
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