package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.GroupLesssonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class GroupLesssonActivity extends BaseActivity<GroupLesssonActivityPresenter> implements GroupLesssonActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_state)
    TextView textState;
    @BindView(R.id.text_ncontract)
    TextView textNcontract;
    @BindView(R.id.text_type_class)
    TextView textTypeClass;
    @BindView(R.id.text_name_class)
    TextView textNameClass;
    @BindView(R.id.text_coach_lesson)
    TextView textCoachLesson;
    @BindView(R.id.text_remaining)
    TextView textRemaining;
    @BindView(R.id.text_money)
    TextView textMoney;
    @BindView(R.id.text_time_end)
    TextView textTimeEnd;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;
    @BindView(R.id.details_note)
    TextView detailsNote;
    @BindView(R.id.details_note_text)
    TextView detailsNoteText;
    @BindView(R.id.text_time_start)
    TextView textTimeStart;
    @BindView(R.id.text_time_lesson)
    TextView textTimeLesson;
    @BindView(R.id.buy_time_btn)
    RelativeLayout buyTimeBtn;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;


    private int mId;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_lessoninfo_group;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");


    }


    @Override
    protected void initData() {

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        Intent intent = getIntent();
        mId = intent.getIntExtra(PUT_STR + "Id", 0);
        mPresenter.getGroupLessonInfoById(UserName, UserId, token, ClubId, mId);
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
    public void succeed(GroupLesssonInfoBean groupLesssonInfoBean) {
        GroupLesssonInfoBean.ResultBean resultBean = groupLesssonInfoBean.getResult().get(0);
        textState.setText(resultBean.getStatus());
        textNcontract.setText(resultBean.getBargainNo());
        textTypeClass.setText(resultBean.getLessonType());
        textNameClass.setText(resultBean.getLessonName());
        textTimeStart.setText(resultBean.getStartTime());
        textCoachLesson.setText(resultBean.getLessonteacherName());
        textRemaining.setText(resultBean.getRemainCount());
        textMoney.setText(resultBean.getTotalBuyMoney() + "元");
        textTimeEnd.setText(resultBean.getExpireTime());
        textTimeBuy.setText(resultBean.getBuyTime());
        detailsNoteText.setText(resultBean.getRemark());
        String s = "";
        if (resultBean.getClassTimes().indexOf(",") > -1) {
            String[] split = resultBean.getClassTimes().split(",");
            for (int i = 0; i < split.length; i++) {
                s += split[i] + "\n";

            }
        }
        textTimeLesson.setText(s);
    }


}
