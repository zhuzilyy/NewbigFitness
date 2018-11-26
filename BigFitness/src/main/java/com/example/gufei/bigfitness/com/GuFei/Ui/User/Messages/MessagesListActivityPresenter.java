package com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PushUserMessageInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MessagesListActivityPresenter extends RxPresenter<MessagesListActivityContract.View> implements MessagesListActivityContract.Presenter {


    private Api api;


    @Inject
    public MessagesListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getPushUserMessageInfo(int UserId, String token, int ClubId, int MessageId) {
        Subscription subscription = api.getPushUserMessageInfo(UserId  ,token  ,ClubId  ,MessageId)

                .compose(RxUtil.<PushUserMessageInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<PushUserMessageInfoBean>() {
                    @Override
                    public void call(PushUserMessageInfoBean normalResponse) {

                        if (normalResponse.getCode()==0){
                            mView.Infosucceed(normalResponse);
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
    public void updateAllPushUserMessageReadType(int UserId, String token, int ClubId,String MsgTypeId) {
        Subscription subscription = api.updateAllPushUserMessageReadType(UserId  ,token  ,ClubId,MsgTypeId )

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.AllReadsucceed(normalResponse);


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
    public void delAllPushUserMessageRead(int UserId, String token, int ClubId,String MsgTypeId) {
        Subscription subscription = api.delAllPushUserMessageRead(UserId  ,token  ,ClubId,MsgTypeId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.AllDelsucceed(normalResponse);


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
    public void getPushUserMessageList(
            int UserId  ,String token  ,int ClubId  ,int CurrentPage,String MsgTypeId) {

        Subscription subscription = api.getPushUserMessageList(UserId  ,token  ,ClubId  ,CurrentPage,MsgTypeId)

                .compose(RxUtil.<MessageslistBean>rxSchedulerHelper())

                .subscribe(new Action1<MessageslistBean>() {
                    @Override
                    public void call(MessageslistBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);


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