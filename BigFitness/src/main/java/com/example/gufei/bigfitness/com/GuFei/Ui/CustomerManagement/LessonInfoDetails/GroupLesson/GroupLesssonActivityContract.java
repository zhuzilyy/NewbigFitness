package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.GroupLesssonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PrivateLessonInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface GroupLesssonActivityContract {



    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(GroupLesssonInfoBean groupLesssonInfoBean);
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
        void getGroupLessonInfoById(String UserName, int UserId, String token, int ClubId, int Id);

    }
}
