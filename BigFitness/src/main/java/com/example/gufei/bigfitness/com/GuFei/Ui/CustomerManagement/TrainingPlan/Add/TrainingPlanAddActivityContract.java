package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainActionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages.MessagesListActivityContract;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TrainingPlanAddActivityContract {



    interface View extends BaseView {    void outLogin();


        void succeed(TrainActionDropListBean trainActionDropListBean);
        void succeedAdd(CodeBean codeBean);
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

    interface Presenter extends BasePresenter<TrainingPlanAddActivityContract.View> {

        //        void login(String userName,String passWord);
        void getTrainActionDropList(
                String UserName  ,int UserId  ,String token  ,int ClubId ,String PositionId);
        void saveTrainAction(
                String UserName  ,int UserId  ,String token  ,int ClubId  ,String ActionName  ,String PositionId);

    }
}
