package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MyInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyCenterMainFragMentContract {

    interface View extends BaseView {    void outLogin();

        void   succeed(MyInfoBean myInfoBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getMyInfo(int UserId  ,String token);


    }
}
