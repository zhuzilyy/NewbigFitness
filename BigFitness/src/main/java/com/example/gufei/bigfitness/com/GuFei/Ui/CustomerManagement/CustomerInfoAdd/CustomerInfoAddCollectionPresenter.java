package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd;

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

public class CustomerInfoAddCollectionPresenter extends RxPresenter<CustomerInfoAddCollectionContract.View> implements CustomerInfoAddCollectionContract.Presenter {


    private Api api;


    @Inject
    public CustomerInfoAddCollectionPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void addCustomer(int UserId, String token, int ClubId, String UserName, String CustomerName, String IntentId, String IntroduceMemberId, String LabelId, String OwnManagerId, String Remark, String Sex, String SourceId, String Tel, String Presalemembercardtypeid, String Presalemoney) {

            Subscription subscription = api.addCustomer(UserId  ,token  ,ClubId  ,UserName  ,CustomerName  ,IntentId  ,IntroduceMemberId  ,LabelId  ,OwnManagerId  ,Remark  ,Sex  ,SourceId  ,Tel  ,Presalemembercardtypeid  ,Presalemoney)
                    .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                    .subscribe(new Action1<CodeBean>() {
                        @Override
                        public void call(CodeBean normalResponse) {


                            if (normalResponse.getCode() == 0) {

                                mView.addPersonalSuccess();


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