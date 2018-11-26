package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberBodyReportListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MedicalReportDocumentsListActivityContract {



    interface View extends BaseView {    void outLogin();

        /**
         * 登录成功
         */
        void succeed(MemberBodyReportListBean memberBodyReportListBean);
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
        void getMemberBodyReportList(
                int UserId  ,
                String token  ,
                int ClubId  ,
                String MemberId  ,
                String sort  ,
                String order
        );

    }
}
