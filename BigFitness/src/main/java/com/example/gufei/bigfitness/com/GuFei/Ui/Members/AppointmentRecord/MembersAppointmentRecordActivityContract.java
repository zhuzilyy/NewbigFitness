package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListAllBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MembersAppointmentRecordActivityContract {

    interface View extends BaseView {    void outLogin();

        void succeed(MemberAppointmentListAllBean
                             memberAppointmentListAllBean);

    }

    interface Presenter extends BasePresenter<View> {

//        void getCustomerAppointmentListAll(String UserName, int UserId, String token, int ClubId, String AppointmentId, String CustomerId);
        void getMemberAppointmentListAll(String UserName, int UserId, String token, int ClubId, String AppointmentId, String MemberId,String PersonType);

    }
}
