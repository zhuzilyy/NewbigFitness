package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainActionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TrainingPlanAddActivityPresenter extends RxPresenter<TrainingPlanAddActivityContract.View> implements TrainingPlanAddActivityContract.Presenter {


    private Api api;




    @Inject
    public TrainingPlanAddActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void saveTrainAction(String UserName, int UserId, String token, int ClubId, String ActionName, String PositionId) {
        Subscription subscription = api.saveTrainAction( UserName  ,UserId  ,token  ,ClubId  ,ActionName  ,PositionId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeedAdd(normalResponse);


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

    @Override
    public void getTrainActionDropList(String UserName, int UserId, String token, int ClubId, String PositionId) {

        Subscription subscription = api.getTrainActionDropList(UserName  ,UserId  ,token  ,ClubId,PositionId)

                .compose(RxUtil.<TrainActionDropListBean>rxSchedulerHelper())

                .subscribe(new Action1<TrainActionDropListBean>() {
                    @Override
                    public void call(TrainActionDropListBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);


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