package com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class UpdateVersionPresent extends RxPresenter<UpdateVersionContract.View> implements UpdateVersionContract.Presenter {
    private Api api;
    @Inject
    public UpdateVersionPresent(Api api) {
        this.api = api;
    }
    @Override
    public void updateApp() {
        Subscription subscription = api.updateVersion()
                .compose(RxUtil.<UpdateBean>rxSchedulerHelper())
                .subscribe(new Action1<UpdateBean>() {
                    @Override
                    public void call(UpdateBean updateBean) {
                        if (updateBean.getRet() == 0) {
                            mView.succeed(updateBean);
                        } else {
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("服务器请求失败");
                    }
                });
        addSubscription(subscription);
    }
}