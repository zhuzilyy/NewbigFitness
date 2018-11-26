package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ReservationRecordScheduleActivityPresenter extends RxPresenter<ReservationRecordScheduleActivityContract.View> implements ReservationRecordScheduleActivityContract.Presenter {


    private Api api;


    @Inject
    public ReservationRecordScheduleActivityPresenter(Api api) {
        this.api = api;
    }

    //    @Override
//    public void appAddCustomerAppoint(String UserName, int UserId, String token, int ClubId, String AppointmentTypeId, String Content, String CustomerId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String AppointmentId) {
//        Subscription subscription = api.appAddCustomerAppoint(UserName  ,UserId  ,token  ,ClubId  ,AppointmentTypeId  ,Content  ,CustomerId  ,EndTime  ,StartTime  ,Tipinterval  ,Tipstarttime  ,AppointmentId)
//
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//                        if (normalResponse.getCode()==0){
//
//                            mView.savesucceed(normalResponse);
//                        }
//                        if (normalResponse.getCode()==250){
//
//                            mView.outLogin();
//                        }
//
//
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
//                        mView.showError(ErrMessages);
//
//
//                    }
//                });
//        addSubscription(subscription);
//    }
    @Override
    public void saveMemberAppiontment(String UserName, int UserId, String token, int ClubId, String appointType, String AppointmentTypeId, String Content, String MemberId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String LessonId, String PlanInfo,String IsMakeUp, String AppointmentId) {

        Subscription subscription = api.saveMemberAppiontment(UserName  ,UserId  ,token  ,ClubId  ,appointType  ,AppointmentTypeId  ,Content  ,MemberId  ,EndTime  ,StartTime  ,Tipinterval  ,Tipstarttime  ,LessonId  ,PlanInfo  ,IsMakeUp  ,AppointmentId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        system.out.print(normalresponse.geturl());


                            mView.savesucceed(normalResponse);

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
    public void saveAppointmentResultForMember(int UserId, String token, int ClubId, String UserName, String AppointmentId, String AppointmentResultId, String appType) {
        Subscription subscription = api.saveAppointmentResultForMember( UserId  ,token  ,ClubId  ,UserName  ,AppointmentId  ,AppointmentResultId  ,appType)

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
    public void getAppointmentByIdForMember(int UserId, String token, int ClubId, String AppointmentId, String appType, String MemberId) {
        // TODO: 2017/6/24 AppointmentByIdForMemberErrBean为错误Bean
        //应用中需要改成AppointmentByIdForMemberBean
        Subscription subscription = api.getAppointmentByIdForMember(  UserId  ,token  ,ClubId  ,AppointmentId  ,appType  ,MemberId)

                .compose(RxUtil.<AppointmentByIdForMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentByIdForMemberBean>() {
                    @Override
                    public void call(AppointmentByIdForMemberBean normalResponse) {

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