package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CustomerInfoCollectionContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(CustomerInfoBean customerInfoBean);

        void EditSuccess(CodeBean codeBean);



    }

    interface Presenter extends BasePresenter<View> {


        /**
         * 获科客户信息
         */
        void getCustomerInfoById(int UserId, String token, int ClubId, String UserName, String CustomerId);
//
        /**
         * 获科客户信息
         */
        void EditCustomer(

                int UserId  ,
                String token  ,
                int ClubId  ,
                String UserName  ,
                String CustomerName  ,
                String IntentId  ,
                String IntroduceMemberId  ,
                String LabelId  ,
                String OwnManagerId  ,
                String Remark  ,
                String Sex  ,
                String SourceId  ,
                String Tel  ,
                String Presalemembercardtypeid  ,
                String Presalemoney,
                String CustomerId
        );






    }
}
