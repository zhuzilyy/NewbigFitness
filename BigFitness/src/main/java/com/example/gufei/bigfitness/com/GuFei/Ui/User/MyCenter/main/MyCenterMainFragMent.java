package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseFragment;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MyInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.FragMentListening;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo.PersonalInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting.SetingActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.SEXKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.example.gufei.bigfitness.util.SpUtil.get;
import static com.example.gufei.bigfitness.util.ToastUtil.s;


/**
 * Created by Administrator on 2017/8/4.
 * 个人中心
 */

public class MyCenterMainFragMent extends BaseFragment<MyCenterMainFragMentPresenter> implements MyCenterMainFragMentContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.my_center_btn)
    ImageView myCenterBtn;
    @BindView(R.id.seting_btn)
    LinearLayout setingBtn;
    @BindView(R.id.item_txt_name)
    TextView itemTxtName;
    @BindView(R.id.item_txt_sex)
    TextView itemTxtSex;
    @BindView(R.id.item_txt_position)
    TextView itemTxtPosition;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;

    private Context context;

    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_center_main;
    }


    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);

    }

    @Override
    public void onResume() {
        super.onResume();
        updata();

    }


    @Override
    protected void initData() {

        context = this.getActivity();

        tvTitle.setText("我的");

        updata();


    }

    public void  updata(){
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        mPresenter
                .getMyInfo(UserId,token);

    }

    @Override
    public void succeed(MyInfoBean myInfoBean) {
//        itemTxtName.setText((String) get(mContext, USERNAMEKEY, ""));
        itemTxtName.setText(myInfoBean.getResult().getUserName());
        int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        itemTxtPosition.setText(myInfoBean.getResult().getPersonType()+(IsDepartManager==1?"经理":""));
        itemTxtSex.setText(myInfoBean.getResult().getSex());
        displayCircleImage(mContext  ,   myInfoBean.getResult().getHeaderURL(),  myCenterBtn,R.mipmap.privatememberinfor_03);
    }

    @Override
    public void showEmpty() {

    }
    @Override
    public void outLogin() {



    }



    @Override
    public void Loading() {

    }



    @OnClick({R.id.my_center_btn, R.id.seting_btn})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.my_center_btn:
                //进入个人资料
                intent = new Intent(getActivity(), PersonalInfoActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.seting_btn:
//设置页面
                intent = new Intent(getActivity(), SetingActivity.class);
                getActivity().startActivity(intent);

                break;
        }
    }


}
