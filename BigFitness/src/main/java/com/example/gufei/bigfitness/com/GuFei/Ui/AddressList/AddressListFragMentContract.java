package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.ApkUpdataModel;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddressBookBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 通讯录列表接口层
 */

public interface AddressListFragMentContract {

    interface View extends BaseView {     void outLogin();

        void succeed(AddressBookBean addressBookBean);//成功后回调方法
    }

    interface Presenter extends BasePresenter<View> {

        void getAddressBook(int userid, String token, String search, int clubid);//获取数据

    }
}
