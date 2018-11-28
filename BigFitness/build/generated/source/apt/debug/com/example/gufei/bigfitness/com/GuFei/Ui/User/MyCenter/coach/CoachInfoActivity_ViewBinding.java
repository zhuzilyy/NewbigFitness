// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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

public class CoachInfoActivity_ViewBinding<T extends CoachInfoActivity> implements Unbinder {
  protected T target;

  private View view2131820868;

  private View view2131820870;

  private View view2131820874;

  private View view2131820877;

  private View view2131820879;

  private View view2131820881;

  private View view2131820883;

  private View view2131820885;

  private View view2131820887;

  private View view2131820889;

  private View view2131820891;

  private View view2131820893;

  private View view2131820896;

  private View view2131820978;

  @UiThread
  public CoachInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.user_av_btn, "field 'userAvBtn' and method 'onViewClicked'");
    target.userAvBtn = Utils.castView(view, R.id.user_av_btn, "field 'userAvBtn'", RelativeLayout.class);
    view2131820868 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userHeightText = Utils.findRequiredViewAsType(source, R.id.user_height_text, "field 'userHeightText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.user_height_btn, "field 'userHeightBtn' and method 'onViewClicked'");
    target.userHeightBtn = Utils.castView(view, R.id.user_height_btn, "field 'userHeightBtn'", RelativeLayout.class);
    view2131820870 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userWeightText = Utils.findRequiredViewAsType(source, R.id.user_weight_text, "field 'userWeightText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.user_weight_btn, "field 'userWeightBtn' and method 'onViewClicked'");
    target.userWeightBtn = Utils.castView(view, R.id.user_weight_btn, "field 'userWeightBtn'", RelativeLayout.class);
    view2131820874 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userLevelText = Utils.findRequiredViewAsType(source, R.id.user_level_text, "field 'userLevelText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.user_level_btn, "field 'userLevelBtn' and method 'onViewClicked'");
    target.userLevelBtn = Utils.castView(view, R.id.user_level_btn, "field 'userLevelBtn'", RelativeLayout.class);
    view2131820877 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userAgeText = Utils.findRequiredViewAsType(source, R.id.user_age_text, "field 'userAgeText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.user_age_btn, "field 'userAgeBtn' and method 'onViewClicked'");
    target.userAgeBtn = Utils.castView(view, R.id.user_age_btn, "field 'userAgeBtn'", RelativeLayout.class);
    view2131820879 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_certificate_btn, "field 'userCertificateBtn' and method 'onViewClicked'");
    target.userCertificateBtn = Utils.castView(view, R.id.user_certificate_btn, "field 'userCertificateBtn'", RelativeLayout.class);
    view2131820881 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.good_btn, "field 'goodBtn' and method 'onViewClicked'");
    target.goodBtn = Utils.castView(view, R.id.good_btn, "field 'goodBtn'", RelativeLayout.class);
    view2131820883 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.classTimeText = Utils.findRequiredViewAsType(source, R.id.class_time_text, "field 'classTimeText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.class_time_btn, "field 'classTimeBtn' and method 'onViewClicked'");
    target.classTimeBtn = Utils.castView(view, R.id.class_time_btn, "field 'classTimeBtn'", RelativeLayout.class);
    view2131820885 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.classStuNumText = Utils.findRequiredViewAsType(source, R.id.class_stu_num_text, "field 'classStuNumText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.class_stu_num_btn, "field 'classStuNumBtn' and method 'onViewClicked'");
    target.classStuNumBtn = Utils.castView(view, R.id.class_stu_num_btn, "field 'classStuNumBtn'", RelativeLayout.class);
    view2131820887 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.classTotalWeightText = Utils.findRequiredViewAsType(source, R.id.class_total_weight_text, "field 'classTotalWeightText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.class_total_weight_btn, "field 'classTotalWeightBtn' and method 'onViewClicked'");
    target.classTotalWeightBtn = Utils.castView(view, R.id.class_total_weight_btn, "field 'classTotalWeightBtn'", RelativeLayout.class);
    view2131820889 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_introduce_btn, "field 'userIntroduceBtn' and method 'onViewClicked'");
    target.userIntroduceBtn = Utils.castView(view, R.id.user_introduce_btn, "field 'userIntroduceBtn'", RelativeLayout.class);
    view2131820891 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userEvaluationText = Utils.findRequiredViewAsType(source, R.id.user_evaluation_text, "field 'userEvaluationText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.user_evaluation_btn, "field 'userEvaluationBtn' and method 'onViewClicked'");
    target.userEvaluationBtn = Utils.castView(view, R.id.user_evaluation_btn, "field 'userEvaluationBtn'", RelativeLayout.class);
    view2131820893 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_class_btn, "field 'userClassBtn' and method 'onViewClicked'");
    target.userClassBtn = Utils.castView(view, R.id.user_class_btn, "field 'userClassBtn'", RelativeLayout.class);
    view2131820896 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userAvImg = Utils.findRequiredViewAsType(source, R.id.user_av_img, "field 'userAvImg'", ImageView.class);
    target.userHeightImg = Utils.findRequiredViewAsType(source, R.id.user_height_img, "field 'userHeightImg'", ImageView.class);
    target.userWeightImg = Utils.findRequiredViewAsType(source, R.id.user_weight_img, "field 'userWeightImg'", ImageView.class);
    target.userCertificateImg = Utils.findRequiredViewAsType(source, R.id.user_certificate_img, "field 'userCertificateImg'", ImageView.class);
    target.goodImg = Utils.findRequiredViewAsType(source, R.id.good_img, "field 'goodImg'", ImageView.class);
    target.userIntroduceImg = Utils.findRequiredViewAsType(source, R.id.user_introduce_img, "field 'userIntroduceImg'", ImageView.class);
    target.userEvaluationImg = Utils.findRequiredViewAsType(source, R.id.user_evaluation_img, "field 'userEvaluationImg'", ImageView.class);
    target.userClassImg = Utils.findRequiredViewAsType(source, R.id.user_class_img, "field 'userClassImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.userAvBtn = null;
    target.userHeightText = null;
    target.userHeightBtn = null;
    target.userWeightText = null;
    target.userWeightBtn = null;
    target.userLevelText = null;
    target.userLevelBtn = null;
    target.userAgeText = null;
    target.userAgeBtn = null;
    target.userCertificateBtn = null;
    target.goodBtn = null;
    target.classTimeText = null;
    target.classTimeBtn = null;
    target.classStuNumText = null;
    target.classStuNumBtn = null;
    target.classTotalWeightText = null;
    target.classTotalWeightBtn = null;
    target.userIntroduceBtn = null;
    target.userEvaluationText = null;
    target.userEvaluationBtn = null;
    target.userClassBtn = null;
    target.activityAddressDetails = null;
    target.btnComplete = null;
    target.userAvImg = null;
    target.userHeightImg = null;
    target.userWeightImg = null;
    target.userCertificateImg = null;
    target.goodImg = null;
    target.userIntroduceImg = null;
    target.userEvaluationImg = null;
    target.userClassImg = null;

    view2131820868.setOnClickListener(null);
    view2131820868 = null;
    view2131820870.setOnClickListener(null);
    view2131820870 = null;
    view2131820874.setOnClickListener(null);
    view2131820874 = null;
    view2131820877.setOnClickListener(null);
    view2131820877 = null;
    view2131820879.setOnClickListener(null);
    view2131820879 = null;
    view2131820881.setOnClickListener(null);
    view2131820881 = null;
    view2131820883.setOnClickListener(null);
    view2131820883 = null;
    view2131820885.setOnClickListener(null);
    view2131820885 = null;
    view2131820887.setOnClickListener(null);
    view2131820887 = null;
    view2131820889.setOnClickListener(null);
    view2131820889 = null;
    view2131820891.setOnClickListener(null);
    view2131820891 = null;
    view2131820893.setOnClickListener(null);
    view2131820893 = null;
    view2131820896.setOnClickListener(null);
    view2131820896 = null;
    view2131820978.setOnClickListener(null);
    view2131820978 = null;

    this.target = null;
  }
}
