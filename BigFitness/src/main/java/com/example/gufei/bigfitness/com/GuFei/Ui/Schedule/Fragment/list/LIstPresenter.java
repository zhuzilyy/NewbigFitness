package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list;


import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateForOrderBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ClassOverBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


public class LIstPresenter extends RxPresenter<ListContract.View> implements ListContract.Presenter {

    private Api api;

    @Inject
    public LIstPresenter(Api api) {
        this.api = api;

    }


    @Override
    public void getAppointmentListByDateForOrder(int UserId, String token, int ClubId, String IsDepartManager, String date,  int CurrentPage, int IsHistory, String doType) {


        Subscription subscription = api.getAppointmentListByDateForOrder(  UserId  ,token  ,ClubId  ,IsDepartManager  ,date , doType ,CurrentPage, IsHistory )

                .compose(RxUtil.<AppointmentListByDateForOrderBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentListByDateForOrderBean>() {
                    @Override
                    public void call(AppointmentListByDateForOrderBean normalResponse) {


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

    @Override
    public void getClassOver(int AppointmentId, int ClubId, int MemberId, String token) {

        Subscription subscription = api.getClassOver(  AppointmentId ,token, ClubId  ,MemberId )

                .compose(RxUtil.<ClassOverBean>rxSchedulerHelper())

                .subscribe(new Action1<ClassOverBean>() {
                    @Override
                    public void call(ClassOverBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            mView.classsucceed(normalResponse);

                        }        if (normalResponse.getCode()==250){

                            mView.outLogin();

                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("请求失败");
                    }
                });
        addSubscription(subscription);

    }

    //取消预约
    @Override
    public void getCancelLesson(int AppointmentId, String token) {
        Subscription subscription = api.getCancelLessonAppointment(  AppointmentId ,token )

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            mView.cancelsucceed(normalResponse);

                        }        if (normalResponse.getCode()==250){

                            mView.outLogin();

                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("系统异常！");
                    }
                });
        addSubscription(subscription);
    }

    //确认预约
    @Override
    public void getConfirmLesson(int AppointmentId, String token) {
        Subscription subscription = api.getConfirmLessonAppointment(  AppointmentId ,token )

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            mView.confirmsucceed(normalResponse);

                        }else {
                            mView.showError(normalResponse.getMessage());
                        }
                        if (normalResponse.getCode()==250){

                            mView.outLogin();

                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
        addSubscription(subscription);
    }
}
