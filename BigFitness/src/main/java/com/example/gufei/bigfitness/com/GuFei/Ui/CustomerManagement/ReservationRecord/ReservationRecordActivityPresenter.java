package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord;

import android.content.Intent;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

import static android.support.v4.content.ContextCompat.startActivity;
import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.PUT_STR;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ReservationRecordActivityPresenter extends RxPresenter<ReservationRecordActivityContract.View> implements ReservationRecordActivityContract.Presenter {


    private Api api;


    @Inject
    public ReservationRecordActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appAddCustomerAppoint(String UserName, int UserId, String token, int ClubId, String AppointmentTypeId, String Content, String CustomerId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String AppointmentId) {
        Subscription subscription = api.appAddCustomerAppoint(UserName  ,UserId  ,token  ,ClubId  ,AppointmentTypeId  ,Content  ,CustomerId  ,EndTime  ,StartTime  ,Tipinterval  ,Tipstarttime  ,AppointmentId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.savesucceed(normalResponse);
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

    @Override
    public void saveAppointmentResultForCustomer(int UserId, String token, int ClubId, String UserName, String AppointmentId, String AppointmentResultId, String appType) {
        Subscription subscription = api.saveAppointmentResultForCustomer( UserId  ,token  ,ClubId  ,UserName  ,AppointmentId  ,AppointmentResultId  ,appType)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.savesucceed(normalResponse);
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

    @Override
    public void getAppointmentById(String UserName, int UserId, String token, int ClubId, String AppointmentId, String CustomerId) {

        Subscription subscription = api.getAppointmentById( UserName,  UserId,  token,  ClubId,  AppointmentId,  CustomerId)

                .compose(RxUtil.<AppointmentByIdBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentByIdBean>() {
                    @Override
                    public void call(AppointmentByIdBean normalResponse) {

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