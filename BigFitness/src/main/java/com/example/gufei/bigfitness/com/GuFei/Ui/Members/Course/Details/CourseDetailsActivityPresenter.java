package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberwardrobeListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CourseDetailsActivityPresenter extends RxPresenter<CourseDetailsActivityContract.View> implements CourseDetailsActivityContract.Presenter {


    private Api api;




    @Inject
    public CourseDetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMemberWardrobeInfo(int UserId, String token, int ClubId, int WardrobeId, String MemberId) {
        Subscription subscription = api.getMemberWardrobeInfo(  UserId  ,token  ,ClubId  ,WardrobeId  ,MemberId)

                .compose(RxUtil.<MemberWardrobeInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<MemberWardrobeInfoBean>() {
                    @Override
                    public void call(MemberWardrobeInfoBean normalResponse) {

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