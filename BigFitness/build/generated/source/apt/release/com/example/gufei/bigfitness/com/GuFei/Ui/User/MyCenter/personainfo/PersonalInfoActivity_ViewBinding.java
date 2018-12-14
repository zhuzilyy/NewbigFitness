// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalInfoActivity_ViewBinding<T extends PersonalInfoActivity> implements Unbinder {
  protected T target;

  private View view2131821117;

  private View view2131821115;

  private View view2131821078;

  private View view2131821079;

  private View view2131821119;

  private View view2131821081;

  private View view2131821121;

  private View view2131821124;

  private View view2131821127;

  private View view2131821084;

  private View view2131821129;

  private View view2131821131;

  private View view2131821133;

  private View view2131821135;

  private View view2131821137;

  private View view2131821139;

  private View view2131821114;

  private View view2131820817;

  private View view2131820745;

  @UiThread
  public PersonalInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mainTitle = Utils.findRequiredViewAsType(source, R.id.main_title, "field 'mainTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_img_iv, "field 'headImgIv' and method 'onViewClicked'");
    target.headImgIv = Utils.castView(view, R.id.head_img_iv, "field 'headImgIv'", ImageView.class);
    view2131821117 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headImgRight = Utils.findRequiredViewAsType(source, R.id.head_img_right, "field 'headImgRight'", ImageView.class);
    target.headText = Utils.findRequiredViewAsType(source, R.id.head_text, "field 'headText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_img_btn, "field 'headImgBtn' and method 'onViewClicked'");
    target.headImgBtn = Utils.castView(view, R.id.head_img_btn, "field 'headImgBtn'", RelativeLayout.class);
    view2131821115 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userNameText = Utils.findRequiredViewAsType(source, R.id.user_name_text, "field 'userNameText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.head_name_btn, "field 'headNameBtn' and method 'onViewClicked'");
    target.headNameBtn = Utils.castView(view, R.id.head_name_btn, "field 'headNameBtn'", RelativeLayout.class);
    view2131821078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userSexText = Utils.findRequiredViewAsType(source, R.id.user_sex_text, "field 'userSexText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_sex_btn, "field 'headSexBtn' and method 'onViewClicked'");
    target.headSexBtn = Utils.castView(view, R.id.head_sex_btn, "field 'headSexBtn'", RelativeLayout.class);
    view2131821079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userAgeText = Utils.findRequiredViewAsType(source, R.id.user_age_text, "field 'userAgeText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.head_age_btn, "field 'headAgeBtn' and method 'onViewClicked'");
    target.headAgeBtn = Utils.castView(view, R.id.head_age_btn, "field 'headAgeBtn'", RelativeLayout.class);
    view2131821119 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userTelText = Utils.findRequiredViewAsType(source, R.id.user_tel_text, "field 'userTelText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.head_tel_btn, "field 'headTelBtn' and method 'onViewClicked'");
    target.headTelBtn = Utils.castView(view, R.id.head_tel_btn, "field 'headTelBtn'", RelativeLayout.class);
    view2131821081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userIdText = Utils.findRequiredViewAsType(source, R.id.user_id_text, "field 'userIdText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.head_id_btn, "field 'headIdBtn' and method 'onViewClicked'");
    target.headIdBtn = Utils.castView(view, R.id.head_id_btn, "field 'headIdBtn'", RelativeLayout.class);
    view2131821121 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userMailText = Utils.findRequiredViewAsType(source, R.id.user_mail_text, "field 'userMailText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.head_mail_btn, "field 'headMailBtn' and method 'onViewClicked'");
    target.headMailBtn = Utils.castView(view, R.id.head_mail_btn, "field 'headMailBtn'", RelativeLayout.class);
    view2131821124 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headUserIdText = Utils.findRequiredViewAsType(source, R.id.head_user_id_text, "field 'headUserIdText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_user_id_btn, "field 'headUserIdBtn' and method 'onViewClicked'");
    target.headUserIdBtn = Utils.castView(view, R.id.head_user_id_btn, "field 'headUserIdBtn'", RelativeLayout.class);
    view2131821127 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headUserTypeText = Utils.findRequiredViewAsType(source, R.id.head_user_type_text, "field 'headUserTypeText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_user_type_btn, "field 'headUserTypeBtn' and method 'onViewClicked'");
    target.headUserTypeBtn = Utils.castView(view, R.id.head_user_type_btn, "field 'headUserTypeBtn'", RelativeLayout.class);
    view2131821084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headClubText = Utils.findRequiredViewAsType(source, R.id.head_club_text, "field 'headClubText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_club_btn, "field 'headClubBtn' and method 'onViewClicked'");
    target.headClubBtn = Utils.castView(view, R.id.head_club_btn, "field 'headClubBtn'", RelativeLayout.class);
    view2131821129 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headDepartmentText = Utils.findRequiredViewAsType(source, R.id.head_department_text, "field 'headDepartmentText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_department_btn, "field 'headDepartmentBtn' and method 'onViewClicked'");
    target.headDepartmentBtn = Utils.castView(view, R.id.head_department_btn, "field 'headDepartmentBtn'", RelativeLayout.class);
    view2131821131 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headPositionText = Utils.findRequiredViewAsType(source, R.id.head_position_text, "field 'headPositionText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_position_btn, "field 'headPositionBtn' and method 'onViewClicked'");
    target.headPositionBtn = Utils.castView(view, R.id.head_position_btn, "field 'headPositionBtn'", RelativeLayout.class);
    view2131821133 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headRoleText = Utils.findRequiredViewAsType(source, R.id.head_role_text, "field 'headRoleText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_role_btn, "field 'headRoleBtn' and method 'onViewClicked'");
    target.headRoleBtn = Utils.castView(view, R.id.head_role_btn, "field 'headRoleBtn'", RelativeLayout.class);
    view2131821135 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headHaveText = Utils.findRequiredViewAsType(source, R.id.head_have_text, "field 'headHaveText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_have_btn, "field 'headHaveBtn' and method 'onViewClicked'");
    target.headHaveBtn = Utils.castView(view, R.id.head_have_btn, "field 'headHaveBtn'", RelativeLayout.class);
    view2131821137 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headDropText = Utils.findRequiredViewAsType(source, R.id.head_drop_text, "field 'headDropText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_drop_btn, "field 'headDropBtn' and method 'onViewClicked'");
    target.headDropBtn = Utils.castView(view, R.id.head_drop_btn, "field 'headDropBtn'", RelativeLayout.class);
    view2131821139 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.info_coach_btn, "field 'info_coach_btn' and method 'onViewClicked'");
    target.info_coach_btn = Utils.castView(view, R.id.info_coach_btn, "field 'info_coach_btn'", ImageView.class);
    view2131821114 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_edit, "field 'btnEdit' and method 'onViewClicked'");
    target.btnEdit = Utils.castView(view, R.id.btn_edit, "field 'btnEdit'", TextView.class);
    view2131820817 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_back, "field 'btnBack' and method 'onViewClicked'");
    target.btnBack = Utils.castView(view, R.id.btn_back, "field 'btnBack'", ImageView.class);
    view2131820745 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mainTitle = null;
    target.headImgIv = null;
    target.headImgRight = null;
    target.headText = null;
    target.headImgBtn = null;
    target.userNameText = null;
    target.headNameBtn = null;
    target.userSexText = null;
    target.headSexBtn = null;
    target.userAgeText = null;
    target.headAgeBtn = null;
    target.userTelText = null;
    target.headTelBtn = null;
    target.userIdText = null;
    target.headIdBtn = null;
    target.userMailText = null;
    target.headMailBtn = null;
    target.headUserIdText = null;
    target.headUserIdBtn = null;
    target.headUserTypeText = null;
    target.headUserTypeBtn = null;
    target.headClubText = null;
    target.headClubBtn = null;
    target.headDepartmentText = null;
    target.headDepartmentBtn = null;
    target.headPositionText = null;
    target.headPositionBtn = null;
    target.headRoleText = null;
    target.headRoleBtn = null;
    target.headHaveText = null;
    target.headHaveBtn = null;
    target.headDropText = null;
    target.headDropBtn = null;
    target.info_coach_btn = null;
    target.btnEdit = null;
    target.btnBack = null;

    view2131821117.setOnClickListener(null);
    view2131821117 = null;
    view2131821115.setOnClickListener(null);
    view2131821115 = null;
    view2131821078.setOnClickListener(null);
    view2131821078 = null;
    view2131821079.setOnClickListener(null);
    view2131821079 = null;
    view2131821119.setOnClickListener(null);
    view2131821119 = null;
    view2131821081.setOnClickListener(null);
    view2131821081 = null;
    view2131821121.setOnClickListener(null);
    view2131821121 = null;
    view2131821124.setOnClickListener(null);
    view2131821124 = null;
    view2131821127.setOnClickListener(null);
    view2131821127 = null;
    view2131821084.setOnClickListener(null);
    view2131821084 = null;
    view2131821129.setOnClickListener(null);
    view2131821129 = null;
    view2131821131.setOnClickListener(null);
    view2131821131 = null;
    view2131821133.setOnClickListener(null);
    view2131821133 = null;
    view2131821135.setOnClickListener(null);
    view2131821135 = null;
    view2131821137.setOnClickListener(null);
    view2131821137 = null;
    view2131821139.setOnClickListener(null);
    view2131821139 = null;
    view2131821114.setOnClickListener(null);
    view2131821114 = null;
    view2131820817.setOnClickListener(null);
    view2131820817 = null;
    view2131820745.setOnClickListener(null);
    view2131820745 = null;

    this.target = null;
  }
}
