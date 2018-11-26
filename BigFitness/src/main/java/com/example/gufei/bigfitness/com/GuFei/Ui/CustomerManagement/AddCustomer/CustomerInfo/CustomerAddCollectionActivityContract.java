package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

import retrofit2.http.Field;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CustomerAddCollectionActivityContract {

    interface View extends BaseView {
        void outLogin();

        /**
         * 成功
         */
        void Success(CodeBean codeBean);

        void SuccessTel(CodeBean codeBean);


    }

    interface Presenter extends BasePresenter<View> {


        /**
         * 获科客户信息
         */
        void addCustomer(
                int UserId,
                String token,
                int ClubId,
                String UserName,
                String CustomerName,
                String IntentId,
                String IntroduceMemberId,
                String LabelId,
                String OwnManagerId,
                String Remark,
                String Sex,
                String SourceId,
                String Tel,
                String Presalemembercardtypeid,
                String Presalemoney);



        void getCustomerCheckByTel(int UserId, String token, int ClubId, String Tel);
//


    }
}
