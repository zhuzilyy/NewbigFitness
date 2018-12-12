package com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;

public interface UpdateVersionContract {
    interface View extends BaseView {
        void succeed(UpdateBean updateBean);
    }
    interface Presenter extends BasePresenter<View> {
        void updateApp();
    }
}

