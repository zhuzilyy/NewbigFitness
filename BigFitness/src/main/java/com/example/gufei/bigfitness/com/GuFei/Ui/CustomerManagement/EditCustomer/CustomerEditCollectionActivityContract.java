package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CustomerEditCollectionActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(CustomerInfoBean customerInfoBean);



    }

    interface Presenter extends BasePresenter<View> {


        /**
         * 获科客户信息
         */
        void getCustomerInfoById(int UserId, String token, int ClubId, String UserName, String CustomerId);
//







    }
}
