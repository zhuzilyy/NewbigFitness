package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MembersInfoActivityContract {

    interface View extends BaseView {    void outLogin();

        void succeed(MemberInfoBean memberInfoBean);
        void updatasucceed(CodeBean codeBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getMemberInfo(
                String UserName  ,int UserId  ,String token  ,int ClubId  ,int MemberId);
        void updateMemberIntentId(
                int UserId  ,String UserName  ,String token  ,int ClubId  ,String MemberId  ,String IntentId);

    }
}
