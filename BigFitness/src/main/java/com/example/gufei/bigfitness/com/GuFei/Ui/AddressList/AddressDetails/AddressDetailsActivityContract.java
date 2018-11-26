package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
/**
 * Created by GuFei_lyf on 2017/3/22
 * 通讯录详情页接口层
 */

public interface AddressDetailsActivityContract {

    interface View extends BaseView {     void outLogin();

        void   succeed();//成功回调
    }

    interface Presenter extends BasePresenter<View> {

        void updata(String s);//请求数据

    }
}
