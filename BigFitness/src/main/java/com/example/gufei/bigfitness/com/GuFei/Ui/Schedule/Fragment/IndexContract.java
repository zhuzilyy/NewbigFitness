package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment;



import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.IndexData;

/**
 * Description
 *
 * @author GuFei
 * @version 2016 10 12 16:05
 */

public interface IndexContract {

    interface View extends BaseView {    void outLogin();

        /**
         * 加载首页数据
         * @param indexData
         */
        void loadData(IndexData indexData);



//        /**
//         * 修改城市名称
//         * @param name
//         */
//        void updateCity(String name);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 首页初始化
         */
        void init();



    }

}
