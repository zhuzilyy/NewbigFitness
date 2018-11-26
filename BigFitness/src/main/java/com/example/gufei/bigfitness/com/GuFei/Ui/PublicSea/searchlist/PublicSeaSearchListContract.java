package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface PublicSeaSearchListContract {

    interface View extends BaseView {

        void outLogin();

        void   succeed(PublicSeaBean publicSeaBean);
        void   membersucceed(PublicSeaMemberBean publicSeaBean);


    }

    interface Presenter extends BasePresenter<View> {

        void appPublicSeaMemberList(String userName, int userId, String token, int clubId, int page, String s, String s1, String s2, String s3, String s4, String query);

        void appPublicSeaCustomerList(String userName, int userId, String token, int clubId, int page, String s, String s1, String s2, String s3, String s4, String query);
    }

}
