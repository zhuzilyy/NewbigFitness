package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaInfoForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class PublicSeaInfoActivityPresenter extends RxPresenter<PublicSeaInfoActivityContract.View> implements PublicSeaInfoActivityContract.Presenter {


    private Api api;


    @Inject
    public PublicSeaInfoActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getPublicseaCustomerInfoById(String UserName, int UserId, String token, int ClubId, String CustomerId) {

        Subscription subscription = api.getPublicseaCustomerInfoById( UserName  ,UserId  ,token  ,ClubId  ,CustomerId)

                .compose(RxUtil.<PublicSeaListBean>rxSchedulerHelper())

                .subscribe(new Action1<PublicSeaListBean>() {

                    @Override
                    public void call(PublicSeaListBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);
                        }
                        if (normalResponse.getCode()==250){

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

    @Override
    public void getPublicseaMemberInfoById(String UserName, int UserId, String token, int ClubId, String MemberId) {

        Subscription subscription = api.getPublicseaMemberInfoById( UserName  ,UserId  ,token  ,ClubId  ,MemberId)

                .compose(RxUtil.<PublicSeaInfoForMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<PublicSeaInfoForMemberBean>() {

                    @Override
                    public void call(PublicSeaInfoForMemberBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed1(normalResponse);
                        }
                        if (normalResponse.getCode()==250){

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