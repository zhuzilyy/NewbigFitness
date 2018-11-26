package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MultimediaBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ImgVideoListActivityContract {



    interface View extends BaseView {

        /**
         * 获取成功
         */
        void succeed(MultimediaBean multimediaBean);

        void outLogin();
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

         void getMyUserTeacherResList(int UserId, String token);
    }
}
