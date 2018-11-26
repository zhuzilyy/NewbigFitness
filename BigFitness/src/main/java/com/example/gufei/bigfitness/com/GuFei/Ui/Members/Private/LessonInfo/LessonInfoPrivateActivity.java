package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo;

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
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;
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


public class LessonInfoPrivateActivity extends BaseActivity<LessonInfoPrivateActivityPresenter> implements LessonInfoPrivateActivityContract.View {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_birth)
    TextView textBirth;
    @BindView(R.id.birth_btn)
    RelativeLayout birthBtn;
    @BindView(R.id.appointment_type_img)
    ImageView appointmentTypeImg;
    @BindView(R.id.text_nationality)
    TextView textNationality;
    @BindView(R.id.nationality_btn)
    RelativeLayout nationalityBtn;
    @BindView(R.id.course_type_img)
    ImageView courseTypeImg;
    @BindView(R.id.text_family)
    TextView textFamily;
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
    TextView textIdNo;
    @BindView(R.id.id_no_btn)
    RelativeLayout idNoBtn;
    @BindView(R.id.end_time_img)
    ImageView endTimeImg;
    @BindView(R.id.text_professional)
    TextView textProfessional;
    @BindView(R.id.professional_btn)
    RelativeLayout professionalBtn;
    @BindView(R.id.remind_time_img)
    ImageView remindTimeImg;
    @BindView(R.id.text_income)
    TextView textIncome;
    @BindView(R.id.income_btn)
    RelativeLayout incomeBtn;
    @BindView(R.id.interval_time_img)
    ImageView intervalTimeImg;
    @BindView(R.id.text_name_enterprise)
    TextView textNameEnterprise;
    @BindView(R.id.enterprise_name_btn)
    RelativeLayout enterpriseNameBtn;
    @BindView(R.id.address_business)
    TextView addressBusiness;
    @BindView(R.id.text_address_business)
    TextView textAddressBusiness;
    @BindView(R.id.expire_time_img)
    ImageView expireTimeImg;
    @BindView(R.id.text_tel_home)
    TextView textTelHome;
    @BindView(R.id.tel_home_btn)
    RelativeLayout telHomeBtn;
    @BindView(R.id.address_home)
    TextView addressHome;
    @BindView(R.id.text_address_home)
    TextView textAddressHome;
    @BindView(R.id.emergency_contact_img)
    ImageView emergencyContactImg;
    @BindView(R.id.text_emergency_contact)
    TextView textEmergencyContact;
    @BindView(R.id.emergency_contact_btn)
    RelativeLayout emergencyContactBtn;
    @BindView(R.id.emergency_contact_tel_img)
    ImageView emergencyContactTelImg;
    @BindView(R.id.text_emergency_contact_tel)
    TextView textEmergencyContactTel;
    @BindView(R.id.emergency_contact_tel_btn)
    RelativeLayout emergencyContactTelBtn;
    @BindView(R.id.itness_needs)
    TextView itnessNeeds;
    @BindView(R.id.text_fitness_needs)
    TextView textFitnessNeeds;
    @BindView(R.id.itness_CV)
    TextView itnessCV;
    @BindView(R.id.text_fitness_CV)
    TextView textFitnessCV;
    @BindView(R.id.car_brand_img)
    ImageView carBrandImg;
    @BindView(R.id.text_car_brand)
    TextView textCarBrand;
    @BindView(R.id.car_brand_btn)
    RelativeLayout carBrandBtn;
    @BindView(R.id.car_type_img)
    ImageView carTypeImg;
    @BindView(R.id.text_car_type)
    TextView textCarType;
    @BindView(R.id.car_type_btn)
    RelativeLayout carTypeBtn;
    @BindView(R.id.car_id_img)
    ImageView carIdImg;
    @BindView(R.id.text_car_id)
    TextView textCarId;
    @BindView(R.id.car_id_btn)
    RelativeLayout carIdBtn;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;


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

        tvTitle.setText("上课详情");

    }


    @Override
    protected void initData() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        Intent intent = getIntent();
        String Customerid = intent.getStringExtra(PUT_STR + "Id");
        String AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        String lessonType = intent.getStringExtra(PUT_STR + "Type");
        String lessonName = intent.getStringExtra(PUT_STR + "Name");
        String lessonCoach = intent.getStringExtra(PUT_STR + "coach");
        String lessonTime = intent.getStringExtra(PUT_STR + "time");

        mPresenter.getLessonInfoFromApponitment(UserId, token, ClubId, Customerid, lessonType, AppointmentId);
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
    public void succeed(LessonInfoBean lessonInfoBean) {
//        tvTitle.setText(lessonInfoBean.getResult());
//        textBirth.setText(lessonInfoBean.getResult().get);
//        textNationality.setText(lessonInfoBean.getResult());
//        textFamily.setText(lessonInfoBean.getResult());
//        textIdType.setText(lessonInfoBean.getResult());
//        textIdNo.setText(lessonInfoBean.getResult());
//        textProfessional.setText(lessonInfoBean.getResult());
//        textIncome.setText(lessonInfoBean.getResult());
//        textNameEnterprise.setText(lessonInfoBean.getResult());
//        addressBusiness.setText(lessonInfoBean.getResult());
//        textAddressBusiness.setText(lessonInfoBean.getResult());
//        textTelHome.setText(lessonInfoBean.getResult());
//        addressHome.setText(lessonInfoBean.getResult());
//        textAddressHome.setText(lessonInfoBean.getResult());
//        textEmergencyContact.setText(lessonInfoBean.getResult());
//        textEmergencyContactTel.setText(lessonInfoBean.getResult());
//        itnessNeeds.setText(lessonInfoBean.getResult());
//        textFitnessNeeds.setText(lessonInfoBean.getResult());
//        itnessCV.setText(lessonInfoBean.getResult());
//        textFitnessCV.setText(lessonInfoBean.getResult());
//        textCarBrand.setText(lessonInfoBean.getResult());
//        textCarType.setText(lessonInfoBean.getResult());
//        textCarId.setText(lessonInfoBean.getResult());

//        textNationality.setText(lessonInfoBean.getResult().getCountry());
//        textFamily.setText(lessonInfoBean.getResult().getNation());
//        textIdType.setText(lessonInfoBean.getResult().getCardTypeName());
//        textIdNo.setText(lessonInfoBean.getResult().getCardNo());
//        textProfessional.setText(lessonInfoBean.getResult().getCareer());
//        textIncome.setText(lessonInfoBean.getResult().getIncome());
////        textNameEnterprise.setText(memberInfoBean.getResult());
//        textNameEnterprise.setText("");//所在企业
//
//        textAddressBusiness.setText(lessonInfoBean.getResult().getWorkAddress());
//        textTelHome.setText(lessonInfoBean.getResult().getHomeTel());
//
//        textAddressHome.setText(memberInfoBean.getResult().getHomeAddress());
//        textEmergencyContact.setText(memberInfoBean.getResult().getEmergencyPersonName());
//        textEmergencyContactTel.setText(memberInfoBean.getResult().getEmergencyTel());
//
//        textFitnessNeeds.setText(memberInfoBean.getResult().getFitnessRequest());
//
//        textFitnessCV.setText(memberInfoBean.getResult().getFitnessExperience());
//        textCarBrand.setText(memberInfoBean.getResult().getCarBrand());
//        textCarType.setText(memberInfoBean.getResult().getCarType());
//        textCarId.setText(memberInfoBean.getResult().getCarNo());


    }



//    @OnClick({R.id.appointment_type_btn, R.id.end_time_btn, R.id.remind_time_btn, R.id.interval_time_btn, R.id.begin_time_btn})
//    public void onViewClicked(View view) {
//
//
//        switch (view.getId()) {
//            case R.id.appointment_type_btn:
//                break;
//            case R.id.begin_time_btn:
//
//
//                break;
//            case R.id.end_time_btn:
//
//
//                break;
//            case R.id.remind_time_btn:
//
//
//                break;
//            case R.id.interval_time_btn:
//
//
//                break;
//        }
//    }


}

