package com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CourseAppointmentAddActivityPresenter extends RxPresenter<CourseAppointmentAddActivityContract.View> implements CourseAppointmentAddActivityContract.Presenter {


    private Api api;




    @Inject
    public CourseAppointmentAddActivityPresenter(Api api) {
        this.api = api;
    }

//    @Override
//    public void get(String type) {
//
//        Subscription subscription = api.getPushUserMessageList()
//
//                .compose(RxUtil.<MessageslistBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<MessageslistBean>() {
//                    @Override
//                    public void call(MessageslistBean normalResponse) {
//
//                        if (normalResponse.getError()==0){
//
//                            mView.succeed(normalResponse);
//
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




}