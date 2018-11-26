package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class AddAppointmentActivityPresenter extends RxPresenter<AddAppointmentActivityContract.View> implements AddAppointmentActivityContract.Presenter {


    private Api api;




    @Inject
    public AddAppointmentActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appAddCustomerAppoint(String UserName, int UserId, String token, int ClubId, String AppointmentTypeId, String Content, String CustomerId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String AppointmentId) {
        Subscription subscription = api.appAddCustomerAppoint( UserName  ,UserId  ,token  ,ClubId  ,AppointmentTypeId  ,Content  ,CustomerId  ,EndTime  ,StartTime  ,Tipinterval  ,Tipstarttime  ,AppointmentId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        system.out.print(normalresponse.geturl());


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