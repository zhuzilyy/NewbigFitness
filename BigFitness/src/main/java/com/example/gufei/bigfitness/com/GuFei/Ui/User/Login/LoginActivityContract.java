package com.example.gufei.bigfitness.com.GuFei.Ui.User.Login;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface LoginActivityContract {

    interface View extends BaseView {
        void outLogin();
        /**
         *登录成功
         */
        void   succeed(LoginBean loginBean);
        /**
         * 保存帐号密码
         */
        void remember(String account, String password,String deviceCoded,LoginBean loginBean ,boolean flag);
        /**
         * 移除保存
         */
        void remove();

    }

    interface Presenter extends BasePresenter<View> {

//        void login(String userName,String passWord);
    void login(String userName, String password,final  String DeviceCode, boolean remember);

    }
}
