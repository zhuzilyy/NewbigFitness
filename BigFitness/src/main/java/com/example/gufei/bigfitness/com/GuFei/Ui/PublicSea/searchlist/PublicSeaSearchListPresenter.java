package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class PublicSeaSearchListPresenter extends RxPresenter<PublicSeaSearchListContract.View> implements PublicSeaSearchListContract.Presenter {

    private Api api;

    @Inject
    public PublicSeaSearchListPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appPublicSeaMemberList(String userName, int userId, String token, int clubId, int page, String s, String s1, String s2, String s3, String s4, String query) {
        Subscription subscription = api.appPublicSeaMemberList2( userId  ,token  ,clubId,page, query )

                .compose(RxUtil.<PublicSeaMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<PublicSeaMemberBean>() {
                    @Override
                    public void call(PublicSeaMemberBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());


                            mView.membersucceed(normalResponse);

                        }    if (normalResponse.getCode()==250){

                            mView.outLogin();

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
    public void appPublicSeaCustomerList(String userName, int userId, String token, int clubId, int page, String s, String s1, String s2, String s3, String s4, String query) {
        Subscription subscription = api.appPublicSeaCustomerList2( userId  ,token  ,clubId,page, query )

                .compose(RxUtil.<PublicSeaBean>rxSchedulerHelper())

                .subscribe(new Action1<PublicSeaBean>() {
                    @Override
                    public void call(PublicSeaBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());


                            mView.succeed(normalResponse);

                        }    if (normalResponse.getCode()==250){

                            mView.outLogin();

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