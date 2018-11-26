package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class CardListPresenter extends RxPresenter<CardListContract.View> implements CardListContract.Presenter {


    private Api api;


    @Inject
    public CardListPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getCardList(int userId, String userName, String token, int clubId, String memberId, String status) {
//        String state = null;
//        if (status > 0) {
//            state = String.valueOf(status -1);
//        }
        Subscription subscription = api.getCardListByMemberId(userName, String.valueOf(userId), token, String.valueOf(clubId), memberId, status)
                .compose(RxUtil.<CardListBean>rxSchedulerHelper())
                .subscribe(new Action1<CardListBean>() {
                    @Override
                    public void call(CardListBean cardListBean) {
                        if (cardListBean.getCode() == 0) {

                            mView.succeed(cardListBean);


                        } else if (cardListBean.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(cardListBean.getMessage().toString());
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
