package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MembersInfoDetailsActivityContract {


    interface View extends BaseView {
        void outLogin();

        /**
         * 登录成功
         */
        void succeed(MemberInfoBean memberInfoBean);

        void updataSucceed(CodeBean codeBean);
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
//        void get(String type);
        void getMemberInfo(
                String UserName, int UserId, String token, int ClubId, int MemberId);


        void updateMemberInfo(
                int UserId,
                String UserName,
                String token,
                int ClubId,
                String MemberId,
                String Birthday,
                String CarBrand,
                String CardNo,
                String CardTypeId,
                String Career,
                String CarType,
                String Country,
                String EmergencyPersonName,
                String EmergencyTel,
                String FitnessExperience,
                String FitnessRequest,
                String HomeAddress,
                String HomeTel,
                String WorkCompany,
                String WorkAddress,
                String Nation,
//                 ,String Nation  ,String IsMarriaged  ,
                String InCome,  String CarNo
//                 String Remark
        );

    }
}
