package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList;

import android.content.Intent;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.util.ToastUtil.s;


public class SelectListFragent extends BaseFragment<SelectListPresenter> implements SelectListContract.View {


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.id.content_select_list_fragent;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void updateCity(String name) {

    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {


        Intent intent = new Intent(context, LoginActivity.class);


        startActivity(intent);

    }



    @Override
    public void Loading() {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_select_list_fragent);
//
//    }

}
