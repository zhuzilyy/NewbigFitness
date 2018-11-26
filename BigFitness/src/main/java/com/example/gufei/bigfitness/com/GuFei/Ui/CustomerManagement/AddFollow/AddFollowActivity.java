package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_REQUEST_SELECT_PHOTO;
import static com.example.gufei.bigfitness.Constants.BASEURL;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TIME_BEGIN_ID;
import static com.example.gufei.bigfitness.Constants.TIME_END_ID;
import static com.example.gufei.bigfitness.Constants.TIME_INTERVAL_ID;
import static com.example.gufei.bigfitness.Constants.TIME_REMIND_ID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.BitmapUtil.Bitmap2StrByBase64;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 客户跟进
 */


public class AddFollowActivity extends BaseActivity<AddFollowActivityPresenter> implements AddFollowActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_complete)
    Button btnRelease;

    @BindView(R.id.text_customer_type)
    TextView textCustomerType;
    @BindView(R.id.text_customer_name)
    TextView textCustomerName;
    @BindView(R.id.text_customer_img)
    ImageView textCustomerImg;
    @BindView(R.id.text_content)
    EditText textContext;
    @BindView(R.id.btn_select_img)
    ImageView btnSelectImg;
    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerId = "";
    private String CustomerSex;
    private String AppointmentId = "";
    private String imgsrc = "";

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_follow_add;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("添加跟进");
        Intent intent = getIntent();
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        textCustomerType.setText(CustomerType);
        textCustomerName.setText(CustomerName);
        if (CustomerSex != null) {
            if (CustomerSex.equals("男")) {
                textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_men);
            } else {
                textCustomerImg.setImageResource(R.mipmap.highseasmembermanage_women);

            }
        }


    }


    @Override
    protected void initData() {
    }


    @Override
    public void showError(String msg) {

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

    @Override
    public void succeed(CodeBean codeBean) {
        s(this, "添加成功");
        btnRelease.setEnabled(true);
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
        resultIntent.putExtras(bundle);
        AddFollowActivity.this.setResult(RESULT_OK, resultIntent);
        this.finish();
    }

    @OnClick({R.id.btn_complete, R.id.btn_select_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:

                String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                if (textContext.getText().toString().equals("") && imgsrc.equals("") ){
                    s(mContext,"请输入跟进内容");
                    break;
                }
                btnRelease.setEnabled(false);
                mPresenter.saveCustomerContact(UserName,
                        UserId,
                        token,
                        ClubId,
                        AppointmentId, textContext.getText().toString(), CustomerId, imgsrc);

                break;
            case R.id.btn_select_img:

                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 5                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。

                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) { // 判断是否成功。
                // 拿到用户选择的图片路径List：
                List<String> pathList = Album.parseResult(data);
                ImageView imageView1 = (ImageView) id(R.id.img1);
                imageView1.setVisibility(View.INVISIBLE);
                ImageView imageView2 = (ImageView) id(R.id.img2);
                imageView2.setVisibility(View.INVISIBLE);
                ImageView imageView3 = (ImageView) id(R.id.img3);
                imageView3.setVisibility(View.INVISIBLE);
                ImageView imageView4 = (ImageView) id(R.id.img4);
                imageView4.setVisibility(View.INVISIBLE);
                ImageView imageView5 = (ImageView) id(R.id.img5);
                imageView5.setVisibility(View.INVISIBLE);


                imgsrc = "";
                for (int i = 0; i < pathList.size(); i++) {

                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                    try {
                        ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
                        imageView.setVisibility(View.VISIBLE);
                        Glide
                                .with(this)
                                .load(pathList.get(i))
                                .fitCenter()
                                .error(R.mipmap.null_img)
                                .into(imageView);


                    } catch (IllegalAccessException e) {

                        e.printStackTrace();

                    } catch (NoSuchFieldException e) {

                        e.printStackTrace();

                    }

                }


            } else if (resultCode == RESULT_CANCELED) { // 用户取消选择。
                // 根据需要提示用户取消了选择。
            }
        }
    }

}

