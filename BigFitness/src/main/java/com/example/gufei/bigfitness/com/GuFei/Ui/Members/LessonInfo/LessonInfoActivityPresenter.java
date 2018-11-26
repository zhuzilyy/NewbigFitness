package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class LessonInfoActivityPresenter extends RxPresenter<LessonInfoActivityContract.View> implements LessonInfoActivityContract.Presenter {


    private Api api;




    @Inject
    public LessonInfoActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getLessonInfoFromApponitment(int UserId, String token, int ClubId, String MemberId, String LessonType, String AppointmentId) {
        Subscription subscription = api.getLessonInfoFromApponitment( UserId  ,token  ,ClubId  ,MemberId  ,LessonType  ,AppointmentId)

                .compose(RxUtil.<LessonInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonInfoBean>() {
                    @Override
                    public void call(LessonInfoBean normalResponse) {

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