package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberwardrobeListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CourseDetailsActivityContract {



    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(MemberWardrobeInfoBean memberWardrobeInfoBean);
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
        void getMemberWardrobeInfo( int UserId  ,String token  ,int ClubId  ,int WardrobeId  ,String MemberId);

    }
}
