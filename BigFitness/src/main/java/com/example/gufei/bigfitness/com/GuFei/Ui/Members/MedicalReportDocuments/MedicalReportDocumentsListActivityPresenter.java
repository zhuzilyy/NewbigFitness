package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberBodyReportListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MedicalReportDocumentsListActivityPresenter extends RxPresenter<MedicalReportDocumentsListActivityContract.View> implements MedicalReportDocumentsListActivityContract.Presenter {


    private Api api;




    @Inject
    public MedicalReportDocumentsListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMemberBodyReportList(int UserId, String token, int ClubId, String MemberId, String sort, String order) {
        Subscription subscription = api.getMemberBodyReportList( UserId  ,token  ,ClubId  ,MemberId  ,sort  ,order)

                .compose(RxUtil.<MemberBodyReportListBean>rxSchedulerHelper())

                .subscribe(new Action1<MemberBodyReportListBean>() {
                    @Override
                    public void call(MemberBodyReportListBean normalResponse) {



                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);


                        }else if(normalResponse.getCode()==250){

                            mView.outLogin();

                        }else{

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
}