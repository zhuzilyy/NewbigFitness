// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LessonInfoPrivateActivity_ViewBinding<T extends LessonInfoPrivateActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LessonInfoPrivateActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.textBirth = Utils.findRequiredViewAsType(source, R.id.text_birth, "field 'textBirth'", TextView.class);
    target.birthBtn = Utils.findRequiredViewAsType(source, R.id.birth_btn, "field 'birthBtn'", RelativeLayout.class);
    target.appointmentTypeImg = Utils.findRequiredViewAsType(source, R.id.appointment_type_img, "field 'appointmentTypeImg'", ImageView.class);
    target.textNationality = Utils.findRequiredViewAsType(source, R.id.text_nationality, "field 'textNationality'", TextView.class);
    target.nationalityBtn = Utils.findRequiredViewAsType(source, R.id.nationality_btn, "field 'nationalityBtn'", RelativeLayout.class);
    target.courseTypeImg = Utils.findRequiredViewAsType(source, R.id.course_type_img, "field 'courseTypeImg'", ImageView.class);
    target.textFamily = Utils.findRequiredViewAsType(source, R.id.text_family, "field 'textFamily'", TextView.class);
    target.familyBtn = Utils.findRequiredViewAsType(source, R.id.family_btn, "field 'familyBtn'", RelativeLayout.class);
    target.beginVailableImg = Utils.findRequiredViewAsType(source, R.id.begin_vailable_img, "field 'beginVailableImg'", ImageView.class);
    target.textIdType = Utils.findRequiredViewAsType(source, R.id.text_id_type, "field 'textIdType'", TextView.class);
    target.idTypeBtn = Utils.findRequiredViewAsType(source, R.id.id_type_btn, "field 'idTypeBtn'", RelativeLayout.class);
    target.beginTimeImg = Utils.findRequiredViewAsType(source, R.id.begin_time_img, "field 'beginTimeImg'", ImageView.class);
    target.textIdNo = Utils.findRequiredViewAsType(source, R.id.text_id_no, "field 'textIdNo'", TextView.class);
    target.idNoBtn = Utils.findRequiredViewAsType(source, R.id.id_no_btn, "field 'idNoBtn'", RelativeLayout.class);
    target.endTimeImg = Utils.findRequiredViewAsType(source, R.id.end_time_img, "field 'endTimeImg'", ImageView.class);
    target.textProfessional = Utils.findRequiredViewAsType(source, R.id.text_professional, "field 'textProfessional'", TextView.class);
    target.professionalBtn = Utils.findRequiredViewAsType(source, R.id.professional_btn, "field 'professionalBtn'", RelativeLayout.class);
    target.remindTimeImg = Utils.findRequiredViewAsType(source, R.id.remind_time_img, "field 'remindTimeImg'", ImageView.class);
    target.textIncome = Utils.findRequiredViewAsType(source, R.id.text_income, "field 'textIncome'", TextView.class);
    target.incomeBtn = Utils.findRequiredViewAsType(source, R.id.income_btn, "field 'incomeBtn'", RelativeLayout.class);
    target.intervalTimeImg = Utils.findRequiredViewAsType(source, R.id.interval_time_img, "field 'intervalTimeImg'", ImageView.class);
    target.textNameEnterprise = Utils.findRequiredViewAsType(source, R.id.text_name_enterprise, "field 'textNameEnterprise'", TextView.class);
    target.enterpriseNameBtn = Utils.findRequiredViewAsType(source, R.id.enterprise_name_btn, "field 'enterpriseNameBtn'", RelativeLayout.class);
    target.addressBusiness = Utils.findRequiredViewAsType(source, R.id.address_business, "field 'addressBusiness'", TextView.class);
    target.textAddressBusiness = Utils.findRequiredViewAsType(source, R.id.text_address_business, "field 'textAddressBusiness'", TextView.class);
    target.expireTimeImg = Utils.findRequiredViewAsType(source, R.id.expire_time_img, "field 'expireTimeImg'", ImageView.class);
    target.textTelHome = Utils.findRequiredViewAsType(source, R.id.text_tel_home, "field 'textTelHome'", TextView.class);
    target.telHomeBtn = Utils.findRequiredViewAsType(source, R.id.tel_home_btn, "field 'telHomeBtn'", RelativeLayout.class);
    target.addressHome = Utils.findRequiredViewAsType(source, R.id.address_home, "field 'addressHome'", TextView.class);
    target.textAddressHome = Utils.findRequiredViewAsType(source, R.id.text_address_home, "field 'textAddressHome'", TextView.class);
    target.emergencyContactImg = Utils.findRequiredViewAsType(source, R.id.emergency_contact_img, "field 'emergencyContactImg'", ImageView.class);
    target.textEmergencyContact = Utils.findRequiredViewAsType(source, R.id.text_emergency_contact, "field 'textEmergencyContact'", TextView.class);
    target.emergencyContactBtn = Utils.findRequiredViewAsType(source, R.id.emergency_contact_btn, "field 'emergencyContactBtn'", RelativeLayout.class);
    target.emergencyContactTelImg = Utils.findRequiredViewAsType(source, R.id.emergency_contact_tel_img, "field 'emergencyContactTelImg'", ImageView.class);
    target.textEmergencyContactTel = Utils.findRequiredViewAsType(source, R.id.text_emergency_contact_tel, "field 'textEmergencyContactTel'", TextView.class);
    target.emergencyContactTelBtn = Utils.findRequiredViewAsType(source, R.id.emergency_contact_tel_btn, "field 'emergencyContactTelBtn'", RelativeLayout.class);
    target.itnessNeeds = Utils.findRequiredViewAsType(source, R.id.itness_needs, "field 'itnessNeeds'", TextView.class);
    target.textFitnessNeeds = Utils.findRequiredViewAsType(source, R.id.text_fitness_needs, "field 'textFitnessNeeds'", TextView.class);
    target.itnessCV = Utils.findRequiredViewAsType(source, R.id.itness_CV, "field 'itnessCV'", TextView.class);
    target.textFitnessCV = Utils.findRequiredViewAsType(source, R.id.text_fitness_CV, "field 'textFitnessCV'", TextView.class);
    target.carBrandImg = Utils.findRequiredViewAsType(source, R.id.car_brand_img, "field 'carBrandImg'", ImageView.class);
    target.textCarBrand = Utils.findRequiredViewAsType(source, R.id.text_car_brand, "field 'textCarBrand'", TextView.class);
    target.carBrandBtn = Utils.findRequiredViewAsType(source, R.id.car_brand_btn, "field 'carBrandBtn'", RelativeLayout.class);
    target.carTypeImg = Utils.findRequiredViewAsType(source, R.id.car_type_img, "field 'carTypeImg'", ImageView.class);
    target.textCarType = Utils.findRequiredViewAsType(source, R.id.text_car_type, "field 'textCarType'", TextView.class);
    target.carTypeBtn = Utils.findRequiredViewAsType(source, R.id.car_type_btn, "field 'carTypeBtn'", RelativeLayout.class);
    target.carIdImg = Utils.findRequiredViewAsType(source, R.id.car_id_img, "field 'carIdImg'", ImageView.class);
    target.textCarId = Utils.findRequiredViewAsType(source, R.id.text_car_id, "field 'textCarId'", TextView.class);
    target.carIdBtn = Utils.findRequiredViewAsType(source, R.id.car_id_btn, "field 'carIdBtn'", RelativeLayout.class);
    target.recyclerviewid = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerviewid'", RecyclerView.class);
    target.swiperefreshlayoutid = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swiperefreshlayoutid'", SwipeRefreshLayout.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.textBirth = null;
    target.birthBtn = null;
    target.appointmentTypeImg = null;
    target.textNationality = null;
    target.nationalityBtn = null;
    target.courseTypeImg = null;
    target.textFamily = null;
    target.familyBtn = null;
    target.beginVailableImg = null;
    target.textIdType = null;
    target.idTypeBtn = null;
    target.beginTimeImg = null;
    target.textIdNo = null;
    target.idNoBtn = null;
    target.endTimeImg = null;
    target.textProfessional = null;
    target.professionalBtn = null;
    target.remindTimeImg = null;
    target.textIncome = null;
    target.incomeBtn = null;
    target.intervalTimeImg = null;
    target.textNameEnterprise = null;
    target.enterpriseNameBtn = null;
    target.addressBusiness = null;
    target.textAddressBusiness = null;
    target.expireTimeImg = null;
    target.textTelHome = null;
    target.telHomeBtn = null;
    target.addressHome = null;
    target.textAddressHome = null;
    target.emergencyContactImg = null;
    target.textEmergencyContact = null;
    target.emergencyContactBtn = null;
    target.emergencyContactTelImg = null;
    target.textEmergencyContactTel = null;
    target.emergencyContactTelBtn = null;
    target.itnessNeeds = null;
    target.textFitnessNeeds = null;
    target.itnessCV = null;
    target.textFitnessCV = null;
    target.carBrandImg = null;
    target.textCarBrand = null;
    target.carBrandBtn = null;
    target.carTypeImg = null;
    target.textCarType = null;
    target.carTypeBtn = null;
    target.carIdImg = null;
    target.textCarId = null;
    target.carIdBtn = null;
    target.recyclerviewid = null;
    target.swiperefreshlayoutid = null;
    target.activityAddressDetails = null;

    this.target = null;
  }
}
