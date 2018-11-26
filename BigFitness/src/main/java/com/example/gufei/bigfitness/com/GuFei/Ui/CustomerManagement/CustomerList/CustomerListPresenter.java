package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

import android.widget.Toast;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.ApkUpdataModel;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CustomerListPresenter extends RxPresenter<CustomerListContract.View> implements CustomerListContract.Presenter {


    private Api api;


    @Inject
    public CustomerListPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getCustomerList(String UserName, int UserId, int DepartId, String token, int ClubId, int IsDepartManager, int CurrentPage, int type, String SearchKey, String Sex, String IntentId, String SourceId, String StartCreateTime, String EndCreateTime, String CreateUserId, String IntroduceMemberId, String LabelId, String OwnManagerId, String StartLastContactTime, String EndLastContactTime, String sort, String order) {


        Subscription subscription = api.getCustomerList(UserName, UserId, DepartId, token, ClubId, IsDepartManager, CurrentPage, type, SearchKey, Sex, IntentId, SourceId, StartCreateTime, EndCreateTime, CreateUserId, IntroduceMemberId, LabelId, OwnManagerId, StartLastContactTime, EndLastContactTime, sort, order)

                .compose(RxUtil.<CustomerListBean>rxSchedulerHelper())

                .subscribe(new Action1<CustomerListBean>() {
                    @Override
                    public void call(CustomerListBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        system.out.print(normalresponse.geturl());


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
    public void getMemberList(String UserName, int UserId, int DepartId, String token, int ClubId, int IsDepartManager, int CurrentPage, int type, String SearchKey, String MemberCardTypeId, String Sex, String IntentId, String SourceId, String StartCreateTime, String EndCreateTime, String CreateUserId, String IntroduceMemberId, String LabelId, String OwnManagerId, String OwnTeacherId, String POSTeacherId, String StartExpireTime, String EndExpireTime, String StartLastContactTime, String EndLastContactTime, String personType, String sort, String order) {
        Subscription subscription = api.getMemberList(UserName, UserId, DepartId, token, ClubId, IsDepartManager, CurrentPage, type, SearchKey, MemberCardTypeId, Sex, IntentId, SourceId, StartCreateTime, EndCreateTime, CreateUserId, IntroduceMemberId, LabelId, OwnManagerId, OwnTeacherId, POSTeacherId, StartExpireTime, EndExpireTime, StartLastContactTime, EndLastContactTime, personType, sort, order)


                .compose(RxUtil.<CustomerListBean>rxSchedulerHelper())

                .subscribe(new Action1<CustomerListBean>() {
                    @Override
                    public void call(CustomerListBean normalResponse) {

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

                        mView.showError(ErrMessages);


                    }
                });
        addSubscription(subscription);
    }

    @Override
    public void getLessonMemberList(String UserName, int UserId, String token, int ClubId, int IsDepartManager, int CurrentPage, int type, int DepartId, String SearchKey, String LessonType, String Sex, String IntentId, String SourceId, String LessonName, String LessonId, String SaleTeacherId, String LessonTeacherId, String LabelId, String OwnManagerId, String OwnTeacherId, String POSTeacherId, String StartStopTime, String EndStopTime, String StartLastContactTime, String EndLastContactTime, String personType, String sort, String order) {

        Subscription subscription = api.getLessonMemberList(UserName, UserId, token, ClubId, IsDepartManager, CurrentPage, type, DepartId, SearchKey, LessonType, Sex, IntentId, SourceId, LessonName, LessonId, SaleTeacherId, LessonTeacherId, LabelId, OwnManagerId, OwnTeacherId, POSTeacherId, StartStopTime, EndStopTime, StartLastContactTime, EndLastContactTime, personType, sort, order)

                .compose(RxUtil.<CustomerListBean>rxSchedulerHelper())

                .subscribe(new Action1<CustomerListBean>() {
                    @Override
                    public void call(CustomerListBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

//                            mView.PublicSeasucceed("变更成功");
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
    public void getNoMemberList(String UserName, int UserId, int DepartId, String token, int ClubId, int IsDepartManager, int CurrentPage, int type, String SearchKey, String Sex, String IntentId, String SourceId, String StartCreateTime, String EndCreateTime, String CreateUserId, String IntroduceMemberId, String LabelId, String OwnManagerId, String StartLastContactTime, String EndLastContactTime, String POSTeacherId, String OwnTeacherId, String sort, String order) {
        Subscription subscription = api.getNoMemberList(UserName, UserId, token, ClubId, IsDepartManager, CurrentPage, type, SearchKey, Sex, IntentId, SourceId, StartCreateTime, EndCreateTime, CreateUserId, IntroduceMemberId, LabelId, OwnManagerId, StartLastContactTime, EndLastContactTime, POSTeacherId, OwnTeacherId, sort, order)

                .compose(RxUtil.<CustomerListBean>rxSchedulerHelper())

                .subscribe(new Action1<CustomerListBean>() {
                    @Override
                    public void call(CustomerListBean normalResponse) {

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
    public void appThrowCustomerPublicSea(int UserId, String UserName, String token, int ClubId, String CustomerId, String PublicSeaId, String InPublicSeaCause) {
        Subscription subscription = api.appThrowCustomerPublicSea(UserId, UserName, token, ClubId, CustomerId, PublicSeaId, InPublicSeaCause)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());
                            mView.PublicSeasucceed("抛入成功");

//                            mView.succeed(normalResponse);

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
    public void appThrowMemberPublicSea(int UserId, String UserName, String token, int ClubId, String CustomerId, String PublicSeaId, String InPublicSeaCause) {
        Subscription subscription = api.appThrowMemberPublicSea(UserId, UserName, token, ClubId, CustomerId, PublicSeaId, InPublicSeaCause)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


//                        System.out.print(normalResponse.getUrl());


                            mView.PublicSeasucceed("抛入成功");

                        }
                        if (normalResponse.getCode() == 250) {

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
    public void appUpdateOwnManagerId(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewOwnmanagerId) {
        Subscription subscription = api.appUpdateOwnManagerId(UserId, UserName, token, ClubId, CustomerId, NewOwnmanagerId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

                            mView.PublicSeasucceed("变更成功");
//                            mView.succeed(normalResponse);

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
    public void updateMemberOwnManagerBatch(int UserId, String UserName, String token, int ClubId, String MemberId, String OwnManagerId) {
        Subscription subscription = api.updateMemberOwnManagerBatch(UserId, UserName, token, ClubId, MemberId, OwnManagerId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {


//                        System.out.print(normalResponse.getUrl());

                            mView.PublicSeasucceed("变更成功");
//                            mView.succeed(normalResponse);

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
    public void appGainCustomer(int UserId, String UserName, String token, int ClubId, String CustomerId, String PublicSeaId, String InPublicSeaCause) {
        Subscription subscription = api.appGainCustomer(UserId, UserName, token, ClubId, CustomerId, PublicSeaId, InPublicSeaCause)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

                            mView.PublicSeasucceed("捞取成功");
//                            mView.succeed(normalResponse);

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
    public void updateLessonMemberOwnTeacherBatch(int UserId, String UserName, String token, int ClubId, String Id, String TeacherId) {
        Subscription subscription = api.updateLessonMemberOwnTeacherBatch(UserId, UserName, token, ClubId, Id, TeacherId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {
                            mView.PublicSeasucceed("变更成功");

                        }
                        if (normalResponse.getCode() == 1) {
                            mView.PublicSeasucceed("变更失败!请重新提交");
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
                            mView.PublicSeasucceed("变更成功");

                        }
                        if (normalResponse.getCode() == 1) {
                            mView.PublicSeasucceed("变更失败!请重新提交");
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