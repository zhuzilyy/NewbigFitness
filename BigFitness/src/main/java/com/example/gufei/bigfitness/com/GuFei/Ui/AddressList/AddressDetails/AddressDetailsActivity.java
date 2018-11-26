package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.PhoneBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 通讯录详情页实现
 */

public class AddressDetailsActivity extends BaseActivity<AddressDetailsActivityPresenter> implements AddressDetailsActivityContract.View {

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.item_phone_txt_name)
    TextView itemPhoneTxtName;
    @BindView(R.id.item_phone_txt_position)
    TextView itemPhoneTxtPosition;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.btn_msg)
    ImageView btnMsg;
    @BindView(R.id.btn_tel)
    ImageView btnTel;
    @BindView(R.id.departtext)
    TextView departtext;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;
    private PhoneBean phoneBean = new PhoneBean();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_address_details;
    }

    @Override
    protected void initView() {

        Gson bean = new Gson();

        Intent intent = getIntent();

        String s = intent.getStringExtra("com.example.gufei.bigfitness");

        phoneBean = bean.fromJson(s, PhoneBean.class);
//
        itemPhoneTxtName.setText(phoneBean.getName());

        itemPhoneTxtPosition.setText(phoneBean.getSex() +"  "+phoneBean.getPosition());

        tel.setText(phoneBean.getTel());

//        displayImage(context, phoneBean.getHeadimg(), headImg);
        displayCircleImage(mContext  ,   phoneBean.getHeadimg(),  headImg,R.mipmap.privatememberinfor_03);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void succeed() {

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


    @OnClick({R.id.btn_msg, R.id.btn_tel,R.id.btn_back})
    public void onViewClicked(View view) {

        String number = tel.getText().toString();
        switch (view.getId()) {
            case R.id.btn_msg:

//                Intent sms = new Intent(Intent.ACTION_VIEW);
//                Uri smsdata = Uri.parse("tel:" + number);
//                sms.setData(smsdata);
//
//                startActivity(sms);


                Uri uri = Uri.parse("smsto:" + number);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);

                startActivity(sendIntent);


                break;
            case R.id.btn_back:

 finish();

                break;

            case R.id.btn_tel:

                // TODO Auto-generated method stub


                Intent tel = new Intent(Intent.ACTION_VIEW);
                Uri teldata = Uri.parse("tel:" + number);
                tel.setData(teldata);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(tel);

                break;
        }
    }


}
