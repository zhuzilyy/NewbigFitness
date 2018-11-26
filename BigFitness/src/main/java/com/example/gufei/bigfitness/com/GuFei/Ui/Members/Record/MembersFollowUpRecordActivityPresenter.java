package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListByMemberIDBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MembersFollowUpRecordActivityPresenter extends RxPresenter<MembersFollowUpRecordActivityContract.View> implements MembersFollowUpRecordActivityContract.Presenter {


    private Api api;


    @Inject
    public MembersFollowUpRecordActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMemberAppointmentListByMemberID(String UserName, int UserId, String token, int ClubId, String IsDepartManager, String MemberId, String PersonType) {
        Subscription subscription = api.getMemberAppointmentListByMemberID(UserName, UserId, token, ClubId, IsDepartManager, MemberId, PersonType)
                .compose(RxUtil.<MemberAppointmentListByMemberIDBean>rxSchedulerHelper())
                .subscribe(new Action1<MemberAppointmentListByMemberIDBean>() {
                    @Override
                    public void call(MemberAppointmentListByMemberIDBean normalResponse) {
                        if (normalResponse.getCode() == 0) {
                            mView.succeed(normalResponse);
                        }
                        if (normalResponse.getCode() == 250) {
                            mView.outLogin();
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("数据请求失败");
                    }
                });
        addSubscription(subscription);
    }

    @Override
    public void getContactListForCustomer(String UserName, int UserId, String token, int ClubId, String AppointmentId, String CustomerId,String PersonType) {

        Subscription subscription = api.getContactListForCustomer( UserName  ,UserId  ,token  ,ClubId  ,CustomerId ,PersonType )

                .compose(RxUtil.<ContactListForCustomerBean>rxSchedulerHelper())

                .subscribe(new Action1<ContactListForCustomerBean>() {
                    @Override
                    public void call(ContactListForCustomerBean normalResponse) {

                        if (normalResponse.getCode()==0){



                            mView.succeed1(normalResponse);


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