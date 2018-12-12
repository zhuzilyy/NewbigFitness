// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MembersInfoDetailsActivity_ViewBinding<T extends MembersInfoDetailsActivity> implements Unbinder {
  protected T target;

  private View view2131820980;

  private View view2131820983;

  private View view2131820981;

  private View view2131820984;

  private View view2131820986;

  private View view2131820989;

  private View view2131820988;

  private View view2131820990;

  private View view2131820992;

  private View view2131820994;

  private View view2131820996;

  private View view2131821000;

  private View view2131821005;

  private View view2131821008;

  private View view2131821015;

  private View view2131821018;

  private View view2131821021;

  @UiThread
  public MembersInfoDetailsActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", TextView.class);
    view2131820980 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.text_birth, "field 'textBirth' and method 'onViewClicked'");
    target.textBirth = Utils.castView(view, R.id.text_birth, "field 'textBirth'", EditText.class);
    view2131820983 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.birth_btn, "field 'birthBtn' and method 'onViewClicked'");
    target.birthBtn = Utils.castView(view, R.id.birth_btn, "field 'birthBtn'", RelativeLayout.class);
    view2131820981 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.appointmentTypeImg = Utils.findRequiredViewAsType(source, R.id.appointment_type_img, "field 'appointmentTypeImg'", ImageView.class);
    target.textNationality = Utils.findRequiredViewAsType(source, R.id.text_nationality, "field 'textNationality'", EditText.class);
    view = Utils.findRequiredView(source, R.id.nationality_btn, "field 'nationalityBtn' and method 'onViewClicked'");
    target.nationalityBtn = Utils.castView(view, R.id.nationality_btn, "field 'nationalityBtn'", RelativeLayout.class);
    view2131820984 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.courseTypeImg = Utils.findRequiredViewAsType(source, R.id.course_type_img, "field 'courseTypeImg'", ImageView.class);
    target.textFamily = Utils.findRequiredViewAsType(source, R.id.text_family, "field 'textFamily'", EditText.class);
    view = Utils.findRequiredView(source, R.id.family_btn, "field 'familyBtn' and method 'onViewClicked'");
    target.familyBtn = Utils.castView(view, R.id.family_btn, "field 'familyBtn'", RelativeLayout.class);
    view2131820986 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.beginVailableImg = Utils.findRequiredViewAsType(source, R.id.begin_vailable_img, "field 'beginVailableImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.text_id_type, "field 'textIdType' and method 'onViewClicked'");
    target.textIdType = Utils.castView(view, R.id.text_id_type, "field 'textIdType'", TextView.class);
    view2131820989 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.id_type_btn, "field 'idTypeBtn' and method 'onViewClicked'");
    target.idTypeBtn = Utils.castView(view, R.id.id_type_btn, "field 'idTypeBtn'", RelativeLayout.class);
    view2131820988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.beginTimeImg = Utils.findRequiredViewAsType(source, R.id.begin_time_img, "field 'beginTimeImg'", ImageView.class);
    target.textIdNo = Utils.findRequiredViewAsType(source, R.id.text_id_no, "field 'textIdNo'", EditText.class);
    view = Utils.findRequiredView(source, R.id.id_no_btn, "field 'idNoBtn' and method 'onViewClicked'");
    target.idNoBtn = Utils.castView(view, R.id.id_no_btn, "field 'idNoBtn'", RelativeLayout.class);
    view2131820990 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.endTimeImg = Utils.findRequiredViewAsType(source, R.id.end_time_img, "field 'endTimeImg'", ImageView.class);
    target.textProfessional = Utils.findRequiredViewAsType(source, R.id.text_professional, "field 'textProfessional'", EditText.class);
    view = Utils.findRequiredView(source, R.id.professional_btn, "field 'professionalBtn' and method 'onViewClicked'");
    target.professionalBtn = Utils.castView(view, R.id.professional_btn, "field 'professionalBtn'", RelativeLayout.class);
    view2131820992 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.remindTimeImg = Utils.findRequiredViewAsType(source, R.id.remind_time_img, "field 'remindTimeImg'", ImageView.class);
    target.textIncome = Utils.findRequiredViewAsType(source, R.id.text_income, "field 'textIncome'", EditText.class);
    view = Utils.findRequiredView(source, R.id.income_btn, "field 'incomeBtn' and method 'onViewClicked'");
    target.incomeBtn = Utils.castView(view, R.id.income_btn, "field 'incomeBtn'", RelativeLayout.class);
    view2131820994 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.intervalTimeImg = Utils.findRequiredViewAsType(source, R.id.interval_time_img, "field 'intervalTimeImg'", ImageView.class);
    target.textNameEnterprise = Utils.findRequiredViewAsType(source, R.id.text_name_enterprise, "field 'textNameEnterprise'", EditText.class);
    view = Utils.findRequiredView(source, R.id.enterprise_name_btn, "field 'enterpriseNameBtn' and method 'onViewClicked'");
    target.enterpriseNameBtn = Utils.castView(view, R.id.enterprise_name_btn, "field 'enterpriseNameBtn'", RelativeLayout.class);
    view2131820996 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.addressBusiness = Utils.findRequiredViewAsType(source, R.id.address_business, "field 'addressBusiness'", TextView.class);
    target.textAddressBusiness = Utils.findRequiredViewAsType(source, R.id.text_address_business, "field 'textAddressBusiness'", EditText.class);
    target.expireTimeImg = Utils.findRequiredViewAsType(source, R.id.expire_time_img, "field 'expireTimeImg'", ImageView.class);
    target.textTelHome = Utils.findRequiredViewAsType(source, R.id.text_tel_home, "field 'textTelHome'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tel_home_btn, "field 'telHomeBtn' and method 'onViewClicked'");
    target.telHomeBtn = Utils.castView(view, R.id.tel_home_btn, "field 'telHomeBtn'", RelativeLayout.class);
    view2131821000 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.addressHome = Utils.findRequiredViewAsType(source, R.id.address_home, "field 'addressHome'", TextView.class);
    target.textAddressHome = Utils.findRequiredViewAsType(source, R.id.text_address_home, "field 'textAddressHome'", EditText.class);
    target.emergencyContactImg = Utils.findRequiredViewAsType(source, R.id.emergency_contact_img, "field 'emergencyContactImg'", ImageView.class);
    target.textEmergencyContact = Utils.findRequiredViewAsType(source, R.id.text_emergency_contact, "field 'textEmergencyContact'", EditText.class);
    view = Utils.findRequiredView(source, R.id.emergency_contact_btn, "field 'emergencyContactBtn' and method 'onViewClicked'");
    target.emergencyContactBtn = Utils.castView(view, R.id.emergency_contact_btn, "field 'emergencyContactBtn'", RelativeLayout.class);
    view2131821005 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.emergencyContactTelImg = Utils.findRequiredViewAsType(source, R.id.emergency_contact_tel_img, "field 'emergencyContactTelImg'", ImageView.class);
    target.textEmergencyContactTel = Utils.findRequiredViewAsType(source, R.id.text_emergency_contact_tel, "field 'textEmergencyContactTel'", EditText.class);
    view = Utils.findRequiredView(source, R.id.emergency_contact_tel_btn, "field 'emergencyContactTelBtn' and method 'onViewClicked'");
    target.emergencyContactTelBtn = Utils.castView(view, R.id.emergency_contact_tel_btn, "field 'emergencyContactTelBtn'", RelativeLayout.class);
    view2131821008 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.itnessNeeds = Utils.findRequiredViewAsType(source, R.id.itness_needs, "field 'itnessNeeds'", TextView.class);
    target.textFitnessNeeds = Utils.findRequiredViewAsType(source, R.id.text_fitness_needs, "field 'textFitnessNeeds'", EditText.class);
    target.itnessCV = Utils.findRequiredViewAsType(source, R.id.itness_CV, "field 'itnessCV'", TextView.class);
    target.textFitnessCV = Utils.findRequiredViewAsType(source, R.id.text_fitness_CV, "field 'textFitnessCV'", EditText.class);
    target.carBrandImg = Utils.findRequiredViewAsType(source, R.id.car_brand_img, "field 'carBrandImg'", ImageView.class);
    target.textCarBrand = Utils.findRequiredViewAsType(source, R.id.text_car_brand, "field 'textCarBrand'", EditText.class);
    view = Utils.findRequiredView(source, R.id.car_brand_btn, "field 'carBrandBtn' and method 'onViewClicked'");
    target.carBrandBtn = Utils.castView(view, R.id.car_brand_btn, "field 'carBrandBtn'", RelativeLayout.class);
    view2131821015 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.carTypeImg = Utils.findRequiredViewAsType(source, R.id.car_type_img, "field 'carTypeImg'", ImageView.class);
    target.textCarType = Utils.findRequiredViewAsType(source, R.id.text_car_type, "field 'textCarType'", EditText.class);
    view = Utils.findRequiredView(source, R.id.car_type_btn, "field 'carTypeBtn' and method 'onViewClicked'");
    target.carTypeBtn = Utils.castView(view, R.id.car_type_btn, "field 'carTypeBtn'", RelativeLayout.class);
    view2131821018 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.carIdImg = Utils.findRequiredViewAsType(source, R.id.car_id_img, "field 'carIdImg'", ImageView.class);
    target.textCarId = Utils.findRequiredViewAsType(source, R.id.text_car_id, "field 'textCarId'", EditText.class);
    view = Utils.findRequiredView(source, R.id.car_id_btn, "field 'carIdBtn' and method 'onViewClicked'");
    target.carIdBtn = Utils.castView(view, R.id.car_id_btn, "field 'carIdBtn'", RelativeLayout.class);
    view2131821021 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.recyclerviewid = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerviewid'", RecyclerView.class);
    target.swiperefreshlayoutid = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swiperefreshlayoutid'", SwipeRefreshLayout.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
    target.birthTypeImg = Utils.findRequiredViewAsType(source, R.id.birth_type_img, "field 'birthTypeImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.btnComplete = null;
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
    target.birthTypeImg = null;

    view2131820980.setOnClickListener(null);
    view2131820980 = null;
    view2131820983.setOnClickListener(null);
    view2131820983 = null;
    view2131820981.setOnClickListener(null);
    view2131820981 = null;
    view2131820984.setOnClickListener(null);
    view2131820984 = null;
    view2131820986.setOnClickListener(null);
    view2131820986 = null;
    view2131820989.setOnClickListener(null);
    view2131820989 = null;
    view2131820988.setOnClickListener(null);
    view2131820988 = null;
    view2131820990.setOnClickListener(null);
    view2131820990 = null;
    view2131820992.setOnClickListener(null);
    view2131820992 = null;
    view2131820994.setOnClickListener(null);
    view2131820994 = null;
    view2131820996.setOnClickListener(null);
    view2131820996 = null;
    view2131821000.setOnClickListener(null);
    view2131821000 = null;
    view2131821005.setOnClickListener(null);
    view2131821005 = null;
    view2131821008.setOnClickListener(null);
    view2131821008 = null;
    view2131821015.setOnClickListener(null);
    view2131821015 = null;
    view2131821018.setOnClickListener(null);
    view2131821018 = null;
    view2131821021.setOnClickListener(null);
    view2131821021 = null;

    this.target = null;
  }
}
