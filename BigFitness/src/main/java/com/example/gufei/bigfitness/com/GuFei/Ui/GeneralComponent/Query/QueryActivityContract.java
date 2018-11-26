package com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface QueryActivityContract {

    interface View extends BaseView {    void outLogin();

        void succeed(MessageslistBean messageslistBean);
    }

    interface Presenter extends BasePresenter<View> {

        void updata(int i);

    }
}
