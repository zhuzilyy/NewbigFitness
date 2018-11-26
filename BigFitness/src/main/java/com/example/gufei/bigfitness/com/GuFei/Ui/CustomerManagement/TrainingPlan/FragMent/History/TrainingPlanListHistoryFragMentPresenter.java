package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.HistoryPlanListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TrainingPlanListHistoryFragMentPresenter extends RxPresenter<TrainingPlanListHistoryFragMentContract.View> implements TrainingPlanListHistoryFragMentContract.Presenter {


    private Api api;




    @Inject
    public TrainingPlanListHistoryFragMentPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getHistoryPlanList(int UserId, String token, int ClubId, String MemberId, String AppointmentId, String LessonId, int CurrentPage) {
        Subscription subscription = api.getHistoryPlanList( UserId  ,token  ,ClubId  ,MemberId  ,AppointmentId  ,LessonId  ,CurrentPage )

                .compose(RxUtil.<HistoryPlanListBean>rxSchedulerHelper())

                .subscribe(new Action1<HistoryPlanListBean>() {
                    @Override
                    public void call(HistoryPlanListBean normalResponse) {

                        if (normalResponse.getCode()==0){

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