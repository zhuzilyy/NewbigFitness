package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List.CourseListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList.LessonListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails.MembersInfoDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo.LessonInfoPrivateActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist.CardListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;


import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLASSNAMEID;
import static com.example.gufei.bigfitness.Constants.CLASSTYPEID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.MANGERLISTID;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.RESULT_ID;
import static com.example.gufei.bigfitness.Constants.RESULT_STRING;
import static com.example.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.example.gufei.bigfitness.Constants.RESULT_TEL;
import static com.example.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTID;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class MembersInfoActivity extends BaseActivity<MembersInfoActivityPresenter> implements MembersInfoActivityContract.View {


    @BindView(R.id.btn_card)
    LinearLayout btnCard;
    @BindView(R.id.btn_wardrobe)
    LinearLayout btnWardrobe;
    @BindView(R.id.btn_class)
    LinearLayout btnClass;

    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.user_name_text)
    TextView userNameText;
    @BindView(R.id.head_name_btn)
    RelativeLayout headNameBtn;

    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.head_sex_btn)
    RelativeLayout headSexBtn;

    @BindView(R.id.user_tel_text)
    TextView userTelText;
    @BindView(R.id.head_tel_btn)
    RelativeLayout headTelBtn;
    @BindView(R.id.head_user_type_text)
    TextView headUserTypeText;
    @BindView(R.id.head_user_type_btn)
    RelativeLayout headUserTypeBtn;
    @BindView(R.id.user_references_text)
    TextView userReferencesText;
    @BindView(R.id.head_references_btn)
    RelativeLayout headReferencesBtn;
    @BindView(R.id.source_id_text)
    TextView sourceIdText;
    @BindView(R.id.source_id_btn)
    RelativeLayout sourceIdBtn;
    @BindView(R.id.user_label_text)
    TextView userLabelText;
    @BindView(R.id.label_btn)
    RelativeLayout labelBtn;
    @BindView(R.id.member_intention_img)
    ImageView memberIntentionImg;
    @BindView(R.id.member_intention_text)
    TextView memberIntentionText;
    @BindView(R.id.member_intention_btn)
    RelativeLayout memberIntentionBtn;
    @BindView(R.id.text_consultant)
    TextView textConsultant;
    @BindView(R.id.btn_consultant)
    RelativeLayout btnConsultant;
    @BindView(R.id.text_coach_pos)
    TextView textCoachPos;
    @BindView(R.id.btn_coach_pos)
    RelativeLayout btnCoachPos;
    @BindView(R.id.text_coach_track)
    TextView textCoachTrack;
    @BindView(R.id.btn_coach_track)
    RelativeLayout btnCoachTrack;
    @BindView(R.id.text_follow_time)
    TextView textFollowTime;
    @BindView(R.id.btn_follow_time)
    RelativeLayout btnFollowTime;
    @BindView(R.id.text_left)
    TextView textLeft;
    @BindView(R.id.text_note)
    TextView textNote;
    @BindView(R.id.btn_note)
    RelativeLayout btnNote;
    @BindView(R.id.text_operator)
    TextView textOperator;
    @BindView(R.id.btn_operator)
    RelativeLayout btnOperator;
    @BindView(R.id.text_operating_time)
    TextView textOperatingTime;
    @BindView(R.id.btn_operating_time)
    RelativeLayout btnOperatingTime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_members_info)
    LinearLayout activityMembersInfo;

    private String Id;
    private String CustomerType;

    @Override

    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_members_info;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");


        Intent intent = getIntent();
//
//        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type").trim();
//        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        Id = intent.getStringExtra(PUT_STR + "Id");


        btnComplete.setText("详细信息");

        if (CustomerType.equals("会员")) {
            tvTitle.setText("会员信息");
//            btnClass.setVisibility(View.GONE);

        } else if (CustomerType.equals("过期会员")) {

            tvTitle.setText("过期会员信息");
        } else {
            tvTitle.setText("私教会员信息");
        }


    }

    @Override
    protected void initData() {

        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

//

        mPresenter.getMemberInfo(UserName, UserId, token, ClubId, Integer.parseInt(Id));
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
    public void updatasucceed(CodeBean codeBean) {

    }

    @Override
    public void succeed(MemberInfoBean memberInfoBean) {


        userNameText.setText(memberInfoBean.getResult().getMemberName());
        userSexText.setText(memberInfoBean.getResult().getSex());
        userTelText.setText(memberInfoBean.getResult().getTel());
        headUserTypeText.setText(memberInfoBean.getResult().getMemberType());
        userReferencesText.setText(memberInfoBean.getResult().getIntroduceMemberName());
        sourceIdText.setText(memberInfoBean.getResult().getSourceName());
        userLabelText.setText(memberInfoBean.getResult().getLabelName());
        memberIntentionText.setText(memberInfoBean.getResult().getIntentName());
        textConsultant.setText(memberInfoBean.getResult().getOwnManagerName());
        textCoachPos.setText(memberInfoBean.getResult().getPOSTeacherName());
        textCoachTrack.setText(memberInfoBean.getResult().getOwnTeacherName());
        textFollowTime.setText(memberInfoBean.getResult().getLastContactTime());

        textNote.setText(memberInfoBean.getResult().getRemark());
        textOperator.setText(memberInfoBean.getResult().getCreateUserName());
        textOperatingTime.setText(memberInfoBean.getResult().getCreateTime());


//        displayImage(mContext  ,memberInfoBean.getResult().getHeaderURL(),  imgHead);
        displayCircleImage(mContext, memberInfoBean.getResult().getHeaderURL(), imgHead, R.mipmap.privatememberinfor_03);
//        tvTitle.setText(memberInfoBean.getResult());


    }


    @Override
    public void Loading() {

    }


    @OnClick({R.id.btn_card, R.id.btn_wardrobe, R.id.btn_class, R.id.head_name_btn, R.id.head_sex_btn, R.id.head_tel_btn, R.id.source_id_btn, R.id.label_btn, R.id.member_intention_btn, R.id.btn_consultant, R.id.btn_coach_pos, R.id.btn_coach_track, R.id.text_follow_time, R.id.btn_follow_time, R.id.btn_operator, R.id.text_operating_time, R.id.btn_operating_time, R.id.btn_complete})
    public void onViewClicked(View view) {


        final Intent FilterListintent = new Intent(this, FilterListActivity.class);


        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
        switch (view.getId()) {
            case R.id.btn_card:

                Intent intent1 = new Intent(context, CardListActivity.class);
                intent1.putExtra("cardlist", Id);

                startActivity(intent1);

                break;
            case R.id.btn_wardrobe:
//                CourseListActivity
                //预约记录

                Intent intent = new Intent(context, CourseListActivity.class);
                intent.putExtra(PUT_STR + "Id", Id);
//                intent.putExtra(PUT_STR + "Name", CustomerName);
                intent.putExtra(PUT_STR + "Type", "衣柜");
//                intent.putExtra(PUT_STR + "Sex",CustomerSex );


                startActivity(intent);

                break;
            case R.id.btn_class:

                String personType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
                if ("会籍".equals(personType)) {

                    s(mContext, "会籍无权查看课程!");
                } else {

                    //预约记录
                    Intent intentLession = new Intent(context, LessonListActivity.class);

                    intentLession.putExtra(PUT_STR + "memberId", Id);
//                intent.putExtra(PUT_STR + "Name", CustomerName);
                    intentLession.putExtra(PUT_STR + "Type", "课程");
//                intent.putExtra(PUT_STR + "Sex",CustomerSex );


                    startActivity(intentLession);

                }
                break;
            case R.id.head_name_btn:
                break;
            case R.id.head_sex_btn:
                break;
            case R.id.head_tel_btn:
                break;
            case R.id.source_id_btn:
                break;
            case R.id.label_btn:
                break;
            case R.id.member_intention_btn:


                FilterListintent.putExtra(mStrType, MEMBERINTENTID);

//                        startActivity(intent);
                startActivityForResult(FilterListintent, MEMBERINTENTID);//使用时需定义变量requestCode

                break;
            case R.id.btn_consultant:
                break;
            case R.id.btn_coach_pos:
                break;
            case R.id.btn_coach_track:
                break;
            case R.id.text_follow_time:
                break;
            case R.id.btn_follow_time:
                break;
            case R.id.btn_operator:
                break;
            case R.id.text_operating_time:
                break;
            case R.id.btn_operating_time:
                break;
            case R.id.btn_complete:
                //会员信息
                Intent CustomerInfo = new Intent(context, MembersInfoDetailsActivity.class);

                CustomerInfo.putExtra(PUT_STR + "Id", Id);
//                CustomerInfo.putExtra(PUT_STR + "Name", CustomerName);
                CustomerInfo.putExtra(PUT_STR + "Type", CustomerType);
//                CustomerInfo.putExtra(PUT_STR + "Sex", CustomerSex);


                startActivity(CustomerInfo);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        this.view_result.setText(data.getStringExtra("NewStringInIntent"));
        super.onActivityResult(requestCode, resultCode, data);

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


        if (requestCode == MEMBERINTENTID) {

            String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

            int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

            String token = (String) SpUtil.get(mContext, TOKENKEY, "");

            int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

            memberIntentionText.setText(mName);

            mPresenter.updateMemberIntentId(UserId, UserName, token, ClubId, Id, mId);


        }


        //// TODO: 2017/6/5 办卡类型未实现
//        if (requestCode == ALLMEMBERCARDTYPEID ) {
//
//            mPostCustomerListBean.set(mId);
//
//            mPostCustomerListBean.setIntentName(mName);
//
//        }


    }
}
