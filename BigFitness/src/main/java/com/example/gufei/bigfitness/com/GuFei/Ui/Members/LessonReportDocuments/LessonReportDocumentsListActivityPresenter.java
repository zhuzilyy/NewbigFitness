package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CompleteLessonListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberBodyReportListBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class LessonReportDocumentsListActivityPresenter extends RxPresenter<LessonReportDocumentsListActivityContract.View> implements LessonReportDocumentsListActivityContract.Presenter {


    private Api api;


    @Inject
    public LessonReportDocumentsListActivityPresenter(Api api) {
        this.api = api;
    }



    @Override
    public void getCompleteLessonList(int UserId, String token, int ClubId, String MemberId, int CurrentPage, String LessonType, String LessonName, String TeacherId, String StartDate, String EndDate) {
        Subscription subscription = api.getCompleteLessonList(UserId, token, ClubId, MemberId, CurrentPage, LessonType, LessonName, TeacherId, StartDate, EndDate)

                .compose(RxUtil.<CompleteLessonListBean>rxSchedulerHelper())

                .subscribe(new Action1<CompleteLessonListBean>() {
                    @Override
                    public void call(CompleteLessonListBean normalResponse) {


                        if (normalResponse.getCode() == 0) {

                            mView.succeed(normalResponse);


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