package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class FollowUpRecordActivityPresenter extends RxPresenter<FollowUpRecordActivityContract.View> implements FollowUpRecordActivityContract.Presenter {


    private Api api;


    @Inject
    public FollowUpRecordActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getContactListForCustomer(String UserName, int UserId, String token, int ClubId, String AppointmentId, String CustomerId,String PersonType) {

        Subscription subscription = api.getContactListForCustomer( UserName  ,UserId  ,token  ,ClubId  ,CustomerId ,PersonType )

                .compose(RxUtil.<ContactListForCustomerBean>rxSchedulerHelper())

                .subscribe(new Action1<ContactListForCustomerBean>() {
                    @Override
                    public void call(ContactListForCustomerBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);


                        }        if (normalResponse.getCode()==250){

                            mView.outLogin();

                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

//                        mView.showError(ErrMessages);+


                    }
                });
        addSubscription(subscription);
    }
}