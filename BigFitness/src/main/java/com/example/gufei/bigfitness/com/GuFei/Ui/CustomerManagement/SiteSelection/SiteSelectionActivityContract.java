package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainPositionDropListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface SiteSelectionActivityContract {



    interface View extends BaseView {    void outLogin();


        void succeed(TrainPositionDropListBean trainPositionDropListBean);
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

    interface Presenter extends BasePresenter<View> {

        //        void login(String userName,String passWord);
        void getTrainPositionDropList(
                String UserName  ,int UserId  ,String token  ,int ClubId);
        void saveTrainPosition(
                String UserName  ,int UserId  ,String token  ,int ClubId  ,String PositionName);

    }
}
