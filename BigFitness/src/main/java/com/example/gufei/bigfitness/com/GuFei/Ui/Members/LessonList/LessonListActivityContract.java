package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListByMemberIdBean;

public interface LessonListActivityContract {

    interface View extends BaseView {

        void outLogin();

        void succeed(LessonListByMemberIdBean lessonListByMemberIdBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getLessonListByMemberId( String UserName  ,int UserId  ,String token  ,int ClubId  ,String MemberId  ,String Status);
    }
}
