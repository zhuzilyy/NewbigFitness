package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CustomerAddCollectionActivityPresenter extends RxPresenter<CustomerAddCollectionActivityContract.View> implements CustomerAddCollectionActivityContract.Presenter {


    private Api api;


    @Inject
    public CustomerAddCollectionActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void addCustomer(int UserId, String token, int ClubId, String UserName, String CustomerName, String IntentId, String IntroduceMemberId, String LabelId, String OwnManagerId, String Remark, String Sex, String SourceId, String Tel, String Presalemembercardtypeid, String Presalemoney) {
        Subscription subscription = api.addCustomer( UserId  ,token  ,ClubId  ,UserName  ,CustomerName  ,IntentId  ,IntroduceMemberId  ,LabelId  ,OwnManagerId  ,Remark  ,Sex  ,SourceId  ,Tel  ,Presalemembercardtypeid  ,Presalemoney)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
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

    @Override
    public void getCustomerCheckByTel(int UserId, String token, int ClubId, String Tel) {

        Subscription subscription = api.getCustomerCheckByTel(UserId  ,token  ,ClubId  ,Tel)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getCode() == 0) {

                            mView.SuccessTel(normalResponse);


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
}