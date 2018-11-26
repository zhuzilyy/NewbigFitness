package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MultimediaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ImgVideoListActivityPresenter extends RxPresenter<ImgVideoListActivityContract.View> implements ImgVideoListActivityContract.Presenter {


    private Api api;


    @Inject
    public ImgVideoListActivityPresenter(Api api) {

        this.api = api;

    }

    @Override
    public void getMyUserTeacherResList(int UserId, String token) {

        Subscription subscription = api.getMyUserTeacherResList(UserId,token)

                .compose(RxUtil.<MultimediaBean>rxSchedulerHelper())

                .subscribe(new Action1<MultimediaBean>() {

                    @Override
                    public void call(MultimediaBean normalResponse) {

                           if (normalResponse.getCode()==0){

                                    mView.succeed(normalResponse);
                                    } if (normalResponse.getCode()==250){

                                        mView.outLogin();

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