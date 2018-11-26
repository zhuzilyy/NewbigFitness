package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.Schedule;

import java.util.List;


public interface WeekContract {

    interface View extends BaseView {

        void outLogin();

        void loadData(List<Schedule.ResultBean> list);

    }

    interface Presenter extends BasePresenter<View> {

        void init();
        void getSchedule(String s, String token, String s1, String s2, String date, String d);
    }

}
