package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CustomerEditCollectionActivityPresenter extends RxPresenter<CustomerEditCollectionActivityContract.View> implements CustomerEditCollectionActivityContract.Presenter {


    private Api api;


    @Inject
    public CustomerEditCollectionActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getCustomerInfoById(int UserId, String token, int ClubId, String UserName, String CustomerId) {

        Subscription subscription = api.getCustomerInfoById(UserName  ,UserId  ,token  ,ClubId  ,CustomerId)
                .compose(RxUtil.<CustomerInfoBean>rxSchedulerHelper())
                .subscribe(new Action1<CustomerInfoBean>() {
                    @Override
                    public void call(CustomerInfoBean normalResponse) {
                        if (normalResponse.getCode() == 0) {

                            mView.Success(normalResponse);


                        } else if (normalResponse.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(normalResponse.getMessage().toString());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("加载失败");
                    }
                });
        addSubscription(subscription);

    }

    //    @Override
//    public void login(final String userName, final String passWord, final boolean remember) {
//
//        Subscription subscription = api.addCustomer(userName,passWord)
//
//                .compose(RxUtil.<loginBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//
////
////                        System.out.print(normalResponse.getUrl());
////
////
////                        mView.add(normalResponse.getUrl());
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
////                        mView.showError(ErrMessages);+
//
//
//                    }
//                });
//        addSubscription(subscription);
//    }
}