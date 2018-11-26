package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberwardrobeListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CourseListActivityContract {



    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(MemberwardrobeListBean memberwardrobeListBean);

        void succeedLessonListForMember(LessonListForMemberBean lessonListForMemberBean);
//
//        /**
//         * 保存帐号密码
//         */
//        void remember(String account, String password);
//
//        /**
//         * 移除保存
//         */
//        void remove();

    }

    interface Presenter extends BasePresenter<View> {

        //        void login(String userName,String passWord);
//        void get(String type);
        void getMemberwardrobeList( int UserId  ,String token  ,int ClubId  ,String MemberId  ,String Status);
        void getLessonListForMember( int UserId  ,String token  ,int ClubId  ,String MemberId  );


    }
}
