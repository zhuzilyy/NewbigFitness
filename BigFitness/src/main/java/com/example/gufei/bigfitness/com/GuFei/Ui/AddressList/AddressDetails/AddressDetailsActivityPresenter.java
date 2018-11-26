package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 通讯录详情页P层
 */

public class AddressDetailsActivityPresenter extends RxPresenter<AddressDetailsActivityContract.View> implements AddressDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public AddressDetailsActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updata(String s) {

//        Subscription subscription = api.getNewVersion()
//
//                .compose(RxUtil.<ApkUpdataModel>rxSchedulerHelper())
//
//                .subscribe(new Action1<ApkUpdataModel>() {
//                    @Override
//                    public void call(ApkUpdataModel normalResponse) {
//
//                        System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
//                        System.out.print(normalResponse.getUrl());
//
//
//                        mView.add(normalResponse.getUrl());
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
    }
}