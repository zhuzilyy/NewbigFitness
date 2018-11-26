package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.BaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CARDTYPEID;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
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

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class MembersInfoDetailsActivity extends BaseActivity<MembersInfoDetailsActivityPresenter> implements MembersInfoDetailsActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    TextView btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_birth)
    EditText textBirth;
    @BindView(R.id.birth_btn)
    RelativeLayout birthBtn;
    @BindView(R.id.appointment_type_img)
    ImageView appointmentTypeImg;
    @BindView(R.id.text_nationality)
    EditText textNationality;
    @BindView(R.id.nationality_btn)
    RelativeLayout nationalityBtn;
    @BindView(R.id.course_type_img)
    ImageView courseTypeImg;
    @BindView(R.id.text_family)
    EditText textFamily;
    @BindView(R.id.family_btn)
    RelativeLayout familyBtn;
    @BindView(R.id.begin_vailable_img)
    ImageView beginVailableImg;
    @BindView(R.id.text_id_type)
    TextView textIdType;
    @BindView(R.id.id_type_btn)
    RelativeLayout idTypeBtn;
    @BindView(R.id.begin_time_img)
    ImageView beginTimeImg;
    @BindView(R.id.text_id_no)
    EditText textIdNo;
    @BindView(R.id.id_no_btn)
    RelativeLayout idNoBtn;
    @BindView(R.id.end_time_img)
    ImageView endTimeImg;
    @BindView(R.id.text_professional)
    EditText textProfessional;
    @BindView(R.id.professional_btn)
    RelativeLayout professionalBtn;
    @BindView(R.id.remind_time_img)
    ImageView remindTimeImg;
    @BindView(R.id.text_income)
    EditText textIncome;
    @BindView(R.id.income_btn)
    RelativeLayout incomeBtn;
    @BindView(R.id.interval_time_img)
    ImageView intervalTimeImg;
    @BindView(R.id.text_name_enterprise)
    EditText textNameEnterprise;
    @BindView(R.id.enterprise_name_btn)
    RelativeLayout enterpriseNameBtn;
    @BindView(R.id.address_business)
    TextView addressBusiness;
    @BindView(R.id.text_address_business)
    EditText textAddressBusiness;
    @BindView(R.id.expire_time_img)
    ImageView expireTimeImg;
    @BindView(R.id.text_tel_home)
    EditText textTelHome;
    @BindView(R.id.tel_home_btn)
    RelativeLayout telHomeBtn;
    @BindView(R.id.address_home)
    TextView addressHome;
    @BindView(R.id.text_address_home)
    EditText textAddressHome;
    @BindView(R.id.emergency_contact_img)
    ImageView emergencyContactImg;
    @BindView(R.id.text_emergency_contact)
    EditText textEmergencyContact;
    @BindView(R.id.emergency_contact_btn)
    RelativeLayout emergencyContactBtn;
    @BindView(R.id.emergency_contact_tel_img)
    ImageView emergencyContactTelImg;
    @BindView(R.id.text_emergency_contact_tel)
    EditText textEmergencyContactTel;
    @BindView(R.id.emergency_contact_tel_btn)
    RelativeLayout emergencyContactTelBtn;
    @BindView(R.id.itness_needs)
    TextView itnessNeeds;
    @BindView(R.id.text_fitness_needs)
    EditText textFitnessNeeds;
    @BindView(R.id.itness_CV)
    TextView itnessCV;
    @BindView(R.id.text_fitness_CV)
    EditText textFitnessCV;
    @BindView(R.id.car_brand_img)
    ImageView carBrandImg;
    @BindView(R.id.text_car_brand)
    EditText textCarBrand;
    @BindView(R.id.car_brand_btn)
    RelativeLayout carBrandBtn;
    @BindView(R.id.car_type_img)
    ImageView carTypeImg;
    @BindView(R.id.text_car_type)
    EditText textCarType;
    @BindView(R.id.car_type_btn)
    RelativeLayout carTypeBtn;
    @BindView(R.id.car_id_img)
    ImageView carIdImg;
    @BindView(R.id.text_car_id)
    EditText textCarId;
    @BindView(R.id.car_id_btn)
    RelativeLayout carIdBtn;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;
    @BindView(R.id.birth_type_img)
    ImageView birthTypeImg;
    private String Id;
    private String CustomerType;
    private String CardTypeId;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_lesson_private_details_documents_list;
    }



    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");

        String persontype = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");

        // TODO: 2018/3/12 7.	会籍账号 会员详细信息不能编辑，应该是可以编辑的
//        if (persontype.equals("会籍")){
//            btnComplete.setVisibility(View.INVISIBLE);
//        }


        appointmentTypeImg.setVisibility(View.INVISIBLE);
        courseTypeImg.setVisibility(View.INVISIBLE);
        beginVailableImg.setVisibility(View.INVISIBLE);
        beginTimeImg.setVisibility(View.INVISIBLE);
        endTimeImg.setVisibility(View.INVISIBLE);
        remindTimeImg.setVisibility(View.INVISIBLE);
        intervalTimeImg.setVisibility(View.INVISIBLE);
        expireTimeImg.setVisibility(View.INVISIBLE);
        emergencyContactImg.setVisibility(View.INVISIBLE);
        emergencyContactTelImg.setVisibility(View.INVISIBLE);
        carBrandImg.setVisibility(View.INVISIBLE);
        carTypeImg.setVisibility(View.INVISIBLE);
        carIdImg.setVisibility(View.INVISIBLE);
        birthTypeImg.setVisibility(View.INVISIBLE);


        textBirth.setEnabled(false);
        textNationality.setEnabled(false);
        textFamily.setEnabled(false);
        textIdNo.setEnabled(false);
        textProfessional.setEnabled(false);
        textIncome.setEnabled(false);
        textNameEnterprise.setEnabled(false);
        textAddressBusiness.setEnabled(false);
        textTelHome.setEnabled(false);
        textAddressHome.setEnabled(false);
        textEmergencyContact.setEnabled(false);
        textEmergencyContactTel.setEnabled(false);
        textFitnessNeeds.setEnabled(false);
        textFitnessCV.setEnabled(false);
        textCarBrand.setEnabled(false);
        textCarType.setEnabled(false);
        textCarId.setEnabled(false);



    }


    @Override
    protected void initData() {

        btnComplete.setText("编辑");
        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);



        Intent intent = getIntent();
//
//        CustomerName = intent.getStringExtra(PUT_STR + "Name");
        CustomerType = intent.getStringExtra(PUT_STR + "Type");
//        CustomerSex = intent.getStringExtra(PUT_STR + "Sex");
        Id = intent.getStringExtra(PUT_STR + "Id");
//

        mPresenter.getMemberInfo(UserName, UserId, token, ClubId, Integer.parseInt(Id));
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
    public void succeed(MemberInfoBean memberInfoBean) {


        textBirth.setText(memberInfoBean.getResult().getBirthday());
        textNationality.setText(memberInfoBean.getResult().getCountry());
        textFamily.setText(memberInfoBean.getResult().getNation());
        textIdType.setText(memberInfoBean.getResult().getCardTypeName());
        CardTypeId=memberInfoBean.getResult().getCardTypeId();
        textIdNo.setText(memberInfoBean.getResult().getCardNo());
        textProfessional.setText(memberInfoBean.getResult().getCareer());
        textIncome.setText(memberInfoBean.getResult().getIncome());

//        textNameEnterprise.setText(memberInfoBean.getResult());
        textNameEnterprise.setText(memberInfoBean.getResult().getWorkCompany());//所在企业

        textAddressBusiness.setText(memberInfoBean.getResult().getWorkAddress());

        textTelHome.setText(memberInfoBean.getResult().getHomeTel());

        textAddressHome.setText(memberInfoBean.getResult().getHomeAddress());

        textEmergencyContact.setText(memberInfoBean.getResult().getEmergencyPersonName());

        textEmergencyContactTel.setText(memberInfoBean.getResult().getEmergencyTel());

        textFitnessNeeds.setText(memberInfoBean.getResult().getFitnessRequest());

        textFitnessCV.setText(memberInfoBean.getResult().getFitnessExperience());

        textCarBrand.setText(memberInfoBean.getResult().getCarBrand());

        textCarType.setText(memberInfoBean.getResult().getCarType());

        textCarId.setText(memberInfoBean.getResult().getCarNo());

    }

    @Override
    public void updataSucceed(CodeBean codeBean) {
        s(this,"修改成功");

    }

    @OnClick({R.id.text_id_type,R.id.btn_complete, R.id.text_birth, R.id.birth_btn, R.id.nationality_btn, R.id.family_btn, R.id.id_type_btn, R.id.id_no_btn, R.id.professional_btn, R.id.income_btn, R.id.enterprise_name_btn, R.id.tel_home_btn, R.id.emergency_contact_btn, R.id.emergency_contact_tel_btn, R.id.car_brand_btn, R.id.car_type_btn, R.id.car_id_btn})
    public void onViewClicked(View view) {

        final Intent intent = new Intent(this, FilterListActivity.class);
        final String mStrType = "com.example.gufei.bigfitness.com.GuFei.Ui.main.type";
        switch (view.getId()) {
            case R.id.text_birth:
                break;
            case R.id.birth_btn:
                break;
            case R.id.nationality_btn:
                break;
            case R.id.family_btn:
                break;
            case R.id.text_id_type:

                if (carTypeImg.getVisibility()!=View.INVISIBLE) {
                intent.putExtra(mStrType, CARDTYPEID);

//                intent.putExtra(PUT_STR + "id", Integer.valueOf(Customerid));

//                        startActivity(intent);
                startActivityForResult(intent, CARDTYPEID);//使用时需定义变量requestCode
                     }
                break;
            case R.id.id_no_btn:
                break;
            case R.id.professional_btn:
                break;
            case R.id.income_btn:
                break;
            case R.id.enterprise_name_btn:
                break;
            case R.id.tel_home_btn:
                break;
            case R.id.emergency_contact_btn:
                break;
            case R.id.emergency_contact_tel_btn:
                break;
            case R.id.car_brand_btn:
                break;
            case R.id.car_type_btn:
                break;
            case R.id.car_id_btn:
                break;
            case R.id.btn_complete:


                String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

                String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

                int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);

                int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);


//                textFamily.getText().toString()


                if (btnComplete.getText().toString().equals("编辑")) {
                    btnComplete.setText("完成");
                    appointmentTypeImg.setVisibility(View.VISIBLE);
                    courseTypeImg.setVisibility(View.VISIBLE);
                    beginVailableImg.setVisibility(View.VISIBLE);
                    beginTimeImg.setVisibility(View.VISIBLE);
                    endTimeImg.setVisibility(View.VISIBLE);
                    remindTimeImg.setVisibility(View.VISIBLE);
                    intervalTimeImg.setVisibility(View.VISIBLE);
                    expireTimeImg.setVisibility(View.VISIBLE);
                    emergencyContactImg.setVisibility(View.VISIBLE);
                    emergencyContactTelImg.setVisibility(View.VISIBLE);
                    carBrandImg.setVisibility(View.VISIBLE);
                    carTypeImg.setVisibility(View.VISIBLE);
                    carIdImg.setVisibility(View.VISIBLE);
                    birthTypeImg.setVisibility(View.VISIBLE);


                    textBirth.setEnabled(true);
                    textNationality.setEnabled(true);
                    textFamily.setEnabled(true);
//                    textIdType.setEnabled(true);
                    textIdNo.setEnabled(true);
                    textProfessional.setEnabled(true);
                    textIncome.setEnabled(true);
                    textNameEnterprise.setEnabled(true);
                    textAddressBusiness.setEnabled(true);
                    textTelHome.setEnabled(true);
                    textAddressHome.setEnabled(true);
                    textEmergencyContact.setEnabled(true);
                    textEmergencyContactTel.setEnabled(true);
                    textFitnessNeeds.setEnabled(true);
                    textFitnessCV.setEnabled(true);
                    textCarBrand.setEnabled(true);
                    textCarType.setEnabled(true);
                    textCarId.setEnabled(true);
                    textIdType.setTextColor(Color.rgb(0, 0, 0));


                } else {
                    btnComplete.setText("编辑");
                    appointmentTypeImg.setVisibility(View.INVISIBLE);
                    courseTypeImg.setVisibility(View.INVISIBLE);
                    beginVailableImg.setVisibility(View.INVISIBLE);
                    beginTimeImg.setVisibility(View.INVISIBLE);
                    endTimeImg.setVisibility(View.INVISIBLE);
                    remindTimeImg.setVisibility(View.INVISIBLE);
                    intervalTimeImg.setVisibility(View.INVISIBLE);
                    expireTimeImg.setVisibility(View.INVISIBLE);
                    emergencyContactImg.setVisibility(View.INVISIBLE);
                    emergencyContactTelImg.setVisibility(View.INVISIBLE);
                    carBrandImg.setVisibility(View.INVISIBLE);
                    carTypeImg.setVisibility(View.INVISIBLE);
                    carIdImg.setVisibility(View.INVISIBLE);
                    birthTypeImg.setVisibility(View.INVISIBLE);
                    textIdType.setTextColor(Color.rgb(	192,192,192));

                    textBirth.setEnabled(false);
                    textNationality.setEnabled(false);
                    textFamily.setEnabled(false);
//                    textIdType.setEnabled(false);
                    textIdNo.setEnabled(false);
                    textProfessional.setEnabled(false);
                    textIncome.setEnabled(false);
                    textNameEnterprise.setEnabled(false);
                    textAddressBusiness.setEnabled(false);
                    textTelHome.setEnabled(false);
                    textAddressHome.setEnabled(false);
                    textEmergencyContact.setEnabled(false);
                    textEmergencyContactTel.setEnabled(false);
                    textFitnessNeeds.setEnabled(false);
                    textFitnessCV.setEnabled(false);
                    textCarBrand.setEnabled(false);
                    textCarType.setEnabled(false);
                    textCarId.setEnabled(false);

                    mPresenter.updateMemberInfo(UserId,
                            UserName,
                            token,
                            ClubId,
                            Id,
                            textBirth.getText().toString(),
                            textCarBrand.getText().toString(),
                            textIdNo.getText().toString(),
                            CardTypeId,
                            textProfessional.getText().toString(),
                            textCarType.getText().toString(),
                            textNationality.getText().toString(),
                            textEmergencyContact.getText().toString(),
                            textEmergencyContactTel.getText().toString(),
                            textFitnessCV.getText().toString(),
                            textFitnessNeeds.getText().toString(),
                            textAddressHome.getText().toString(),
                            textTelHome.getText().toString(),
                            textNameEnterprise.getText().toString(),
                            textAddressBusiness.getText().toString(),
                            textFamily.getText().toString(),
                            textIncome.getText().toString(),
                            textCarId.getText().toString());
                }

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

//        if (requestCode == MEMBERAPPOINTMENTTYPEBYID) {
//
//            AppointmentTypeIdValue = mId;
//
//            appointmentTypeText.setText(mName);
//

//
//        }
        if (requestCode == CARDTYPEID) {

            CardTypeId = mId;

            textIdType.setText(mName);


        }


    }


}

