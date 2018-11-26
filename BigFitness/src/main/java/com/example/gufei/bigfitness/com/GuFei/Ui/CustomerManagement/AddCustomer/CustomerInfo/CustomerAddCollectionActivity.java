package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo;

import android.annotation.SuppressLint;
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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SexSpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.component.PopupWindowsCallbackInterface;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.IDENTIFICATIONID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.SALEMEMBERCARDTYPEID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.MobileUtil.isMobile;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/*
*
* 客户采集
*
* */
public class CustomerAddCollectionActivity extends BaseActivity<CustomerAddCollectionActivityPresenter> implements SpinnerPopContract, CustomerAddCollectionActivityContract.View, PopupWindowsCallbackInterface {


    //
//    @BindView(R.id.main_title)
//    TextView mainTitle;
//    @BindView(R.id.user_name_text)
//    TextView userNameText;
    @BindView(R.id.text_user_name)
    EditText EdituserName;
    @BindView(R.id.user_sxy_btn)
    RelativeLayout userSxyBtn;

    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.collection_user_tel_text)
    TextView collectionUserTelText;
    @BindView(R.id.query_tel_btn)
    TextView queryTelBtn;
    @BindView(R.id.collection_user_tel)
    TextView collectionUserTel;
    @BindView(R.id.references_btn)
    RelativeLayout referencesBtn;
    @BindView(R.id.references_text)
    TextView referencesText;
    @BindView(R.id.references)
    TextView references;
    @BindView(R.id.user_source_btn)
    RelativeLayout userSourceBtn;
    @BindView(R.id.customer_source_text)
    TextView customerSourceText;
    @BindView(R.id.customer_source)
    TextView customerSource;
    @BindView(R.id.customer_will_btn)
    RelativeLayout customerWillBtn;
    @BindView(R.id.customer_will_text)
    TextView customerWillText;
    @BindView(R.id.customer_will)
    TextView customerWill;
    @BindView(R.id.customer_identification_btn)
    RelativeLayout customerIdentificationBtn;
    @BindView(R.id.customer_identification_text)
    TextView customerIdentificationText;
    @BindView(R.id.customer_identification)
    TextView customerIdentification;
    @BindView(R.id.collectors_btn)
    RelativeLayout collectorsBtn;
    @BindView(R.id.collectors_text)
    TextView collectorsText;
    @BindView(R.id.collectors)
    TextView collectors;
    @BindView(R.id.membership_consultant_text)
    TextView membershipConsultantText;
    @BindView(R.id.membership_consultant)
    TextView membershipConsultant;
    @BindView(R.id.membership_consultant_btn)
    RelativeLayout membershipConsultantBtn;
    @BindView(R.id.card_type_btn)
    RelativeLayout cardTypeBtn;
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
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    PostCustomerListBean mPostCustomerListBean;
    @BindView(R.id.btn_sex_men)
    RadioButton btnSexMen;
    @BindView(R.id.btn_sex_women)
    RadioButton btnSexWomen;
    @BindView(R.id.star_tel)
    TextView starTel;
    @BindView(R.id.star1)
    TextView star1;
    @BindView(R.id.star2)
    TextView star2;
    @BindView(R.id.star_own)
    TextView starOwn;

    private List<String> mDatas;

    private int ItemSelected = 0;
    private SexSpinnerPopupWindow s;
    private String SexF="99";


    private boolean Tel = false;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_customer_add_collection;

    }

    @Override
    public void SuccessTel(CodeBean codeBean) {
        s(this, "无重复号码!");
        Tel = true;
    }

    @Override
    protected void initView() {
//
        mPostCustomerListBean = new PostCustomerListBean();

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");

        tvTitle.setText("客户信息采集");

        btnComplete.setText("保存");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        collectors.setText(UserName);
        membershipConsultant.setText(UserName);
        //采集人
        mPostCustomerListBean.setCreateUserId(String.valueOf(UserId));
        //顾问
        mPostCustomerListBean.setOwnManagerId(String.valueOf(UserId));


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
    @OnClick({R.id.btn_sex_men, R.id.btn_sex_women,R.id.btn_complete, R.id.query_tel_btn, R.id.references_btn, R.id.user_source_btn, R.id.customer_will_btn, R.id.customer_identification_btn, R.id.collectors_btn, R.id.membership_consultant_btn, R.id.card_type_btn})
    public void onClick(View view) {

        mDatas = new ArrayList<String>();
        final Intent intent = new Intent(CustomerAddCollectionActivity.this, FilterListActivity.class);
        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";

        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

        String name = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        switch (view.getId()) {

            case R.id.btn_complete:
                //提交信息

                if (EdituserName.getText().toString().equals("")) {

                    s(mContext, "请选择填写客户名称");
                    return;
                }
                if (SexF.equals("99")) {
                    s(mContext, "请选择客户性别");
                    return;
                }
                if (!isMobile(collectionUserTel.getText().toString().toString())) {
                    s(mContext, "请选择填写正确电话号");
                    return;
                }

                if (mPostCustomerListBean.getIntentId().toString().equals("")) {
                    s(mContext, "请选择客户意向");
                    return;
                }
                if (mPostCustomerListBean.getLabelId().toString().equals("")) {
                    s(mContext, "请选择客户标签");
                    return;
                }
                if (mPostCustomerListBean.getOwnManagerId().toString().equals("")) {
                    s(mContext, "请选择会籍顾问");
                    return;
                }

//                mPostCustomerListBean.setOwnManagerId//会籍顾问
//                mPostCustomerListBean.setIntroduceMemberId(mId);//介绍人


                mPresenter.addCustomer(userid, token, clubid, name,
                        EdituserName.getText().toString().trim(),
                        mPostCustomerListBean.getIntentId(),
                        mPostCustomerListBean.getIntroduceMemberId(),
                        mPostCustomerListBean.getLabelId(),
                        mPostCustomerListBean.getOwnManagerId(),
                        noteContent.getText().toString(),
                        SexF,
                        mPostCustomerListBean.getSourceId(),
                        collectionUserTel.getText().toString(),
                        mPostCustomerListBean.getSalemembercardtypeid(),
                        prepareMoney.getText().toString()

                );


                break;

            case R.id.query_tel_btn:
                mPresenter.getCustomerCheckByTel(userid, token, clubid, collectionUserTel.getText().toString());
                break;
            case R.id.references_btn:
                //介绍人
                intent.putExtra(mStrType, CUSTOMERINTRODUCERID);
                startActivityForResult(intent, CUSTOMERINTRODUCERID);//使用时需定义变量requestCode

                break;
            case R.id.user_source_btn:
                //来源
                intent.putExtra(mStrType, CUSTOMERSOURCEID);
                startActivityForResult(intent, CUSTOMERSOURCEID);//使用时需定义变量requestCode
                break;
            case R.id.customer_will_btn:

                //意向
                intent.putExtra(mStrType, MEMBERINTENTID);

                startActivityForResult(intent, MEMBERINTENTID);//使用时需定义变量requestCode

                break;
            case R.id.customer_identification_btn:
                //标识
                intent.putExtra(mStrType, CUSTOMERTAGID);
                startActivityForResult(intent, CUSTOMERTAGID);//使用时需定义变量requestCode
                break;
            case R.id.collectors_btn:
                //采集人员
//                intent.putExtra(mStrType, CREATEUSERLISTID);
//
//                startActivityForResult(intent, CREATEUSERLISTID);//使用时需定义变量requestCode


                break;
            case R.id.membership_consultant_btn:


                //顾问
                intent.putExtra(mStrType, MANGERLISTID);

                startActivityForResult(intent, MANGERLISTID);//使用时需定义变量requestCode

                break;
            case R.id.card_type_btn:
                //会员卡类型
                intent.putExtra(mStrType, SALEMEMBERCARDTYPEID);
                startActivityForResult(intent, SALEMEMBERCARDTYPEID);//使用时需定义变量requestCode
                break;
            case R.id.btn_sex_men:
                SexF="1";
                btnSexMen.setChecked(true);
                btnSexMen.setTextColor(this.getResources().getColor(R.color.selected_color_blue));
                btnSexWomen.setTextColor(this.getResources().getColor(R.color.selected_color_non));
                btnSexWomen.setChecked(false);
                break;
            case R.id.btn_sex_women:
                SexF="0";
                btnSexWomen.setChecked(true);
                btnSexMen.setChecked(false);
                btnSexWomen.setTextColor(this.getResources().getColor(R.color.selected_color));
                btnSexMen .setTextColor(this.getResources().getColor(R.color.selected_color_non));
                break;

        }
    }

    @Override
    public void showCallback(String result) {
        backgroundAlpha(1f);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
        super.onActivityResult(requestCode, resultCode, data);
//            Bundle bundle = data.getExtras();
////            gameView.backString = bundle.getString("aaa");
//            Toast.makeText(this, bundle.getString("aaa"), Toast.LENGTH_SHORT).show();


        String mId = "";
        String mName = "";
        String mTel = "";


        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }

            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {

                mId = bundle.getString(RESULT_ID);

                mName = bundle.getString(RESULT_STRING);

                mTel = bundle.getString(RESULT_TEL);


            }
//            else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//            }
        }

        if (requestCode == CUSTOMERTAGID) {

            mPostCustomerListBean.setLabelId(mId);

            mPostCustomerListBean.setLabelName(mName);

            customerIdentification.setText(mName);

        }

        if (requestCode == MANGERLISTID) {

            //会籍顾问

            if (!mName.equals("")) {

                mPostCustomerListBean.setOwnManagerId(mId);

                mPostCustomerListBean.setOwnManagerName(mName);

                membershipConsultant.setText(mName);
            }

        }
        if (requestCode == MEMBERINTENTID) {

            //意向

            mPostCustomerListBean.setIntentId(mId);

            mPostCustomerListBean.setIntentName(mName);

            customerWill.setText(mName);

        }
        if (requestCode == CUSTOMERSOURCEID) {

            //来源

            mPostCustomerListBean.setSourceId(mId);

            mPostCustomerListBean.setSourceName(mName);

            customerSource.setText(mName);

        }

        if (requestCode == CREATEUSERLISTID) {

            //采集人

            mPostCustomerListBean.setCreateUserId(mId);

            mPostCustomerListBean.setCreateUserName(mName);

            collectors.setText(mName);

        }
        if (requestCode == CUSTOMERINTRODUCERID) {

            if (mName.equals("无")) {
                //介绍人
                mPostCustomerListBean.setIntroduceMemberId("");
                mPostCustomerListBean.setIntroduceMemberName("");
                references.setText("");
            } else {
                //介绍人
                mPostCustomerListBean.setIntroduceMemberId(mId);
                mPostCustomerListBean.setIntroduceMemberName(mName);
                references.setText(mName);
            }


        }
        if (requestCode == SALEMEMBERCARDTYPEID) {


            //卡类型
            mPostCustomerListBean.setSalemembercardtypeid(mId);

            mPostCustomerListBean.setSalemembercardtypeName(mName);

            cardType.setText(mName);

        }
        if (requestCode == CUSTOMERSOURCEID) {

            mPostCustomerListBean.setSourceId(mId);

            mPostCustomerListBean.setSourceName(mName);
            customerSource.setText(mName);

        }
        if (requestCode == CUSTOMERINTENTID) {

            mPostCustomerListBean.setIntentId(mId);

            mPostCustomerListBean.setIntentName(mName);

        }
        if (requestCode == POSTEACHERLISTID) {

            mPostCustomerListBean.setPOSTeacherId(mId);

            mPostCustomerListBean.setPOSTeacherName(mName);

        }
        if (requestCode == CONTACTTEACHERLISTID) {

            mPostCustomerListBean.setOwnTeacherId(mId);

            mPostCustomerListBean.setOwnTeacherName(mName);

        }

        if (requestCode == IDENTIFICATIONID) {

//标识
            mPostCustomerListBean.setIdentificationId(mId);

            mPostCustomerListBean.setIdentificationName(mName);


//                mPostCustomerListBean.s(mId);
//
//                mPostCustomerListBean.setOwnTeacherName(mName);

        }


    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void Success(CodeBean codeBean) {

        s(this, "成功!");
        finish();


    }

//
//
//    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
//        @Override
//        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
//                    CustomerAddCollectionActivity.this).inflate(R.layout.item_edit_pop, parent,
//                    false));
//
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(final MyViewHolder holder, final int position) {
//
//            holder.tv.setText(mDatas.get(position));
//
//            holder.tv.setTag(position);
//
//
//            if (position == ItemSelected) {
//
//                holder.selected_btn.setVisibility(View.VISIBLE);
//            } else {
//                holder.selected_btn.setVisibility(View.INVISIBLE);
//            }
//
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    ItemSelected = position;
////                    userSxy.setText(mDatas.get(position));
//
//                    notifyDataSetChanged();
//                    s.dismissPopWindow();
//
//                }
//            });
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return mDatas.size();
//        }
//
//        class MyViewHolder extends RecyclerView.ViewHolder {
//
//            TextView tv;
//            ImageView selected_btn;
////            ImageView downBtn;
//
//            public MyViewHolder(final View view) {
//                super(view);
//
//                tv = (TextView) view.findViewById(R.id.content_text);
//
//                selected_btn = (ImageView) view.findViewById(R.id.selected_btn);
////                downBtn = (ImageView) view.findViewById(R.id.down_btn);
//
//
//            }
//        }
//    }


}
