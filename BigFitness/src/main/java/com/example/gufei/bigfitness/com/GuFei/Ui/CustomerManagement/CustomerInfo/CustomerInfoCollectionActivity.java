package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_SEX;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class CustomerInfoCollectionActivity extends BaseActivity<CustomerInfoCollectionPresenter> implements SpinnerPopContract, CustomerInfoCollectionContract.View {


    @BindView(R.id.user_name_text)
    TextView userNameText;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_sxy)
    TextView userSxy;
    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.collection_user_tel_text)
    TextView collectionUserTelText;
    @BindView(R.id.collection_user_tel)
    EditText collectionUserTel;
    @BindView(R.id.references_text)
    TextView referencesText;
    @BindView(R.id.references)
    TextView references;
    @BindView(R.id.customer_source_text)
    TextView customerSourceText;
    @BindView(R.id.customer_source)
    TextView customerSource;
    @BindView(R.id.customer_will_text)
    TextView customerWillText;
    @BindView(R.id.customer_will)
    TextView customerWill;
    @BindView(R.id.customer_identification)
    TextView customerIdentification;
    @BindView(R.id.customer_identification_text)
    TextView customerIdentificationText;
    @BindView(R.id.collectors_text)
    TextView collectorsText;
    @BindView(R.id.collectors)
    TextView collectors;
    @BindView(R.id.membership_consultant_text)
    TextView membershipConsultantText;
    @BindView(R.id.membership_consultant)
    TextView membershipConsultant;
    @BindView(R.id.card_type_text)
    TextView cardTypeText;
    @BindView(R.id.card_type)
    TextView cardType;
    @BindView(R.id.prepare_money_text)
    TextView prepareMoneyText;
    @BindView(R.id.prepare_money)
    TextView prepareMoney;
    @BindView(R.id.note_text)
    TextView noteText;
    @BindView(R.id.note_content)
    EditText noteContent;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;

    @BindView(R.id.user_sxy_img)
    ImageView userSxyImg;
    @BindView(R.id.customer_will_img)
    ImageView customerWillImg;
    @BindView(R.id.user_name_img)
    ImageView userNameImg;
    @BindView(R.id.user_sxy_btn)
    RelativeLayout userSxyBtn;
    @BindView(R.id.references_btn)
    RelativeLayout referencesBtn;
    @BindView(R.id.user_source_btn)
    RelativeLayout userSourceBtn;
    @BindView(R.id.customer_identification_btn)
    RelativeLayout customerIdentificationBtn;
    @BindView(R.id.customer_will_btn)
    RelativeLayout customerWillBtn;
    @BindView(R.id.collection_user_tel_img)
    ImageView collectionUserTelImg;
    @BindView(R.id.references_img)
    ImageView referencesImg;
    @BindView(R.id.user_source_img)
    ImageView userSourceImg;
    @BindView(R.id.customer_identification_img)
    ImageView customerIdentificationImg;


    private List<String> mDatas;

    private int ItemSelected = 0;
    private SpinnerPopupWindow s;


    String mId = "";
    String mName = "";
    String mUserName = "";
    String mUserSex = "";
    String oldTel = "";
    String mTel = "";
    String CustomerId = "";
    String LabelId = "";
    String IntentId = "";
    String IntroduceMemberId = "";
    String SourceId = "";

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_customer_info_collection;

    }

    /**
     *
     */
    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("客户信息");
        btnComplete.setText("修改");
        Intent intent = getIntent();
        mUserName = intent.getStringExtra(PUT_STR + "Name");
        mUserSex = intent.getStringExtra(PUT_STR + "Sex");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        String CustomerId = intent.getStringExtra(PUT_STR + "CustomerId");
        mPresenter.getCustomerInfoById(UserId, token, ClubId, UserName, CustomerId);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {
                mId = bundle.getString(RESULT_ID);
                mName = bundle.getString(RESULT_STRING);
                mTel = bundle.getString(RESULT_TEL);

//                customerWill.setText(mName);
            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }

            if (requestCode == CUSTOMERINTRODUCERID) {
                //介绍人
                IntroduceMemberId = mId;
                references.setText(mName);
            }
            if (requestCode == CUSTOMERSOURCEID) {
                //来源
                SourceId = mId;
                customerSource.setText(mName);
            }
            if (requestCode == MEMBERINTENTID) {
                //会员意向
                IntentId = mId;
                customerWill.setText(mName);
            }
            if (requestCode == CUSTOMERTAGID) {
                //会员意向
                LabelId = mId;
                customerIdentification.setText(mName);
            }


        }


    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void Success(CustomerInfoBean customerInfoBean) {

        userName.setText(customerInfoBean.getResult().getCustomerName());

        collectionUserTel.setText(customerInfoBean.getResult().getTel());
        oldTel = customerInfoBean.getResult().getTel();
        int sex = customerInfoBean.getResult().getSex();

        userSxy.setText(sex == 1 ? "男" : "女");
        mUserName = userName.getText().toString();
        mUserSex = userSxy.getText().toString();

        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);

//        bundle.putString(RESULT_ID, String.valueOf(listBean.getID()));
        bundle.putString(RESULT_STRING, mUserName);
        bundle.putString(RESULT_SEX, mUserSex);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);


        references.setText(customerInfoBean.getResult().getIntroduceMemberName());
        customerSource.setText(customerInfoBean.getResult().getSourceName());
        customerWill.setText(customerInfoBean.getResult().getIntentName());
        customerIdentification.setText(customerInfoBean.getResult().getLabelName());
        collectors.setText(customerInfoBean.getResult().getCreateUserName());
        membershipConsultant.setText(customerInfoBean.getResult().getOwnManagerName());
        cardType.setText(customerInfoBean.getResult().getMemberCardTypeName());
        prepareMoney.setText(customerInfoBean.getResult().getPreSaleMoney());
        noteContent.setText(customerInfoBean.getResult().getRemark());
        CustomerId = String.valueOf(customerInfoBean.getResult().getCustomerId());
        mId = String.valueOf(customerInfoBean.getResult().getIntentId());

    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
//         this.finish();


    }

    @Override
    public void EditSuccess(CodeBean codeBean) {
        mUserName= userName.getText().toString();

        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);

//        bundle.putString(RESULT_ID, String.valueOf(listBean.getID()));
        bundle.putString(RESULT_STRING, mUserName);
        bundle.putString(RESULT_SEX, mUserSex);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);

        s(this, "修改成功");
        finish();
    }

    public  void  showImgBtn(int show){


        userSxyImg.setVisibility(show);
        userNameImg.setVisibility(show);
        customerWillImg.setVisibility(show);
        collectionUserTelImg.setVisibility(show);
        referencesImg.setVisibility(show);
        userSourceImg.setVisibility(show);
        customerIdentificationImg.setVisibility(show);

    }



    @OnClick({R.id.user_sxy_btn, R.id.customer_will_btn, R.id.btn_complete, R.id.references_btn, R.id.user_source_btn, R.id.customer_identification_btn})
    public void onViewClicked(View view) {
        final Intent intent = new Intent(CustomerInfoCollectionActivity.this, FilterListActivity.class);
        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
        mDatas = new ArrayList<String>();
        switch (view.getId()) {
            case R.id.user_sxy_btn:
                if (!btnComplete.getText().equals("修改")) {
                    mDatas.add("男");
                    mDatas.add("女");
                    s = new SpinnerPopupWindow.Builder(CustomerInfoCollectionActivity.this)
                            .setmLayoutManager(null)
                            .setmAdapter(new SpinnerAdapter())
                            .setOutsideTouchable(true)
                            .setTitleText("性别")

                            .setmSpinnerPopContract(this)
                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT).build();
                    s.setTitleshow(true);
                    s.showPopCenter();

//                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//                    @Override
//                    public void onDismiss() {
//                        backgroundAlpha(1f);
//                    }
//                });
                    backgroundAlpha(0.5f);
                }
//                // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
//                // 我觉得这里是API的一个bug
//                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
////                PopupView(view,R.id.user_sxy,"性别");
                break;
            case R.id.customer_will_btn:

                if (!btnComplete.getText().equals("修改")) {
                    //意向
                    intent.putExtra(mStrType, MEMBERINTENTID);
                    startActivityForResult(intent, MEMBERINTENTID);//使用时需定义变量requestCode
                }
                break;
            case R.id.btn_complete:
                if (btnComplete.getText().toString().equals("保存")) {
                    int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);
                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                    int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
                    String name = (String) SpUtil.get(mContext, USERNAMEKEY, "");
                    mPresenter.EditCustomer(userid,
                            token,
                            clubid,
                            name,
                            userName.getText().toString(), IntentId, IntroduceMemberId, LabelId, String.valueOf(userid), noteContent.getText().toString(),
                            userSxy.getText().toString().equals("女") ? "0" : "1", SourceId,
                            collectionUserTel.getText().toString(), null, null, CustomerId);
                    userSxyImg.setVisibility(View.INVISIBLE);
                    customerWillImg.setVisibility(View.INVISIBLE);
                    btnComplete.setText("修改");
                    showImgBtn(View.INVISIBLE);
                } else {
                    userName.setEnabled(true);
                    collectionUserTel.setEnabled(true);
                    showImgBtn(View.VISIBLE);
                    btnComplete.setText("保存");
                }
                break;


            case R.id.references_btn:
                if (!btnComplete.getText().equals("修改")) {
                    //介绍人
                    intent.putExtra(mStrType, CUSTOMERINTRODUCERID);
                    startActivityForResult(intent, CUSTOMERINTRODUCERID);//使用时需定义变量requestCode
                }
                break;
            case R.id.user_source_btn:
                if (!btnComplete.getText().equals("修改")) {
                    //来源
                    intent.putExtra(mStrType, CUSTOMERSOURCEID);
                    startActivityForResult(intent, CUSTOMERSOURCEID);//使用时需定义变量requestCode
                }
                break;

            case R.id.customer_identification_btn:
                if (!btnComplete.getText().equals("修改")) {
                    //标签
                    intent.putExtra(mStrType, CUSTOMERTAGID);
                    startActivityForResult(intent, CUSTOMERTAGID);//使用时需定义变量requestCode
                }
                break;

        }
    }

    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    CustomerInfoCollectionActivity.this).inflate(R.layout.item_edit_pop, parent,
                    false));

            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.tv.setText(mDatas.get(position));

            holder.tv.setTag(position);
            if (position == ItemSelected) {
                holder.selected_btn.setVisibility(View.VISIBLE);
            } else {
                holder.selected_btn.setVisibility(View.INVISIBLE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemSelected = position;
                    userSxy.setText(mDatas.get(position));
                    notifyDataSetChanged();
                    s.dismissPopWindow();

                }
            });


        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            ImageView selected_btn;
//            ImageView downBtn;

            public MyViewHolder(final View view) {
                super(view);

                tv = (TextView) view.findViewById(R.id.content_text);

                selected_btn = (ImageView) view.findViewById(R.id.selected_btn);
//                downBtn = (ImageView) view.findViewById(R.id.down_btn);


            }
        }
    }


}