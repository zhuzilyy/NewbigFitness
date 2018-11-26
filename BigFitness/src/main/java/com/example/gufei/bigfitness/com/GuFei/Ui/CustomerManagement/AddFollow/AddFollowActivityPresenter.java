package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class AddFollowActivityPresenter extends RxPresenter<AddFollowActivityContract.View> implements AddFollowActivityContract.Presenter {


    private Api api;




    @Inject
    public AddFollowActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void saveCustomerContact(String UserName, int UserId, String token, int ClubId, String AppointmentId, String ContactContent, String CustomerId, String imgsrc) {

        Subscription subscription = api.saveCustomerContact( UserName  ,UserId  ,token  ,ClubId  ,AppointmentId  ,ContactContent  ,CustomerId  ,imgsrc)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

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