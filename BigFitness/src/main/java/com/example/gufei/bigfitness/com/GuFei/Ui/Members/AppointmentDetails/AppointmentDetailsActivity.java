package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class AppointmentDetailsActivity extends BaseActivity<AppointmentDetailsActivityPresenter> implements AppointmentDetailsActivityContract.View {



    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_appointment_details;

    }

    @Override
    protected void initView() {

        //R.layout.cardview_booking_details  使用这个item布局

    }

    @Override
    protected void initData() {

    }

    @Override
    public void succeed(MessageslistBean messageslistBean) {

    }

    @Override
    public void showEmpty() {

    }
    @Override
    public void outLogin() {

        s(this, "您的帐号在其他设备登录");

        Intent intent = new Intent(context, LoginActivity.class);
        remove();
        startActivity(intent);
        finish();

    }



    @Override
    public void Loading() {

    }
}
