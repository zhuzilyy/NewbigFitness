package com.example.gufei.bigfitness.com.GuFei.Ui.User.Login;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class LoginActivityPresenter extends RxPresenter<LoginActivityContract.View> implements LoginActivityContract.Presenter {


    private Api api;


    @Inject
    public LoginActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void login(final String userName, final String passWord,final  String DeviceCode, final boolean remember) {
        Subscription subscription = api.login(userName,passWord,DeviceCode)
                .compose(RxUtil.<LoginBean>rxSchedulerHelper())
                .subscribe(new Action1<LoginBean>() {
                        @Override
                        public void call(LoginBean normalResponse) {
                            String message = normalResponse.getMessage();
                            int code= normalResponse.getCode();
                            if (normalResponse.getCode()==0){
                                if (remember) {
                                    mView.remember(userName, passWord,DeviceCode,normalResponse,true);
                                } else {
                                    mView.remove();
                                    mView.remember(userName, passWord,DeviceCode,normalResponse,false);
                                }
                                mView.succeed(normalResponse);
                            }
//                            else if (normalResponse.getCode() == -10000000){
//                                mView.showError("用户无登录权限");
//                            }
                            else{

                                mView.showError(normalResponse.getMessage());
                            }
                      }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                       mView.showError("用户无登录权限");

                    }
                });
        addSubscription(subscription);
    }

}