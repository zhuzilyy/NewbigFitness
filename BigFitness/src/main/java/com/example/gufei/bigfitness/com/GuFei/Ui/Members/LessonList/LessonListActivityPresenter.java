package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListByMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class LessonListActivityPresenter extends RxPresenter<LessonListActivityContract.View> implements LessonListActivityContract.Presenter {


    private Api api;


    @Inject
    public LessonListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getLessonListByMemberId(String UserName, int UserId, String token, int ClubId, String MemberId, String Status) {

        Subscription subscription = api.getLessonListByMemberId( UserName  ,UserId  ,token  ,ClubId  ,MemberId  ,Status)
                .compose(RxUtil.<LessonListByMemberIdBean>rxSchedulerHelper())
                .subscribe(new Action1<LessonListByMemberIdBean>() {
                    @Override
                    public void call(LessonListByMemberIdBean lessonInfoBean) {
                        if (lessonInfoBean.getCode() == 0) {

                            mView.succeed(lessonInfoBean);


                        } else if (lessonInfoBean.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(lessonInfoBean.getMessage().toString());
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
