package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaInfoForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface PublicSeaInfoActivityContract {

    interface View extends BaseView {
        /**
         *成功
         */
        void   succeed(PublicSeaListBean publicSeaListBean);
        void   succeed1(PublicSeaInfoForMemberBean publicSeaInfoForMemberBean);


        void outLogin();
    }

    interface Presenter extends BasePresenter<View> {

//        void login(String userName,String passWord);
        void getPublicseaCustomerInfoById( String UserName  ,int UserId  ,String token  ,int ClubId  ,String CustomerId);
        void getPublicseaMemberInfoById( String UserName  ,int UserId  ,String token  ,int ClubId  ,String MemberId);

    }
}
