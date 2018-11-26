package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListByMemberIDBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MembersFollowUpRecordActivityContract {

    interface View extends BaseView {    void outLogin();

        void succeed(MemberAppointmentListByMemberIDBean memberAppointmentListByMemberID);
        void succeed1(ContactListForCustomerBean contactListForCustomerBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getMemberAppointmentListByMemberID(
                String UserName  ,int UserId  ,String token  ,int ClubId  ,String IsDepartManager  ,String MemberId,String PersonType);
        void getContactListForCustomer(String UserName  , int UserId  , String token  , int ClubId  , String AppointmentId  , String CustomerId,String PersonType);
    }
}
