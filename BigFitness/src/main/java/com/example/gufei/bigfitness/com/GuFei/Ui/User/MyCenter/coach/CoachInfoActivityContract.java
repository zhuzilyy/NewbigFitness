package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CoachInfoActivityContract {

    interface View extends BaseView {
        /**
         *成功
         */
        void   succeed(TeacherInfoBean teacherInfoBean);
        void   succeedUpdata(CodeBean codeBean);


        void outLogin();
    }

    interface Presenter extends BasePresenter<View> {

//        void login(String userName,String passWord);
        void getTeacherInfo(int userid, String token);
        void updateTeacherInfo( int UserId  ,String token  ,int ClubId  ,String UserName  ,String Height  ,String Weight);

    }
}
