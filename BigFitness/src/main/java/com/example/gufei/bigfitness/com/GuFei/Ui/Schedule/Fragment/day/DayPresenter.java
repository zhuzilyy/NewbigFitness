package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day;


import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.Schedule;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


public class DayPresenter extends RxPresenter<DayContract.View> implements DayContract.Presenter {

    private Api api;

    @Inject
    public DayPresenter(Api api) {
        this.api = api;

    }


    @Override
    public void init() {

    }

    @Override
    public void getSchedule(String s, String token, String s1, String s2, String date, String d) {
        Subscription subscription = api.getSechedule(s, token, s1, s2, date, d)

                .compose(RxUtil.<Schedule>rxSchedulerHelper())

                .subscribe(new Action1<Schedule>() {
                    @Override
                    public void call(Schedule schedule) {
                        if (schedule.getCode() == 0) {
                            mView.loadData(schedule.getResult());
                        }
                        if (schedule.getCode() == 250) {
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
