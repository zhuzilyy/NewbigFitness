package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberwardrobeListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CourseListActivityPresenter extends RxPresenter<CourseListActivityContract.View> implements CourseListActivityContract.Presenter {


    private Api api;




    @Inject
    public CourseListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getLessonListForMember(int UserId, String token, int ClubId, String MemberId) {
        Subscription subscription = api.getLessonListForMember(   UserId  ,token  ,ClubId  ,MemberId )

                .compose(RxUtil.<LessonListForMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonListForMemberBean>() {
                    @Override
                    public void call(LessonListForMemberBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedLessonListForMember(normalResponse);


                        } else if (normalResponse.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(normalResponse.getMessage().toString());
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
    public void getMemberwardrobeList(int UserId, String token, int ClubId, String MemberId, String Status) {
        Subscription subscription = api.getMemberwardrobeList(   UserId  ,token  ,ClubId  ,MemberId  ,Status)

                .compose(RxUtil.<MemberwardrobeListBean>rxSchedulerHelper())

                .subscribe(new Action1<MemberwardrobeListBean>() {
                    @Override
                    public void call(MemberwardrobeListBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeed(normalResponse);


                        } else if (normalResponse.getCode() == 250) {

                            mView.outLogin();

                        } else {

                            mView.showError(normalResponse.getMessage().toString());
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