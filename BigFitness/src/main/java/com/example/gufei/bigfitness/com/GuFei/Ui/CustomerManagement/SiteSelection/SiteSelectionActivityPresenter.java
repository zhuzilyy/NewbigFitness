package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainPositionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class SiteSelectionActivityPresenter extends RxPresenter<SiteSelectionActivityContract.View> implements SiteSelectionActivityContract.Presenter {


    private Api api;


    @Inject
    public SiteSelectionActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void saveTrainPosition(String UserName, int UserId, String token, int ClubId, String PositionName) {
        Subscription subscription = api.saveTrainPosition(UserName  ,UserId  ,token  ,ClubId,PositionName)

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
    public void getTrainPositionDropList(String UserName, int UserId, String token, int ClubId) {
        Subscription subscription = api.getTrainPositionDropList(UserName  ,UserId  ,token  ,ClubId)

                .compose(RxUtil.<TrainPositionDropListBean>rxSchedulerHelper())

                .subscribe(new Action1<TrainPositionDropListBean>() {
                    @Override
                    public void call(TrainPositionDropListBean normalResponse) {

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