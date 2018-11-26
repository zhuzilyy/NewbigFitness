package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AppointmentRecordActivityContract {

    interface View extends BaseView {    void outLogin();

        void succeed(CustomerAppointmentListBean customerAppointmentListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getCustomerAppointmentListAll(String UserName, int UserId, String token, int ClubId, String AppointmentId, String CustomerId,String PersonType);
//        void getMemberAppointmentListAll(String UserName, int UserId, String token, int ClubId, String AppointmentId, String MemberId);

    }
}
