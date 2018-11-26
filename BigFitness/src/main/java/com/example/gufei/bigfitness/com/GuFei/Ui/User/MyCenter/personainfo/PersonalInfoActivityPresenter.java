package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class PersonalInfoActivityPresenter extends RxPresenter<PersonalInfoActivityContract.View> implements PersonalInfoActivityContract.Presenter {


    private Api api;


    @Inject
    public PersonalInfoActivityPresenter(Api api) {
        this.api = api;
    }



    @Override
    public void updateUserInfo(String userId, String clubId, String token, String header, String userName, String sex, String age, String tel, String mail, String idCard) {
        Subscription subscription = api.updateUserInfo(userId, clubId,token,header,userName,sex,age,tel,mail,idCard)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean codeBean) {
                        if (codeBean.getCode()==0){

                            mView.complete();


                        }
                        if (codeBean.getCode()==250){

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
    public void getUserInfo(int userid, String token) {

        Subscription subscription = api.getUserInfo(userid,token)

                .compose(RxUtil.<UserInfo>rxSchedulerHelper())

                .subscribe(new Action1<UserInfo>() {

                    @Override
                    public void call(UserInfo normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);
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