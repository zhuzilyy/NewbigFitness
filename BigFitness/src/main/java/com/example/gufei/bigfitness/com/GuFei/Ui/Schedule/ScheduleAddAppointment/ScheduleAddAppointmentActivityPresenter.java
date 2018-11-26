package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ScheduleAddAppointmentActivityPresenter extends RxPresenter<ScheduleAddAppointmentActivityContract.View> implements ScheduleAddAppointmentActivityContract.Presenter {


    private Api api;




    @Inject
    public ScheduleAddAppointmentActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void saveMemberAppiontment(String UserName, int UserId, String token, int ClubId, String appointType, String AppointmentTypeId, String Content, String MemberId, String EndTime, String StartTime, String Tipinterval, String Tipstarttime, String LessonId, String PlanInfo, String IsMakeUp,String AppointmentId) {

        Subscription subscription = api.saveMemberAppiontment(UserName  ,UserId  ,token  ,ClubId  ,appointType  ,AppointmentTypeId  ,Content  ,MemberId  ,EndTime  ,StartTime  ,Tipinterval  ,Tipstarttime  ,LessonId  ,PlanInfo  ,IsMakeUp  ,AppointmentId)

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

    @Override
    public void saveAppointmentResultForMember(int UserId, String token, int ClubId, String UserName, String AppointmentId, String AppointmentResultId, String appType) {
        Subscription subscription = api.saveAppointmentResultForMember(UserId  ,token  ,ClubId  ,UserName  ,AppointmentId  ,AppointmentResultId  ,appType)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.SaveSucceed(normalResponse);


                        }else if(normalResponse.getCode()==250){
                            mView.outLogin();


                        }else{
                            mView.showError(normalResponse.getMessage());
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