package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CoachInfoActivityPresenter extends RxPresenter<CoachInfoActivityContract.View> implements CoachInfoActivityContract.Presenter {


    private Api api;


    @Inject
    public CoachInfoActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getTeacherInfo(int userid, String token) {



        Subscription subscription = api.getTeacherInfo(userid,token)

                .compose(RxUtil.<TeacherInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<TeacherInfoBean>() {

                    @Override
                    public void call(TeacherInfoBean normalResponse) {

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


    @Override
    public void updateTeacherInfo(int UserId, String token, int ClubId, String UserName, String Height, String Weight) {
        Subscription subscription = api.updateTeacherInfo( UserId  ,token  ,ClubId  ,UserName  ,Height  ,Weight)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean codeBean) {
                        if (codeBean.getCode()==0){

                            mView.succeedUpdata(codeBean);


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


}