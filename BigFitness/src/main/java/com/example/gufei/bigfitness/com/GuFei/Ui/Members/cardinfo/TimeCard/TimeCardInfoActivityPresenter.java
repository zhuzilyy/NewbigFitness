package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class TimeCardInfoActivityPresenter extends RxPresenter<TimeCardInfoActivityContract.View> implements TimeCardInfoActivityContract.Presenter {


    private Api api;


    @Inject
    public TimeCardInfoActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getCardInfo(int userId, String userName, String token, int clubId, int cardId) {
        Subscription subscription = api.getCardInfoByMemberCardId(userName, String.valueOf(userId), token, String.valueOf(clubId), String.valueOf(cardId))
                .compose(RxUtil.<CardInfoBean>rxSchedulerHelper())
                .subscribe(new Action1<CardInfoBean>() {
                    @Override
                    public void call(CardInfoBean cardInfoBean) {
                        if (cardInfoBean.getCode() == 0) {

                            mView.succeed(cardInfoBean);


                        } else if (cardInfoBean.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(cardInfoBean.getMessage().toString());
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
