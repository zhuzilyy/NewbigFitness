package com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PushUserMessageInfoBean;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MessagesListActivityContract {



    interface View extends BaseView {
        void outLogin();
        void succeed(MessageslistBean messageslistBean);
        void Infosucceed(PushUserMessageInfoBean pushUserMessageInfoBean);
        void AllReadsucceed(CodeBean CodeBean);
        void AllDelsucceed(CodeBean codeBean);
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

          void getPushUserMessageList(
                int UserId  ,String token  ,int ClubId  ,int CurrentPage,String MsgTypeId);
        void getPushUserMessageInfo(
                int UserId  ,String token  ,int ClubId  ,int MessageId);
       void updateAllPushUserMessageReadType(
                int UserId  ,String token  ,int ClubId,String MsgTypeId );

        void delAllPushUserMessageRead(
                int UserId  ,String token  ,int ClubId,String MsgTypeId);


    }
}
