package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface PersonalInfoActivityContract {

    interface View extends BaseView {

        /**
         *成功
         */
        void   succeed(UserInfo userInfo);


        void outLogin();

        /**
         * 修改成功
         */
        void complete();
    }

    interface Presenter extends BasePresenter<View> {

//        void login(String userName,String passWord);
        void getUserInfo(int userid, String token);


        void updateUserInfo(String userId, String clubId, String token, String header, String userName, String sex, String age, String tel, String mail, String idCard);
    }
}
