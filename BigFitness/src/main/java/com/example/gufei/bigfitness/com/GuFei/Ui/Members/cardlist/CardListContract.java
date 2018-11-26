package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardListBean;

public interface CardListContract {

    interface View extends BaseView {

        void outLogin();

        void succeed(CardListBean cardListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getCardList(int userId, String userName, String token, int clubId, String memberId, String status);
    }
}
