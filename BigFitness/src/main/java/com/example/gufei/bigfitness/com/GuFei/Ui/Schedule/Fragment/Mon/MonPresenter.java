package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon;


import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateForOrderBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByMonthBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.component.RxBus;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * @author GuFei
 * @version 2016 10 12 16:06
 */
public class MonPresenter extends RxPresenter<MonContract.View> implements MonContract.Presenter {

    private Api api;

    private static final String TAG = MonFragment.class.getName();




    @Inject
    public MonPresenter(Api api) {
        this.api = api;
//        this.realmService = realmService;
//        registerEvent();
    }

    @Override
    public void getAppointmentListByDate(int UserId, String token, int ClubId, String IsDepartManager, String date) {
        Subscription subscription = api.getAppointmentListByDate(UserId  ,token  ,ClubId  ,IsDepartManager  ,date)

                .compose(RxUtil.<AppointmentListByDateBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentListByDateBean>() {

                    @Override
                    public void call(AppointmentListByDateBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        system.out.print(normalresponse.geturl());


                            mView.loadList(normalResponse);

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
    public void getAppointmentListByMonth(int UserId, String token, int ClubId, String IsDepartManager, String date) {
        Subscription subscription = api.getAppointmentListByMonth(UserId  ,token  ,ClubId  ,IsDepartManager  ,date)

                .compose(RxUtil.<AppointmentListByMonthBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentListByMonthBean>() {
                    @Override
                    public void call(AppointmentListByMonthBean normalResponse) {


                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        system.out.print(normalresponse.geturl());


                            mView.loadData(normalResponse);

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