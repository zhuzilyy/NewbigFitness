package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TrainingPlanListActivityPresenter extends RxPresenter<TrainingPlanListActivityContract.View> implements TrainingPlanListActivityContract.Presenter {


    private Api api;




    @Inject
    public TrainingPlanListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void get(String type) {

        Subscription subscription = api.getTrainingPlanList()

                .compose(RxUtil.<TrainingPlanBean>rxSchedulerHelper())

                .subscribe(new Action1<TrainingPlanBean>() {
                    @Override
                    public void call(TrainingPlanBean normalResponse) {

                        if (normalResponse.getError()==0){

                            mView.succeed(normalResponse);


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