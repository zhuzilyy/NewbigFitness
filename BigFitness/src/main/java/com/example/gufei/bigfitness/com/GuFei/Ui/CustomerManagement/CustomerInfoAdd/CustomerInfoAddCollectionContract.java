package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CustomerInfoAddCollectionContract {

    interface View extends BaseView {

        void outLogin();

        /**
         *添加成功
         */
        void   addPersonalSuccess();
    }
    interface Presenter extends BasePresenter<View> {
        /**
         * 修改信息
         */
        void addCustomer(int UserId, String token, int ClubId, String UserName, String CustomerName, String IntentId, String IntroduceMemberId, String LabelId, String OwnManagerId, String Remark, String Sex, String SourceId, String Tel, String Presalemembercardtypeid, String Presalemoney);

    }
}
