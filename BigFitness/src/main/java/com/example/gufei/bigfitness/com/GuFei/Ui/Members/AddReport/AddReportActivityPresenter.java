package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class AddReportActivityPresenter extends RxPresenter<AddReportActivityContract.View> implements AddReportActivityContract.Presenter {


    private Api api;




    @Inject
    public AddReportActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void saveMemberBodyReport(int UserId, String token, int ClubId, String UserName, String MemberId, String ImageData,String ReportTime) {

        Subscription subscription = api.saveMemberBodyReport( UserName  ,UserId  ,token  ,ClubId,MemberId ,ImageData,ReportTime)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

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

}