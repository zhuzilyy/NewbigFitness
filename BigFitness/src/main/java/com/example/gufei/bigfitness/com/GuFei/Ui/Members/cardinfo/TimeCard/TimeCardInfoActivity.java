package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class TimeCardInfoActivity extends BaseActivity<TimeCardInfoActivityPresenter> implements TimeCardInfoActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_state)
    TextView textState;
    @BindView(R.id.text_ncontract)
    TextView textNcontract;
    @BindView(R.id.text_no_card)
    TextView textNoCard;
    @BindView(R.id.text_type)
    TextView textType;
    @BindView(R.id.text_remaining)
    TextView textRemaining;
    @BindView(R.id.text_Paid_in_amount)
    TextView textPaidInAmount;
    @BindView(R.id.end_time_text)
    TextView endTimeText;
    @BindView(R.id.start_time_text)
    TextView startTimeText;
    @BindView(R.id.buy_time_text)
    TextView buyTimeText;
    @BindView(R.id.ice_text)
    TextView iceText;
    @BindView(R.id.details_note_text)
    TextView detailsNoteText;
    @BindView(R.id.text_one_card_multi)
    TextView textOneCardMulti;
    @BindView(R.id.text_operator)
    TextView textOperator;
    private int cardId;

//    **


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_card_time_details_documents_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");

        // 获取会员卡ID
        Intent intent = getIntent();
        cardId = intent.getIntExtra("cardinfo", 0);

        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        mPresenter.getCardInfo(UserId, UserName,
                token,
                ClubId,
                cardId);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void succeed(CardInfoBean cardInfoBean) {
        CardInfoBean.ResultBean resultBean = cardInfoBean.getResult();
        // TODO: 2017/6/21  页面各种附值

        textState.setText(String.valueOf(resultBean.getSTATUS()));
        textNcontract.setText(String.valueOf(resultBean.getBargainNo()));
        textNoCard.setText(String.valueOf(String.valueOf(resultBean.getMemberCardNo())));
        textType.setText(String.valueOf(resultBean.getConsumeType()));
        textRemaining.setText(String.valueOf(resultBean.getCardBalance()));
        textPaidInAmount.setText(String.valueOf(resultBean.getBuyMoney())+"元");
        endTimeText.setText(String.valueOf(resultBean.getExpireTime()));
        buyTimeText.setText(String.valueOf(resultBean.getBuyTime()));

        detailsNoteText.setText(String.valueOf(resultBean.getBuyRemark()));
        textOneCardMulti.setText(String.valueOf(resultBean.getMemberNameList()));
        textOperator.setText(String.valueOf(resultBean.getCreateUserName()));

        iceText.setText(String.valueOf(resultBean .getRemainLockedCount())+"次");
        startTimeText.setText(String.valueOf(resultBean.getUseTime() ));
//        tvTitle.setText(String.valueOf(resultBean ));
//        textState.setText(String.valueOf(resultBean ));
//        textNcontract.setText(String.valueOf(resultBean ));
//        textNoCard.setText(String.valueOf(resultBean ));
//        textType.setText(String.valueOf(resultBean ));
//        textRemaining.setText(String.valueOf(resultBean ));
//        textPaidInAmount.setText(String.valueOf(resultBean ));
//        endTimeText.setText(String.valueOf(resultBean ));
//        startTimeText.setText(String.valueOf(resultBean ));
//        buyTimeText.setText(String.valueOf(resultBean ));
//
//        detailsNoteText.setText(String.valueOf(resultBean ));
//        textOneCardMulti.setText(String.valueOf(resultBean ));
//        textOperator.setText(String.valueOf(resultBean ));




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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
