package com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter;

import android.widget.Toast;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListByMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonTeacherListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.example.gufei.bigfitness.util.SpUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.toJson;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TeacherFilterListActivityPresenter extends RxPresenter<TeacherFilterListActivityContract.View> implements TeacherFilterListActivityContract.Presenter {


    private Api api;


    @Inject
    public TeacherFilterListActivityPresenter(Api api) {
        this.api = api;
    }





    @Override
    public void getLessonListByMemberId(String UserName,int UserId, String token, int ClubId, String MemberId, String Status) {

        Subscription subscription = api.getLessonListByMemberId(UserName,UserId, token, ClubId, MemberId,Status)

                .compose(RxUtil.<LessonListByMemberIdBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonListByMemberIdBean>() {
                    @Override
                    public void call(LessonListByMemberIdBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedLessonListByMember(normalResponse);
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
    public void getLessonTeacherListForMember(int UserId, String token, int ClubId, String MemberId,String Id) {
        Subscription subscription = api.getLessonTeacherListForMember(UserId, token, ClubId, MemberId,Id)

                .compose(RxUtil.<LessonTeacherListForMemberBean>rxSchedulerHelper())

                .subscribe(new Action1<LessonTeacherListForMemberBean>() {
                    @Override
                    public void call(LessonTeacherListForMemberBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            mView.succeedLessonTeacherListForMember(normalResponse);
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
    public void updateMemberLessonTeacher(int UserId, String UserName, String token, int ClubId, String CustomerId, String TeacherId) {
        Subscription subscription = api.updateMemberLessonTeacher(UserId, UserName, token, ClubId, CustomerId, TeacherId)

                .compose(RxUtil.<CodeBean>rxSchedulerHelper())

                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getCode() == 0) {

                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//                        System.out.print(normalResponse.getUrl());

                            Toast.makeText(App.context, "变更跟进教练成功!", Toast.LENGTH_SHORT).show();
//                            mView.succeed(normalResponse);
                             mView.succeedEdit(normalResponse);

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

