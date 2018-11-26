package com.example.gufei.bigfitness.com.GuFei.Component;


import com.example.gufei.bigfitness.com.GuFei.Moudel.FragmentModule;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMent;

import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3.Index3FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4.Index4FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History.TrainingPlanListHistoryFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today.TrainingPlanListTodayFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList.SelectListFragent;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.IndexFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon.MonFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day.DayFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list.ListFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week.WeekFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMent;

import dagger.Component;

/**
 * Created by GuFei_lyf on 2017/3/21
 * Fragment的依赖
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)

public interface FragmentComponent {

//    void inject(IndexFragment indexFragment);



    void inject(SelectListFragent selectListFragent);

    void inject(IndexFragMent indexFragment);

    void  inject(AddressListFragMent addressListFragMent);

    void  inject(MyCenterMainFragMent myCenterMainFragMent);


    void  inject(TrainingPlanListTodayFragMent trainingPlanListTodayFragMent);

    void  inject(TrainingPlanListHistoryFragMent trainingPlanListHistoryFragMent);

    void  inject(MonFragment monFragment);

    void inject(IndexFragment indexFragment);

    void inject(DayFragment dayFragment);

    void inject(ListFragment listFragment);

    void inject(WeekFragment weekFragment);

    void inject(Index1FragMent index1FragMent);
    void inject(Index2FragMent index2FragMent);
    void inject(Index3FragMent index3FragMent);
    void inject(Index4FragMent index4FragMent);







//
//    void inject(NearFragment nearFragment);
//
//    void inject(ShoppingCartFragment shoppingCartFragment);
//
//    void inject(UserFragment userFragment);
//
//    void inject(LoginFragment loginFragment);
//
//    void inject(RegisterFragment registerFragment);
//
//    void inject(RetrieveFragment retrieveFragment);
//
//    void inject(NextFragment nextFragment);
}
