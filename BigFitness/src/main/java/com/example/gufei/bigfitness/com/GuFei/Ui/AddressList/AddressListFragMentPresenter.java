package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.ApkUpdataModel;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddressBookBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 通讯录列表P层
 */

public class AddressListFragMentPresenter extends RxPresenter<AddressListFragMentContract.View> implements AddressListFragMentContract.Presenter {


    private Api api;


    @Inject
    public AddressListFragMentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getAddressBook(int userid, String token, String search, int clubid) {

        Subscription subscription = api.getAddressBook(userid,token,search,clubid)

                .compose(RxUtil.<AddressBookBean>rxSchedulerHelper())

                .subscribe(new Action1<AddressBookBean>() {
                    @Override
                    public void call(AddressBookBean normalResponse) {

                       mView.succeed(normalResponse);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

//                        mView.showError(ErrMessages);+


                    }
                });
        addSubscription(subscription);
    }


}