package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AppointmentDetailsActivityContract {



    interface View extends BaseView {    void outLogin();


        void succeed(MessageslistBean messageslistBean);
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
//        void get(int type);

    }
}
