package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;
import com.example.gufei.bigfitness.util.MyImageView.MyImageView;
import com.example.gufei.bigfitness.util.SharedPreferenceUtil;
import com.example.gufei.bigfitness.util.SpUtil;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_REQUEST_SELECT_PHOTO;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.TRAININGPLANKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.BitmapUtil.Bitmap2StrByBase64;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 会员跟进
 */


public class AddMembersFollowActivity extends BaseActivity<AddMembersFollowActivityPresenter> implements AddMembersFollowActivityContract.View {


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
    @BindView(R.id.img1)
    MyImageView img1;
    @BindView(R.id.btn_del_1)
    ImageView btnDel1;
    @BindView(R.id.img2)
    MyImageView img2;
    @BindView(R.id.btn_del_2)
    ImageView btnDel2;
    @BindView(R.id.img3)
    MyImageView img3;
    @BindView(R.id.btn_del_3)
    ImageView btnDel3;
    @BindView(R.id.img4)
    MyImageView img4;
    @BindView(R.id.btn_del_4)
    ImageView btnDel4;
    @BindView(R.id.img5)
    MyImageView img5;
    @BindView(R.id.btn_del_5)
    ImageView btnDel5;
    private String CustomerName = "";
    private String CustomerType = "";
    private String CustomerId = "";
    private String CustomerSex = "";
    private String AppointmentId = "";
    private String memberId = "";
    private String imgsrc = "";
    List<String> pathList = null;

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
        SharedPreferenceUtil.remove(TRAININGPLANKEY);
        SharedPreferenceUtil.clear();
        Intent intent = getIntent();
        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        CustomerId = intent.getStringExtra(PUT_STR + "Id");
        memberId = String.valueOf(intent.getStringExtra(PUT_STR + "memberId"));
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
        pathList = new ArrayList<String>();

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
//        bundle.putString(RESULT_ID, String.valueOf(listBean.getID()));
//        bundle.putString(RESULT_STRING, listBean.getName());
//        bundle.putString(RESULT_TEL, listBean.getTel());
        resultIntent.putExtras(bundle);
        AddMembersFollowActivity.this.setResult(RESULT_OK, resultIntent);
        this.finish();
    }

    @OnClick({R.id.btn_complete, R.id.btn_select_img,R.id.btn_del_1, R.id.btn_del_2, R.id.btn_del_3, R.id.btn_del_4, R.id.btn_del_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:

                String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                String persontype = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
//                if ("会籍".equals(persontype)) {
//                    mPresenter.saveCustomerContact(UserName,
//                            UserId,
//                            token,
//                            ClubId,
//                            AppointmentId, textContext.getText().toString(), CustomerId, imgsrc);
//
//                } else {

                if (textContext.getText().toString().equals("") && imgsrc.equals("")) {
                    s(mContext, "请输入跟进内容");
                    break;
                }
                btnRelease.setEnabled(false);
                mPresenter.insertMemberAppointmentByMemberID(UserName,
                        UserId,
                        token,
                        ClubId,
                        AppointmentId, textContext.getText().toString(), memberId, imgsrc);

//                }


                break;
            case R.id.btn_select_img:
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 5                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_1:
                pathList.remove(0);
                deleteImage();
                break;
            case R.id.btn_del_2:
                pathList.remove(1);
                deleteImage();
                break;
            case R.id.btn_del_3:
                pathList.remove(2);
                deleteImage();
                break;
            case R.id.btn_del_4:
                pathList.remove(3);
                deleteImage();
                break;
            case R.id.btn_del_5:
                pathList.remove(4);
                deleteImage();
                break;

        }
    }

    private void deleteImage() {
        img1.setImageResource(R.mipmap.null_img);
        btnDel1.setVisibility(View.GONE);
        img2.setImageResource(R.mipmap.null_img);
        btnDel2.setVisibility(View.GONE);
        img3.setImageResource(R.mipmap.null_img);
        btnDel3.setVisibility(View.GONE);
        img4.setImageResource(R.mipmap.null_img);
        btnDel4.setVisibility(View.GONE);
        img5.setImageResource(R.mipmap.null_img);
        btnDel5.setVisibility(View.GONE);
        for (int i = 0; i < pathList.size(); i++) {

            imgsrc += Bitmap2StrByBase64(pathList.get(i));
            try {
                ImageView delbtn = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
                delbtn.setVisibility(View.VISIBLE);

                ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
                imageView.setVisibility(View.VISIBLE);
//                        loadIntoUseFitWidth(context,"file://" + pathList.get(i), R.mipmap.null_img,imageView);
                final String imgPath = "file://" + pathList.get(i);

                /*  loadIntoUseFitWidth(context, imgPath, R.mipmap.null_img, imageView);*/

                Glide.with(this)
                        .load(imgPath)
                        .fitCenter()
                        .error(R.mipmap.null_img)
                        .into(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AddMembersFollowActivity.this, ImageActivity.class);
                        intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", imgPath);
                        intent.putExtra("com.example.gufei.bigfitness.com.GuFei.local", true);
                        startActivity(intent);
                    }
                });


            } catch (IllegalAccessException e) {

                e.printStackTrace();

            } catch (NoSuchFieldException e) {

                e.printStackTrace();

            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) { // 判断是否成功。
                // 拿到用户选择的图片路径List：
                pathList.addAll(Album.parseResult(data));
//               pathList = Album.parseResult(data);
                imgsrc = "";
                for (int i = 0; i < pathList.size(); i++) {
                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                    try {
                        ImageView delbtn = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
                        delbtn.setVisibility(View.VISIBLE);

                        ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
                        imageView.setVisibility(View.VISIBLE);
//                        loadIntoUseFitWidth(context,"file://" + pathList.get(i), R.mipmap.null_img,imageView);
                        final String imgPath = "file://" + pathList.get(i);

                        /*  loadIntoUseFitWidth(context, imgPath, R.mipmap.null_img, imageView);*/

                        Glide.with(this)
                                .load(imgPath)
                                .fitCenter()
                                .error(R.mipmap.null_img)
                                .into(imageView);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AddMembersFollowActivity.this, ImageActivity.class);
                                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.url", imgPath);
                                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.local", true);
                                startActivity(intent);
                            }
                        });


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}

