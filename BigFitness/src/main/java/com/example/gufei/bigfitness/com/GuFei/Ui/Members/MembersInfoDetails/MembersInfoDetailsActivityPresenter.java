package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivityContract;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MembersInfoDetailsActivityPresenter extends RxPresenter<MembersInfoDetailsActivityContract.View> implements MembersInfoDetailsActivityContract.Presenter {


    private Api api;




    @Inject
    public MembersInfoDetailsActivityPresenter(Api api) {
        this.api = api;
    }



    @Override
    public void getMemberInfo(String UserName, int UserId, String token, int ClubId, int MemberId) {
        Subscription subscription = api.getMemberInfo(UserName  ,UserId  ,token  ,ClubId  ,MemberId )

                .compose(RxUtil.<MemberInfoBean>rxSchedulerHelper())

                .subscribe(new Action1<MemberInfoBean>() {
                    @Override
                    public void call(MemberInfoBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.succeed(normalResponse);


                        }        if (normalResponse.getCode()==250){

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
    public void updateMemberInfo(int UserId, String UserName, String token, int ClubId, String MemberId, String Birthday, String CarBrand, String CardNo, String CardTypeId, String Career, String CarType, String Country, String EmergencyPersonName, String EmergencyTel, String FitnessExperience, String FitnessRequest, String HomeAddress, String HomeTel, String WorkCompany, String WorkAddress, String Nation, String InCome, String CarNo) {
        Subscription subscription = api.updateMemberInfo(UserId  ,UserName  ,token,ClubId  ,MemberId  ,Birthday  ,CarBrand  ,CardNo  ,CardTypeId  ,Career  ,CarType  ,Country  ,EmergencyPersonName  ,EmergencyTel  ,FitnessExperience  ,FitnessRequest  ,HomeAddress,HomeTel  ,WorkCompany  ,WorkAddress ,Nation,InCome ,CarNo  )

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode()==0){

                            mView.updataSucceed(normalResponse);


                        }        if (normalResponse.getCode()==250){

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