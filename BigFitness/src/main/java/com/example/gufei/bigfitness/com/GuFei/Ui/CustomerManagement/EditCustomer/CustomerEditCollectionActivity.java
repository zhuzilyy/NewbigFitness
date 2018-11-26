package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer;

import android.app.Activity;
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
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
import static com.example.gufei.bigfitness.Constants.PERSONTYPEID;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class CustomerEditCollectionActivity extends BaseActivity<CustomerEditCollectionActivityPresenter> implements SpinnerPopContract, CustomerEditCollectionActivityContract.View {


    //
//    @BindView(R.id.main_title)
//    TextView mainTitle;
    @BindView(R.id.user_name_text)
    TextView userNameText;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_sxy_btn)
    ImageView userSxyBtn;
    @BindView(R.id.user_sxy)
    TextView userSxy;
    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.collection_user_tel_text)
    TextView collectionUserTelText;
    @BindView(R.id.query_tel_btn)
    TextView queryTelBtn;
    @BindView(R.id.collection_user_tel)
    TextView collectionUserTel;
    @BindView(R.id.references_btn)
    ImageView referencesBtn;
    @BindView(R.id.references_text)
    TextView referencesText;
    @BindView(R.id.references)
    TextView references;
    @BindView(R.id.user_source_btn)
    ImageView userSourceBtn;
    @BindView(R.id.customer_source_text)
    TextView customerSourceText;
    @BindView(R.id.customer_source)
    TextView customerSource;
    @BindView(R.id.customer_will_btn)
    ImageView customerWillBtn;
    @BindView(R.id.customer_will_text)
    TextView customerWillText;
    @BindView(R.id.customer_will)
    TextView customerWill;
    @BindView(R.id.customer_identification_btn)
    ImageView customerIdentificationBtn;
    @BindView(R.id.customer_identification_text)
    TextView customerIdentificationText;
    @BindView(R.id.customer_identification)
    TextView customerIdentification;
    @BindView(R.id.collectors_btn)
    ImageView collectorsBtn;
    @BindView(R.id.collectors_text)
    TextView collectorsText;
    @BindView(R.id.collectors)
    TextView collectors;
    @BindView(R.id.membership_consultant_text)
    TextView membershipConsultantText;
    @BindView(R.id.membership_consultant)
    TextView membershipConsultant;
    @BindView(R.id.membership_consultant_btn)
    ImageView membershipConsultantBtn;
    @BindView(R.id.card_type_btn)
    ImageView cardTypeBtn;
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
    private List<String> mDatas;

    private int ItemSelected = 0;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_customer_add_collection;

    }

    @Override
    protected void initView() {

        mPostCustomerListBean = new PostCustomerListBean();
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("客户信息采集");
        btnComplete.setText("保存");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        Intent intent = getIntent();
        String CustomerId = intent.getStringExtra(PUT_STR);
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


    @OnClick({R.id.btn_complete, R.id.user_sxy_btn, R.id.query_tel_btn, R.id.references_btn, R.id.user_source_btn, R.id.customer_will_btn, R.id.customer_identification_btn, R.id.collectors_btn, R.id.membership_consultant_btn, R.id.card_type_btn})
    public void onClick(View view) {

        mDatas = new ArrayList<String>();


        final Intent intent = new Intent(CustomerEditCollectionActivity.this, FilterListActivity.class);

        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";

        switch (view.getId()) {
            case R.id.btn_complete:
                //提交信息

                int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);

                String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                int clubid = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

                String name = (String) SpUtil.get(mContext, USERIDKEY, 0);
//
//                mPresenter.addCustomer(userid,token,clubid,name,
//                        userName.getText().toString()  ,
//                        userSxy.getText().toString()  ,
//                        collectionUserTel.getText().toString()  ,
//                        references.getText().toString()  ,
//                        customerSource.getText().toString()  ,
//                        customerWill.getText().toString()  ,
//                        customerIdentification.getText().toString()  ,
//                        collectors.getText().toString()  ,
//                        membershipConsultant.getText().toString()  ,
//                        cardType.getText().toString()  ,
//                        prepareMoney.getText().toString()  ,
//                        noteContent.getText().toString()  ,
//                        tvTitle.getText().toString()
//                );


                break;
//
            case R.id.user_sxy_btn:

//                Intent intent = new Intent();
//                intent.setClass(CustomerAddCollectionActivity.this, QueryActivity.class);
//                Bundle bundle = new Bundle();
//                intent.putExtras(bundle);//将Bundle添加到Intent,也可以在Bundle中添加相应数据传递给下个页面,例如：bundle.putString("abc", "bbb");
//                startActivityForResult(intent, 0);// 跳转并要求返回值，0代表请求值(可以随便写)

                mDatas.add("男");
                mDatas.add("女");

//                mDatas.add("女");
//                mDatas.add("男");
//


                SpinnerPopupWindow s = new SpinnerPopupWindow.Builder(CustomerEditCollectionActivity.this)
                        .setmLayoutManager(null)
                        .setmAdapter(new CustomerEditCollectionActivity.SpinnerAdapter())
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
//                // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
//                // 我觉得这里是API的一个bug
//                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
////                PopupView(view,R.id.user_sxy,"性别");

                break;
            case R.id.query_tel_btn:
                break;
            case R.id.references_btn:
//介绍人
                intent.putExtra(mStrType, PERSONTYPEID);

                startActivityForResult(intent, PERSONTYPEID);//使用时需定义变量requestCode

                break;
            case R.id.user_source_btn:
                //来源
                intent.putExtra(mStrType, CUSTOMERSOURCEID);

                startActivityForResult(intent, CUSTOMERTAGID);//使用时需定义变量requestCode


                break;
            case R.id.customer_will_btn:

                //意向
                intent.putExtra(mStrType, MEMBERINTENTID);

                startActivityForResult(intent, MEMBERINTENTID);//使用时需定义变量requestCode

                break;
            case R.id.customer_identification_btn:

                //标识
                intent.putExtra(mStrType, IDENTIFICATIONID);

                startActivityForResult(intent, IDENTIFICATIONID);//使用时需定义变量requestCode
                break;
            case R.id.collectors_btn:

                //采集人员
                intent.putExtra(mStrType, CREATEUSERLISTID);

                startActivityForResult(intent, CREATEUSERLISTID);//使用时需定义变量requestCode

                break;
            case R.id.membership_consultant_btn:


                //顾问
                intent.putExtra(mStrType, MANGERLISTID);

                startActivityForResult(intent, MANGERLISTID);//使用时需定义变量requestCode

                break;
            case R.id.card_type_btn:
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
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
//                else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//
//
//                }
            }

            if (requestCode == CUSTOMERTAGID) {

                mPostCustomerListBean.setLabelId(mId);

                mPostCustomerListBean.setLabelName(mName);

            }

            if (requestCode == MANGERLISTID) {

                mPostCustomerListBean.setOwnManagerId(mId);

                mPostCustomerListBean.setOwnManagerName(mName);

            }

            if (requestCode == CREATEUSERLISTID) {

                mPostCustomerListBean.setCreateUserId(mId);

                mPostCustomerListBean.setCreateUserName(mName);

            }
            if (requestCode == CUSTOMERINTRODUCERID) {

                mPostCustomerListBean.setIntroduceMemberId(mId);

                mPostCustomerListBean.setIntroduceMemberName(mName);

            }
            if (requestCode == CUSTOMERSOURCEID) {

                mPostCustomerListBean.setSourceId(mId);

                mPostCustomerListBean.setSourceName(mName);

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

//                mPostCustomerListBean.setiden(mId);
//
//                mPostCustomerListBean.setOwnTeacherName(mName);

            }



        }
    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void Success(CustomerInfoBean customerInfoBean) {

        s(this, "");


    }


    class SpinnerAdapter extends RecyclerView.Adapter<CustomerEditCollectionActivity.SpinnerAdapter.MyViewHolder> {
        @Override
        public CustomerEditCollectionActivity.SpinnerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            CustomerEditCollectionActivity.SpinnerAdapter.MyViewHolder holder = new CustomerEditCollectionActivity.SpinnerAdapter.MyViewHolder(LayoutInflater.from(
                    CustomerEditCollectionActivity.this).inflate(R.layout.item_edit_pop, parent,
                    false));

            return holder;
        }

        @Override
        public void onBindViewHolder(final CustomerEditCollectionActivity.SpinnerAdapter.MyViewHolder holder, final int position) {

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

                    notifyDataSetChanged();

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
