package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardInfoBean;

public interface TimeCardInfoActivityContract {

    interface View extends BaseView {

        void outLogin();

        void succeed(CardInfoBean cardInfoBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getCardInfo(int userId, String userName, String token, int clubId, int cardId);
    }
}
