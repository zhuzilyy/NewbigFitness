package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AddMembersFollowActivityContract {



    interface View extends BaseView {

        void outLogin();

        /**
         * 登录成功
         */
        void succeed(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {

        //        void login(String userName,String passWord);
        void insertMemberAppointmentByMemberID(
                String UserName  ,int UserId  ,String token  ,int ClubId  ,String AppointmentId  ,String ContactContent  ,String MemberId  ,String imgsrc);
        //        void login(String userName,String passWord);
        void saveCustomerContact( String UserName  ,int UserId  ,String token  ,int ClubId  ,String AppointmentId  ,String ContactContent  ,String CustomerId  ,String imgsrc);
    }
}
