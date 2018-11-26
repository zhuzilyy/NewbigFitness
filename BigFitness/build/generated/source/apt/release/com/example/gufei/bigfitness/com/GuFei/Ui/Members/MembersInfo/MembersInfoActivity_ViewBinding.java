// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo;

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

public class MembersInfoActivity_ViewBinding<T extends MembersInfoActivity> implements Unbinder {
  protected T target;

  private View view2131821071;

  private View view2131821072;

  private View view2131821073;

  private View view2131821075;

  private View view2131821076;

  private View view2131821078;

  private View view2131821085;

  private View view2131821087;

  private View view2131821089;

  private View view2131821092;

  private View view2131821094;

  private View view2131821096;

  private View view2131821099;

  private View view2131821098;

  private View view2131821102;

  private View view2131821104;

  private View view2131821103;

  private View view2131820977;

  @UiThread
  public MembersInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_card, "field 'btnCard' and method 'onViewClicked'");
    target.btnCard = Utils.castView(view, R.id.btn_card, "field 'btnCard'", LinearLayout.class);
    view2131821071 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_wardrobe, "field 'btnWardrobe' and method 'onViewClicked'");
    target.btnWardrobe = Utils.castView(view, R.id.btn_wardrobe, "field 'btnWardrobe'", LinearLayout.class);
    view2131821072 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_class, "field 'btnClass' and method 'onViewClicked'");
    target.btnClass = Utils.castView(view, R.id.btn_class, "field 'btnClass'", LinearLayout.class);
    view2131821073 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.imgHead = Utils.findRequiredViewAsType(source, R.id.img_head, "field 'imgHead'", ImageView.class);
    target.userNameText = Utils.findRequiredViewAsType(source, R.id.user_name_text, "field 'userNameText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_name_btn, "field 'headNameBtn' and method 'onViewClicked'");
    target.headNameBtn = Utils.castView(view, R.id.head_name_btn, "field 'headNameBtn'", RelativeLayout.class);
    view2131821075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userSexText = Utils.findRequiredViewAsType(source, R.id.user_sex_text, "field 'userSexText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_sex_btn, "field 'headSexBtn' and method 'onViewClicked'");
    target.headSexBtn = Utils.castView(view, R.id.head_sex_btn, "field 'headSexBtn'", RelativeLayout.class);
    view2131821076 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userTelText = Utils.findRequiredViewAsType(source, R.id.user_tel_text, "field 'userTelText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.head_tel_btn, "field 'headTelBtn' and method 'onViewClicked'");
    target.headTelBtn = Utils.castView(view, R.id.head_tel_btn, "field 'headTelBtn'", RelativeLayout.class);
    view2131821078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.headUserTypeText = Utils.findRequiredViewAsType(source, R.id.head_user_type_text, "field 'headUserTypeText'", TextView.class);
    target.headUserTypeBtn = Utils.findRequiredViewAsType(source, R.id.head_user_type_btn, "field 'headUserTypeBtn'", RelativeLayout.class);
    target.userReferencesText = Utils.findRequiredViewAsType(source, R.id.user_references_text, "field 'userReferencesText'", TextView.class);
    target.headReferencesBtn = Utils.findRequiredViewAsType(source, R.id.head_references_btn, "field 'headReferencesBtn'", RelativeLayout.class);
    target.sourceIdText = Utils.findRequiredViewAsType(source, R.id.source_id_text, "field 'sourceIdText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.source_id_btn, "field 'sourceIdBtn' and method 'onViewClicked'");
    target.sourceIdBtn = Utils.castView(view, R.id.source_id_btn, "field 'sourceIdBtn'", RelativeLayout.class);
    view2131821085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userLabelText = Utils.findRequiredViewAsType(source, R.id.user_label_text, "field 'userLabelText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.label_btn, "field 'labelBtn' and method 'onViewClicked'");
    target.labelBtn = Utils.castView(view, R.id.label_btn, "field 'labelBtn'", RelativeLayout.class);
    view2131821087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.memberIntentionImg = Utils.findRequiredViewAsType(source, R.id.member_intention_img, "field 'memberIntentionImg'", ImageView.class);
    target.memberIntentionText = Utils.findRequiredViewAsType(source, R.id.member_intention_text, "field 'memberIntentionText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.member_intention_btn, "field 'memberIntentionBtn' and method 'onViewClicked'");
    target.memberIntentionBtn = Utils.castView(view, R.id.member_intention_btn, "field 'memberIntentionBtn'", RelativeLayout.class);
    view2131821089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textConsultant = Utils.findRequiredViewAsType(source, R.id.text_consultant, "field 'textConsultant'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_consultant, "field 'btnConsultant' and method 'onViewClicked'");
    target.btnConsultant = Utils.castView(view, R.id.btn_consultant, "field 'btnConsultant'", RelativeLayout.class);
    view2131821092 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textCoachPos = Utils.findRequiredViewAsType(source, R.id.text_coach_pos, "field 'textCoachPos'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_coach_pos, "field 'btnCoachPos' and method 'onViewClicked'");
    target.btnCoachPos = Utils.castView(view, R.id.btn_coach_pos, "field 'btnCoachPos'", RelativeLayout.class);
    view2131821094 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textCoachTrack = Utils.findRequiredViewAsType(source, R.id.text_coach_track, "field 'textCoachTrack'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_coach_track, "field 'btnCoachTrack' and method 'onViewClicked'");
    target.btnCoachTrack = Utils.castView(view, R.id.btn_coach_track, "field 'btnCoachTrack'", RelativeLayout.class);
    view2131821096 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.text_follow_time, "field 'textFollowTime' and method 'onViewClicked'");
    target.textFollowTime = Utils.castView(view, R.id.text_follow_time, "field 'textFollowTime'", TextView.class);
    view2131821099 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_follow_time, "field 'btnFollowTime' and method 'onViewClicked'");
    target.btnFollowTime = Utils.castView(view, R.id.btn_follow_time, "field 'btnFollowTime'", RelativeLayout.class);
    view2131821098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textLeft = Utils.findRequiredViewAsType(source, R.id.text_left, "field 'textLeft'", TextView.class);
    target.textNote = Utils.findRequiredViewAsType(source, R.id.text_note, "field 'textNote'", TextView.class);
    target.btnNote = Utils.findRequiredViewAsType(source, R.id.btn_note, "field 'btnNote'", RelativeLayout.class);
    target.textOperator = Utils.findRequiredViewAsType(source, R.id.text_operator, "field 'textOperator'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_operator, "field 'btnOperator' and method 'onViewClicked'");
    target.btnOperator = Utils.castView(view, R.id.btn_operator, "field 'btnOperator'", RelativeLayout.class);
    view2131821102 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.text_operating_time, "field 'textOperatingTime' and method 'onViewClicked'");
    target.textOperatingTime = Utils.castView(view, R.id.text_operating_time, "field 'textOperatingTime'", TextView.class);
    view2131821104 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_operating_time, "field 'btnOperatingTime' and method 'onViewClicked'");
    target.btnOperatingTime = Utils.castView(view, R.id.btn_operating_time, "field 'btnOperatingTime'", RelativeLayout.class);
    view2131821103 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820977 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.activityMembersInfo = Utils.findRequiredViewAsType(source, R.id.activity_members_info, "field 'activityMembersInfo'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnCard = null;
    target.btnWardrobe = null;
    target.btnClass = null;
    target.imgHead = null;
    target.userNameText = null;
    target.headNameBtn = null;
    target.userSexText = null;
    target.headSexBtn = null;
    target.userTelText = null;
    target.headTelBtn = null;
    target.headUserTypeText = null;
    target.headUserTypeBtn = null;
    target.userReferencesText = null;
    target.headReferencesBtn = null;
    target.sourceIdText = null;
    target.sourceIdBtn = null;
    target.userLabelText = null;
    target.labelBtn = null;
    target.memberIntentionImg = null;
    target.memberIntentionText = null;
    target.memberIntentionBtn = null;
    target.textConsultant = null;
    target.btnConsultant = null;
    target.textCoachPos = null;
    target.btnCoachPos = null;
    target.textCoachTrack = null;
    target.btnCoachTrack = null;
    target.textFollowTime = null;
    target.btnFollowTime = null;
    target.textLeft = null;
    target.textNote = null;
    target.btnNote = null;
    target.textOperator = null;
    target.btnOperator = null;
    target.textOperatingTime = null;
    target.btnOperatingTime = null;
    target.tvTitle = null;
    target.btnComplete = null;
    target.toolbar = null;
    target.activityMembersInfo = null;

    view2131821071.setOnClickListener(null);
    view2131821071 = null;
    view2131821072.setOnClickListener(null);
    view2131821072 = null;
    view2131821073.setOnClickListener(null);
    view2131821073 = null;
    view2131821075.setOnClickListener(null);
    view2131821075 = null;
    view2131821076.setOnClickListener(null);
    view2131821076 = null;
    view2131821078.setOnClickListener(null);
    view2131821078 = null;
    view2131821085.setOnClickListener(null);
    view2131821085 = null;
    view2131821087.setOnClickListener(null);
    view2131821087 = null;
    view2131821089.setOnClickListener(null);
    view2131821089 = null;
    view2131821092.setOnClickListener(null);
    view2131821092 = null;
    view2131821094.setOnClickListener(null);
    view2131821094 = null;
    view2131821096.setOnClickListener(null);
    view2131821096 = null;
    view2131821099.setOnClickListener(null);
    view2131821099 = null;
    view2131821098.setOnClickListener(null);
    view2131821098 = null;
    view2131821102.setOnClickListener(null);
    view2131821102 = null;
    view2131821104.setOnClickListener(null);
    view2131821104 = null;
    view2131821103.setOnClickListener(null);
    view2131821103 = null;
    view2131820977.setOnClickListener(null);
    view2131820977 = null;

    this.target = null;
  }
}
