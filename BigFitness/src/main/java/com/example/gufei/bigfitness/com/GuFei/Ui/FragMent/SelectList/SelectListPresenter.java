package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList;


import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;

/**
 * @author GuFei
 * @version 2016 10 12 16:06
 */
public class SelectListPresenter extends RxPresenter<SelectListContract.View> implements SelectListContract.Presenter {

    private Api api;


    @Inject
    public SelectListPresenter(Api api) {
        this.api = api;
//        this.realmService = realmService;
        registerEvent();
    }

    private void registerEvent() {
//        Subscription subscription = RxBus.getDefault().toObservable(Position.class)
//                .compose(RxUtil.<Position>rxSchedulerHelper())
//                .subscribe(new Action1<Position>() {
//                    @Override
//                    public void call(Position position) {
//                        mView.updateCity(position.getName());
//                    }
//                });
//        addSubscription(subscription);
    }

    @Override
    public void init() {
//        Subscription subscription = api.getIndexData(1,null)
//                .compose(RxUtil.<NormalResponse<IndexData>>rxSchedulerHelper())
//                .subscribe(new Action1<NormalResponse<IndexData>>() {
//                               @Override
//                               public void call(NormalResponse<IndexData> indexDataNormalResponse) {
//                                   if (indexDataNormalResponse.getCode() == 0) {
//                                       mView.loadData(indexDataNormalResponse.getResult());
//                                   } else {
//                                       mView.showError("加载失败");
//                                   }
//                               }
//                           }, new Action1<Throwable>() {
//                               @Override
//                               public void call(Throwable throwable) {
//                                   mView.showError("加载失败");
//                               }
//                           }
//                );
//        addSubscription(subscription);
    }

    @Override
    public void change(int currentPage) {
//        Subscription subscription = api.getIndexData(currentPage,null)
//                .compose(RxUtil.<NormalResponse<IndexData>>rxSchedulerHelper())
//                .subscribe(new Action1<NormalResponse<IndexData>>() {
//                    @Override
//                    public void call(NormalResponse<IndexData> indexDataNormalResponse) {
//                        if (indexDataNormalResponse.getCode() == 0) {
//                            mView.updateList(indexDataNormalResponse.getResult().getList());
//                        } else {
//                            mView.showError("加载失败");
//                        }
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        mView.showError("加载失败");
//                    }
//                });
//        addSubscription(subscription);
    }

    @Override
    public void getCityCode() {
//        App.CITYCODE = realmService.getCityCode(App.CITY.substring(0, App.CITY.length() - 1));
    }
}