package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List;

import android.widget.Toast;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
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

public class PublicSeaListPresenter extends RxPresenter<PublicSeaListContract.View> implements PublicSeaListContract.Presenter {


    private Api api;


    @Inject
    public PublicSeaListPresenter(Api api) {
        this.api = api;
    }


    //    @Override
//    public void getCustomerList(String UserName, int UserId, int DepartId  ,String token, int ClubId, int IsDepartManager, int CurrentPage, int type, String SearchKey, String Sex, String IntentId, String SourceId, String StartCreateTime, String EndCreateTime, String CreateUserId, String IntroduceMemberId, String LabelId, String OwnManagerId, String StartLastContactTime, String EndLastContactTime, String sort, String order) {
//
//
//
//        Subscription subscription = api.getCustomerList(UserName  ,UserId  ,DepartId,token  ,ClubId  ,IsDepartManager  ,CurrentPage  ,type  ,SearchKey  ,Sex  ,IntentId  ,SourceId  ,StartCreateTime  ,EndCreateTime  ,CreateUserId  ,IntroduceMemberId  ,LabelId  ,OwnManagerId  ,StartLastContactTime  ,EndLastContactTime  ,sort  ,order)
//
//                .compose(RxUtil.<CustomerListBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<PublicSeaBean>() {
//                    @Override
//                    public void call(CustomerListBean normalResponse) {
//
//                        if (normalResponse.getCode()==0){
//
//                        System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//
//                        mView.succeed(normalResponse);
//
//                        }        if (normalResponse.getCode()==250){
//
//                            mView.outLogin();
//
//                        }
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
////                        mView.showError(ErrMessages);+
//
//
//                    }
//                });
//        addSubscription(subscription);
//
//
//    }
//    }
    @Override
    public void updateMemberLessonTeacher(int UserId, String UserName, String token, int ClubId, String CustomerId, String TeacherId) {
        Subscription subscription = api.updateMemberLessonTeacher(UserId, UserName, token, ClubId, CustomerId, TeacherId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

//                            Toast.makeText(App.context, "", Toast.LENGTH_SHORT).show();
                           mView.succeedEdit("变更跟进教练成功!");

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void updateMemberOwnTeacherBatch(int UserId, String UserName, String token, int ClubId, String CustomerId, String TeacherId) {
        Subscription subscription = api.updateMemberOwnTeacherBatch(UserId, UserName, token, ClubId, CustomerId, TeacherId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

//                            Toast.makeText(App.context, "!", Toast.LENGTH_SHORT).show();
                           mView.succeedEdit("变更跟进教练成功!");

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void appUpdateOwnManagerId(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewOwnmanagerId) {
        Subscription subscription = api.appUpdateOwnManagerId(UserId, UserName, token, ClubId, CustomerId, NewOwnmanagerId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

//                            Toast.makeText(App.context, "", Toast.LENGTH_SHORT).show();
                            mView.succeedEdit("变更会籍成功!");

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void appUpdateCustomerPublicSeaType(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewPublicSeaId, String Cause) {
        Subscription subscription = api.appUpdateCustomerPublicSeaType(
                UserId, UserName, token, ClubId, CustomerId, NewPublicSeaId, Cause)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                            Toast.makeText(App.context, "变更公海成功!", Toast.LENGTH_SHORT).show();
//                        System.out.print(normalResponse.getUrl());


                            mView.succeedPubluc(normalResponse);

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void appGainCustomer(int UserId, String UserName, String token, int ClubId, String CustomerId) {
        Subscription subscription = api.appGainCustomer(
                UserId, UserName, token, ClubId, CustomerId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {


//                        System.out.print(normalResponse.getUrl());


                            mView.succeedEdit("捞取成功!");

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void appPublicSeaCustomerList(String UserName, int UserId, String token, int ClubId, int CurrentPage, String StartDate, String EndDate, String PublicSeaId, String sort, String order) {
        Subscription subscription = api.appPublicSeaCustomerList(UserId, token, ClubId, CurrentPage, StartDate, EndDate, PublicSeaId, sort, order)

                .compose(RxUtil.<PublicSeaBean>rxSchedulerHelper())

                .subscribe(new Action1<PublicSeaBean>() {
                    @Override
                    public void call(PublicSeaBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());


                            mView.succeed(normalResponse);

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void appPublicSeaMemberList(String UserName, int UserId, String token, int ClubId, int CurrentPage, String StartDate, String EndDate, String PublicSeaId, String sort, String order) {
        Subscription subscription = api.appPublicSeaMemberList(UserId, token, ClubId, CurrentPage, StartDate, EndDate, PublicSeaId, sort, order)



                .compose(RxUtil.<PublicSeaMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<PublicSeaMemberBean>() {
                    @Override
                    public void call(PublicSeaMemberBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());


                            mView.membersucceed(normalResponse);

                        }
                        if (normalResponse.getCode() == 250) {

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