package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface SetingActivityContract {

    interface View extends BaseView {
        /**
         *成功
         */
        void  succeed();
        void outLogin();
    }

    interface Presenter extends BasePresenter<View> {

//        void login(String userName,String passWord);
void changPsw(int userid, String token,int clubid, String UserName  ,String OldPwd  ,String NewPwd);
void outLogin(int userid, String token,int clubid, String UserName);
    }
}
