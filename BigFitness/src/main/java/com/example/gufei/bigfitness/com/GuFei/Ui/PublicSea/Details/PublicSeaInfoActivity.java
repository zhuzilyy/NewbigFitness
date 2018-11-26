package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaInfoForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Web.WebActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class PublicSeaInfoActivity extends BaseActivity<PublicSeaInfoActivityPresenter> implements PublicSeaInfoActivityContract.View {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_name_text)
    TextView userNameText;
    @BindView(R.id.user_name)
    TextView userName;

    @BindView(R.id.user_sxy)
    TextView userSxy;
    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.collection_user_tel_text)
    TextView collectionUserTelText;
    @BindView(R.id.collection_user_tel)
    TextView collectionUserTel;
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
    @BindView(R.id.note_text)
    TextView noteText;
    @BindView(R.id.note_content)
    TextView noteContent;
    @BindView(R.id.card_type_text)
    TextView cardTypeText;
    @BindView(R.id.card_type)
    TextView cardType;
    @BindView(R.id.prepare_money_text)
    TextView prepareMoneyText;
    @BindView(R.id.prepare_money)
    TextView prepareMoney;
    @BindView(R.id.abandon_reason_text)
    TextView abandonReasonText;
    @BindView(R.id.abandon_reason_content)
    TextView abandonReasonContent;

    public final static String PARAM = "param";
    public final static String NAME = "name";
    public final static String SEX = "sex";
    public final static String TYPE = "type";


    private String CustomerId;
    private String CustomerName;
    private String Sex;
    private String Type ;

    //公海详情
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_publuic_customer_info;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
    }

    @Override
    protected void initData() {


        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");


        Intent intent = getIntent();
        CustomerId = intent.getStringExtra(PARAM);
        CustomerName = intent.getStringExtra(NAME);
        Sex = intent.getStringExtra(SEX);
        Type = intent.getStringExtra(TYPE);
        tvTitle.setText("公海"+Type+"信息");
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        if ("会员".equals(Type)){
            mPresenter.getPublicseaMemberInfoById(UserName, UserId, token, ClubId, CustomerId);
        }else {
            mPresenter.getPublicseaCustomerInfoById(UserName, UserId, token, ClubId, CustomerId);
        }

    }

    public static void startWebActivity(Context context, String parm,String name,String sex,String type) {
        Intent intent = new Intent(context, PublicSeaInfoActivity.class);
        intent.putExtra(PARAM, parm);
        intent.putExtra(NAME, name);
        intent.putExtra(SEX, sex);
        intent.putExtra(TYPE, type);
        context.startActivity(intent);
    }
//
//    @OnClick({R.id.user_av_btn, R.id.user_height_btn, R.id.user_weight_btn, R.id.user_level_btn, R.id.user_age_btn, R.id.user_certificate_btn, R.id.good_btn, R.id.class_time_btn, R.id.class_stu_num_btn, R.id.class_total_weight_btn, R.id.user_introduce_btn, R.id.user_evaluation_btn, R.id.user_class_btn})
//    public void onViewClicked(View view) {
//        Intent intent;
//        switch (view.getId()) {
//                    case R.id.user_av_btn:
//                          intent = new Intent(PublicSeaInfoActivity.this, ImgVideoListActivity.class);
//                         startActivity(intent);
//                        break;
//                    case R.id.user_height_btn:
//                        break;
//                    case R.id.user_weight_btn:
//                        break;
//                    case R.id.user_level_btn:
//                        break;
//                    case R.id.user_age_btn:
//                        break;
//                    case R.id.user_certificate_btn:
//                        break;
//                    case R.id.good_btn:
//                        break;
//                    case R.id.class_time_btn:
//                        break;
//                    case R.id.class_stu_num_btn:
//                        break;
//                    case R.id.class_total_weight_btn:
//                        break;
//                    case R.id.user_introduce_btn:
//                        break;
//                    case R.id.user_evaluation_btn:
//                 intent = new Intent(PublicSeaInfoActivity.this, AppraiseActivity.class);
//                 startActivity(intent);
//                break;
//            case R.id.user_class_btn:
//                break;
//        }
//    }

    @Override
    public void succeed(PublicSeaListBean publicSeaListBean) {



        userName.setText(CustomerName);
        userSxy.setText(publicSeaListBean.getResult().getSex()==0?"女":"男");
        collectionUserTel.setText(String.valueOf(publicSeaListBean.getResult().getTel()));
        references.setText(String.valueOf(publicSeaListBean.getResult().getIntroduceMemberName()));
        customerSource.setText(String.valueOf(publicSeaListBean.getResult().getSourceName()));
        customerWill.setText(String.valueOf(publicSeaListBean.getResult().getIntentName()));
        customerIdentification.setText(String.valueOf(publicSeaListBean.getResult().getLabelName()));
        collectors.setText(String.valueOf(publicSeaListBean.getResult().getCreateUserName()));
        membershipConsultant.setText(String.valueOf(publicSeaListBean.getResult().getOldOwnManagerName()));
        noteContent.setText(String.valueOf(publicSeaListBean.getResult().getRemark()));
        cardType.setText(String.valueOf(publicSeaListBean.getResult().getPublicSeaName()));
        prepareMoney.setText(String.valueOf(publicSeaListBean.getResult().getInPublicSeaTime()));
        abandonReasonContent.setText(String.valueOf(publicSeaListBean.getResult().getInPublicSeaCause()));

//        userWeightText.setText(String.valueOf(teacherInfoBean.getResult().getWeight()));
//        userLevelText.setText(String.valueOf(teacherInfoBean.getResult().getLevel()));
//        userAgeText.setText(String.valueOf(teacherInfoBean.getResult().getWorkAge()));
//        classTimeText.setText(String.valueOf(teacherInfoBean.getResult().getLessonCount()));
//        classStuNumText.setText(String.valueOf(teacherInfoBean.getResult().getStudentCount()));
//        classTotalWeightText.setText(String.valueOf(teacherInfoBean.getResult().getHelpCount()));
//        userEvaluationText.setText(String.valueOf(teacherInfoBean.getResult().getStarCount()+"人评价"));
    }

    @Override
    public void succeed1(PublicSeaInfoForMemberBean publicSeaInfoForMemberBean) {
        userName.setText(CustomerName);
        userSxy.setText(publicSeaInfoForMemberBean.getResult().getSex());
        collectionUserTel.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getTel()));
        references.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getIntroduceMemberName()));
        customerSource.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getSourceName()));
        customerWill.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getIntentName()));
        customerIdentification.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getLabelName()));
        collectors.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getCreateUserName()));
        membershipConsultant.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getOwnManagerName()));
        noteContent.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getRemark()));
        cardType.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getCardTypeName()));
        prepareMoney.setText(String.valueOf(publicSeaInfoForMemberBean.getResult().getAbandonTime()));
        abandonReasonContent.setText("");
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


}
