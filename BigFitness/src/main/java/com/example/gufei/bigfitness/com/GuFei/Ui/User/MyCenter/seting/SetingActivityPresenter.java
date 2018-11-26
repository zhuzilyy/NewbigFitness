package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class SetingActivityPresenter extends RxPresenter<SetingActivityContract.View> implements SetingActivityContract.Presenter {
    private Api api;
    @Inject
    public SetingActivityPresenter(Api api) {
        this.api = api;
    }
    @Override
    public void changPsw(int userid, String token, int clubid, String UserName, String OldPwd, String NewPwd) {
        Subscription subscription = api.changePsw(userid,token,clubid,UserName ,OldPwd  ,NewPwd)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getCode()==0){
                            mView.succeed();
                        }
                        if (normalResponse.getCode()==250){

                            mView.outLogin();

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
    public void outLogin(int userid, String token, int clubid, String UserName) {


        Subscription subscription = api.outLogin(userid,token,clubid,UserName)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.outLogin();


                        }
                        if (normalResponse.getCode()==250){

                            mView.outLogin();

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