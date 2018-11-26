package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.StarEvaluateBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AppraiseActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(StarEvaluateBean starEvaluateBean);
    }

    interface Presenter extends BasePresenter<View> {



        void getMyStarEvaluate( int UserId  ,String token  ,int CurrentPage  ,String EvaluateStar);

    }
}
