package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;

/**
 * Description
 *
 * @author GuFei
 * @version 2016 10 12 16:05
 */

public interface SelectListContract {

    interface View extends BaseView {

//        /**
//         * 加载首页数据
//         * @param indexData
//         */
//        void loadData(IndexData indexData);
//
//        /**
//         * 更新每日优惠列表
//         * @param list
//         */
//        void updateList(List<DailySpecials> list);

        /**
         * 修改城市名称
         * @param name
         */
        void updateCity(String name);
        void outLogin();
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 首页初始化
         */
        void init();

        /**
         * 换一批
         */
        void change(int currentPage);

        /**
         * 获取城市代码
         */
        void getCityCode();

    }

}
