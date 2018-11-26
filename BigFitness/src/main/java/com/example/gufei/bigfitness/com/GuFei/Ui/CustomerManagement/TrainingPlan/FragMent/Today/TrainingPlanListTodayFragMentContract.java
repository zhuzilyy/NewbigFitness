package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainPositionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TrainingPlanListTodayFragMentContract {



    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(TrainingPlanBean trainingPlanBean);
        void succeed1PostionList(TrainPositionDropListBean trainPositionDropListBean);
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
        void get(String type);

        void getTrainPositionDropList(
                String UserName  ,int UserId  ,String token  ,int ClubId);
    }
}
