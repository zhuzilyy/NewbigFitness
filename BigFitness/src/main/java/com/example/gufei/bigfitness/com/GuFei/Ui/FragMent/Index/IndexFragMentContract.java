package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(MainMsgBean testBean);
        void MainPagesucceed(SineForMainPageBean sineForMainPageBean);

    }

    interface Presenter extends BasePresenter<View> {

        void updata(int userid, String token, int clubid);

        void getSineForMainPage(int userid, String token, int clubid);

    }
}
