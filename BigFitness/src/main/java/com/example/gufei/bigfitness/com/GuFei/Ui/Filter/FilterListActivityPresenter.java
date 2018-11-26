package com.example.gufei.bigfitness.com.GuFei.Ui.Filter;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppPreloadDicBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.example.gufei.bigfitness.util.SpUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

import static com.example.gufei.bigfitness.Constants.CARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.WARDROBETYPEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.toJson;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class FilterListActivityPresenter extends RxPresenter<FilterListActivityContract.View> implements FilterListActivityContract.Presenter {


    private Api api;


    @Inject
    public FilterListActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updata(int UserId, String token, int ClubId, String LessonType) {
        Subscription subscription = api.getLessonListForDrop(UserId, token, ClubId, LessonType)

                .compose(RxUtil.<LessonListForDropBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonListForDropBean>() {
                    @Override
                    public void call(LessonListForDropBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

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
    public void getAppointmentresult(int UserId, String token, int ClubId, String AppointmentTypeId) {

        Subscription subscription = api.getAppointmentresult( UserId  ,token  ,ClubId  ,AppointmentTypeId)

                .compose(RxUtil.<AppointmentresultBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentresultBean>() {
                    @Override
                    public void call(AppointmentresultBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedAppointmentresult(normalResponse);
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
    public void getAppointmentListForMemberId(int UserId, String token, int ClubId, String MemberId, String personType) {

        Subscription subscription = api.getAppointmentListForMemberId( UserId  ,token  ,ClubId  ,MemberId  ,personType)

                .compose(RxUtil.<AppointmentListForMemberIdBean>rxSchedulerHelper())

                .subscribe(new Action1<AppointmentListForMemberIdBean>() {
                    @Override
                    public void call(AppointmentListForMemberIdBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedAppointmentListForMemberIdBean(normalResponse);
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
    public void getPersonList(int UserId, String token, int ClubId, String appType, String personType, String NameOrTel,String IsMember) {
        Subscription subscription = api.getPersonList( UserId  ,token  ,ClubId  ,appType  ,personType,NameOrTel,IsMember)

                .compose(RxUtil.<PersonListBean>rxSchedulerHelper())

                .subscribe(new Action1<PersonListBean>() {
                    @Override
                    public void call(PersonListBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedPersonListBean(normalResponse);
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
    public void getLessonMemberListForContactTeacher(int UserId, String token, int ClubId, String appType, String personType,String NameOrTel) {
        Subscription subscription = api.getLessonMemberListForContactTeacher( UserId  ,token  ,ClubId  ,appType  ,personType,NameOrTel)

                .compose(RxUtil.<PersonListBean>rxSchedulerHelper())

                .subscribe(new Action1<PersonListBean>() {
                    @Override
                    public void call(PersonListBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedPersonListBean(normalResponse);
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

    //日程预约根据预约类型为补课预约 选择预约人员
    @Override
    public void getMakeUpMemberListForContactTeacher(int UserId, String token, int ClubId, String appType, String personType, String NameOrTel, String IsMakeUp) {
        Subscription subscription = api.getMakeUpMemberListForContactTeacher( UserId  ,token  ,ClubId  ,appType  ,personType,NameOrTel, IsMakeUp)

                .compose(RxUtil.<PersonListBean>rxSchedulerHelper())

                .subscribe(new Action1<PersonListBean>() {
                    @Override
                    public void call(PersonListBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedPersonListBean(normalResponse);
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
    public void getCustomerIntroducer(int userid, String token, int clubid,String Name) {
//介绍人信息
        Subscription subscription = api.getCustomerIntroducer( userid,  token,  clubid,Name)

                .compose(RxUtil.<CustomerIntroducerBean>rxSchedulerHelper())

                .subscribe(new Action1<CustomerIntroducerBean>() {
                    @Override
                    public void call(CustomerIntroducerBean normalResponse) {

                        if (normalResponse.getCode()==0) {
                            mView.succeedCustomerIntroducerBean(normalResponse);
                            SpUtil.put(App.context, CUSTOMERINTRODUCERKEY, toJson(normalResponse.getResult()));

                        }           if (normalResponse.getCode()==250){

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
    public void getCustomerSource(int userid, String token, int clubid,String Name) {
        Subscription subscription = api.getCustomerSource( userid,  token,  clubid,Name)

                .compose(RxUtil.<CustomerSourceBean>rxSchedulerHelper())

                .subscribe(new Action1<CustomerSourceBean>() {
                    @Override
                    public void call(CustomerSourceBean normalResponse) {

                        if (normalResponse.getCode()==0) {
                            mView.succeedCustomerSource(normalResponse);
                            SpUtil.put(App.context, CUSTOMERSOURCEKEY, toJson(normalResponse.getResult()));

                        }          if (normalResponse.getCode()==250){

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
    public void getLessonListForMember(int UserId, String token, int ClubId, String MemberId) {
        Subscription subscription = api.getLessonListForMember(   UserId  ,token  ,ClubId  ,MemberId )

                .compose(RxUtil.<LessonListForMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonListForMemberBean>() {
                    @Override
                    public void call(LessonListForMemberBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedLessonListForMember(normalResponse);


                        } else if (normalResponse.getCode() == 250) {

                            mView.outLogin();

                        } else {

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

    //补课列表
    @Override
    public void getMakeUpMemberLessonList(int UserId, String token, int ClubId, String MemberId) {
        Subscription subscription = api.getMakeUpMemberLessonList(   UserId  ,token  ,ClubId  ,MemberId )

                .compose(RxUtil.<LessonListForMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonListForMemberBean>() {
                    @Override
                    public void call(LessonListForMemberBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedLessonListForMember(normalResponse);


                        } else if (normalResponse.getCode() == 250) {

                            mView.outLogin();

                        } else {

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