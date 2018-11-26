package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberNumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 报表:统计报表 接口
 */


public interface Index3FragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(MemberNumReportBean memberNumReportBean);


    }

    interface Presenter extends BasePresenter<View> {

        void updata(
                String IsDepartManager  ,
                String personType  ,
                String ClubList  ,
                String UserLevel  ,
                int UserId  ,
                String TeacherId  ,
                String ManagerId  ,
                String token  ,
                String SearchData);



    }



}
