package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListAllBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MembersAppointmentRecordActivityPresenter extends RxPresenter<MembersAppointmentRecordActivityContract.View> implements MembersAppointmentRecordActivityContract.Presenter {


    private Api api;


    @Inject
    public MembersAppointmentRecordActivityPresenter(Api api) {
        this.api = api;
    }
//
//    @Override
//    public void getCustomerAppointmentListAll(String UserName, int UserId, String token, int ClubId, String AppointmentId, String CustomerId) {
//
//        Subscription subscription = api.getCustomerAppointmentListAll( UserName  ,UserId  ,token  ,ClubId  ,CustomerId  )
//
//                .compose(RxUtil.<CustomerAppointmentListBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CustomerAppointmentListBean>() {
//                    @Override
//                    public void call(CustomerAppointmentListBean normalResponse) {
//
//                        if (normalResponse.getCode()==0){
//
//                            mView.succeed(normalResponse);
//
//
//                        }        if (normalResponse.getCode()==250){
//
//                            mView.outLogin();
//
//                        }
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
    @Override
    public void getMemberAppointmentListAll(String UserName, int UserId, String token, int ClubId, String AppointmentId, String MemberId,String PersonType) {

        Subscription subscription = api.getMemberAppointmentListAll( UserName  ,UserId  ,token  ,ClubId  ,MemberId,PersonType)

                .compose(RxUtil.<MemberAppointmentListAllBean>rxSchedulerHelper())

                .subscribe(new Action1<MemberAppointmentListAllBean>() {
                    @Override
                    public void call(MemberAppointmentListAllBean normalResponse) {

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

//                        mView.showError(ErrMessages);+


                    }
                });
        addSubscription(subscription);
    }
}