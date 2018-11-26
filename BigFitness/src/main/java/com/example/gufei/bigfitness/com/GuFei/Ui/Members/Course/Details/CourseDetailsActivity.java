package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class CourseDetailsActivity extends BaseActivity<CourseDetailsActivityPresenter> implements CourseDetailsActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_state)
    TextView textState;
    @BindView(R.id.appointment_type_img)
    ImageView appointmentTypeImg;
    @BindView(R.id.text_ncontract)
    TextView textNcontract;
    @BindView(R.id.appointment_type_btn)
    RelativeLayout appointmentTypeBtn;
    @BindView(R.id.course_type_img)
    ImageView courseTypeImg;
    @BindView(R.id.text_no_wardrobe)
    TextView textNoWardrobe;
    @BindView(R.id.course_type_btn)
    RelativeLayout courseTypeBtn;
    @BindView(R.id.begin_vailable_img)
    ImageView beginVailableImg;
    @BindView(R.id.text_vailable)
    TextView textVailable;
    @BindView(R.id.begin_vailable_btn)
    RelativeLayout beginVailableBtn;
    @BindView(R.id.begin_time_img)
    ImageView beginTimeImg;
    @BindView(R.id.begin_time_text)
    TextView beginTimeText;
    @BindView(R.id.begin_time_btn)
    RelativeLayout beginTimeBtn;
    @BindView(R.id.end_time_img)
    ImageView endTimeImg;
    @BindView(R.id.end_time_text)
    TextView endTimeText;
    @BindView(R.id.end_time_btn)
    RelativeLayout endTimeBtn;
    @BindView(R.id.remind_time_img)
    ImageView remindTimeImg;
    @BindView(R.id.text_Paid_in_amount)
    TextView textPaidInAmount;
    @BindView(R.id.remind_time_btn)
    RelativeLayout remindTimeBtn;
    @BindView(R.id.interval_time_img)
    ImageView intervalTimeImg;
    @BindView(R.id.text_wardrobe_deposit)
    TextView textWardrobeDeposit;
    @BindView(R.id.interval_time_btn)
    RelativeLayout intervalTimeBtn;
    @BindView(R.id.buy_time_img)
    ImageView buyTimeImg;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;
    @BindView(R.id.buy_time_btn)
    RelativeLayout buyTimeBtn;
    @BindView(R.id.details_note_text)
    TextView detailsNoteText;
    @BindView(R.id.operator_img)
    ImageView operatorImg;
    @BindView(R.id.text_operator)
    TextView textOperator;
    @BindView(R.id.operator_btn)
    RelativeLayout operatorBtn;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;
    private String mId;

    private int WardrobeId;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_course_details;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");


    }


    @Override
    protected void initData() {

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        Intent intent = getIntent();

        mId = intent.getStringExtra(PUT_STR + "Id");

        WardrobeId = intent.getIntExtra(PUT_STR + "WardrobeId", 0);

        mPresenter.getMemberWardrobeInfo(UserId, token, ClubId, WardrobeId, mId);
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
    public void succeed(MemberWardrobeInfoBean memberWardrobeInfoBean) {


        textState.setText(memberWardrobeInfoBean.getResult().getStatus());

        textNcontract.setText(memberWardrobeInfoBean.getResult().getBargainNo());

        textNoWardrobe.setText(memberWardrobeInfoBean.getResult().getWardrobeNo());

        textVailable.setText(memberWardrobeInfoBean.getResult().getWardrobeBalance());

        beginTimeText.setText(memberWardrobeInfoBean.getResult().getUseTime());

        endTimeText.setText(memberWardrobeInfoBean.getResult().getExpireTime());

        textPaidInAmount.setText(memberWardrobeInfoBean.getResult().getTotalBuyMoney());

        textWardrobeDeposit.setText(memberWardrobeInfoBean.getResult().getDeposit());

        textTimeBuy.setText(memberWardrobeInfoBean.getResult().getBuyTime());

        detailsNoteText.setText(memberWardrobeInfoBean.getResult().getBuyRemark());

        textOperator.setText(memberWardrobeInfoBean.getResult().getUserName());


    }



}

