package com.example.gufei.bigfitness.com.GuFei.Ui.main;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion.UpdateBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void   succeed(MainMsgBean testBean);

        void outLogin();
        void update(UpdateBean updateBean);
    }

    interface Presenter extends BasePresenter<View> {

        void updata(int userid, String token, int clubid,String IsDepartManager   ,String DepartId);
          void getCustomerSource(int userid, String token, int clubid);
          void getCustomerIntroducer(int userid, String token, int clubid,String Name);
        void upDateApp(String appType);

    }
}
