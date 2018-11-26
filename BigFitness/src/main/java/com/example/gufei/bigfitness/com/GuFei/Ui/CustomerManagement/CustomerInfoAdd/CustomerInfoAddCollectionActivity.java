package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query.QueryActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record.MembersFollowUpRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.IDENTIFICATIONID;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class CustomerInfoAddCollectionActivity extends BaseActivity<CustomerInfoAddCollectionPresenter> implements SpinnerPopContract, CustomerInfoAddCollectionContract.View {


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

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");

        tvTitle.setText("客户信息采集");

        btnComplete.setText("保存");


    }

    @Override
    protected void initData() {

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


    @OnClick({R.id.btn_complete, R.id.user_sxy_btn, R.id.query_tel_btn, R.id.references_btn, R.id.user_source_btn, R.id.customer_will_btn, R.id.customer_identification_btn, R.id.collectors_btn, R.id.membership_consultant_btn, R.id.card_type_btn })
    public void onClick(View view) {

        mDatas = new ArrayList<String>();

        final Intent intent = new Intent(CustomerInfoAddCollectionActivity.this, FilterListActivity.class);

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

                Intent Query = new Intent();
                intent.setClass(CustomerInfoAddCollectionActivity.this, QueryActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);//将Bundle添加到Intent,也可以在Bundle中添加相应数据传递给下个页面,例如：bundle.putString("abc", "bbb");
                startActivityForResult(Query, 0);// 跳转并要求返回值，0代表请求值(可以随便写)

//                mDatas.add("男");
//                mDatas.add("女");
//                mDatas.add("男");
//                mDatas.add("女");
//                mDatas.add("男");
//
//
//
//
//                SpinnerPopupWindow s = new SpinnerPopupWindow.Builder(CustomerInfoCollectionActivity.this)
//                        .setmLayoutManager(null)
//                        .setmAdapter(new CustomerInfoCollectionActivity.SpinnerAdapter())
//                        .setOutsideTouchable(true)
//                        .setTitleText("性别")
//                        .setmSpinnerPopContract(this)
//                        .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
//                        .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT).build();
//
//                s.showPopCenter();
//
////                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
////                    @Override
////                    public void onDismiss() {
////                        backgroundAlpha(1f);
////                    }
////                });
//                backgroundAlpha(0.5f);
////                // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
////                // 我觉得这里是API的一个bug
////                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
//////                PopupView(view,R.id.user_sxy,"性别");

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


                break;
            case R.id.card_type_btn:
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
//            gameView.backString = bundle.getString("aaa");
            Toast.makeText(this, bundle.getString("aaa"), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void addPersonalSuccess() {


    }


//
//    class SpinnerAdapter extends RecyclerView.Adapter<CustomerInfoCollectionActivity.SpinnerAdapter.MyViewHolder> {
//        @Override
//        public CustomerInfoCollectionActivity.SpinnerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            CustomerInfoCollectionActivity.SpinnerAdapter.MyViewHolder holder = new CustomerInfoCollectionActivity.SpinnerAdapter.MyViewHolder(LayoutInflater.from(
//                    CustomerInfoCollectionActivity.this).inflate(R.layout.item_edit_pop, parent,
//                    false));
//
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(final CustomerInfoCollectionActivity.SpinnerAdapter.MyViewHolder holder, final int position) {
//
//            holder.tv.setText(mDatas.get(position));
//
//            holder.tv.setTag(position);
//
//
//                    if (position==ItemSelected){
//
//                        holder.selected_btn.setVisibility(View.VISIBLE);
//                     }else{
//                        holder.selected_btn.setVisibility(View.INVISIBLE);
//                    }
//
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    ItemSelected=position;
//
//                    notifyDataSetChanged();
//
//                }
//            });
//
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
//             ImageView selected_btn;
////            ImageView downBtn;
//
//            public MyViewHolder(final View view) {
//                super(view);
//
//                tv = (TextView) view.findViewById(R.id.test1);
//
//                selected_btn = (ImageView) view.findViewById(R.id.selected_btn);
////                downBtn = (ImageView) view.findViewById(R.id.down_btn);
//
//
//            }
//        }
//    }


}
