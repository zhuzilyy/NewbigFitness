package com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome;

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

public class WelcomeActivityPresenter extends RxPresenter<WelcomeActivityContract.View> implements WelcomeActivityContract.Presenter {


    private Api api;


    @Inject
    public WelcomeActivityPresenter(Api api) {
        this.api = api;
    }
    @Override
    public void login(final String userName, final String passWord,final  String DeviceCode, final boolean remember) {

        Subscription subscription = api.login(userName,passWord,DeviceCode)

                .compose(RxUtil.<LoginBean>rxSchedulerHelper())

                .subscribe(new Action1<LoginBean>() {
                    @Override
                    public void call(LoginBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);
                            if (remember) {

                                mView.remember(userName, passWord,DeviceCode,normalResponse,true);

                            } else {

                                mView.remove();
                                mView.remember(userName, passWord,DeviceCode,normalResponse,false);
                            }

                        }else{

                            mView.Error();
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        mView.showError(ErrMessages);
                        mView.Error();

                    }
                });
        addSubscription(subscription);
    }

}