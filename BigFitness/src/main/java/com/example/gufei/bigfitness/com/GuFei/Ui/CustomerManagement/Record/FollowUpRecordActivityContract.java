package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;

import java.util.Map;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface FollowUpRecordActivityContract {

    interface View extends BaseView {    void outLogin();

        void succeed(ContactListForCustomerBean contactListForCustomerBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getContactListForCustomer(String UserName  , int UserId  , String token  , int ClubId  , String AppointmentId  , String CustomerId,String PersonType);

    }
}
