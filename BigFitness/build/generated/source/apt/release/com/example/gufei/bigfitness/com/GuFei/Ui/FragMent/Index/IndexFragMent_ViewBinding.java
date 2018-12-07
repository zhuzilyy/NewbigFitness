// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class IndexFragMent_ViewBinding<T extends IndexFragMent> implements Unbinder {
  protected T target;

  private View view2131821063;

  private View view2131821228;

  private View view2131821229;

  private View view2131821230;

  private View view2131821231;

  private View view2131821295;

  private View view2131821302;

  private View view2131821307;

  private View view2131821312;

  private View view2131821317;

  private View view2131821323;

  private View view2131821329;

  private View view2131821232;

  @UiThread
  public IndexFragMent_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ScanImg, "field 'ScanBtn' and method 'onClick'");
    target.ScanBtn = Utils.castView(view, R.id.ScanImg, "field 'ScanBtn'", ImageView.class);
    view2131821063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.activityMain = Utils.findRequiredViewAsType(source, R.id.activity_main, "field 'activityMain'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.customer_management_btn, "field 'customerManagementBtn' and method 'onClick'");
    target.customerManagementBtn = Utils.castView(view, R.id.customer_management_btn, "field 'customerManagementBtn'", LinearLayout.class);
    view2131821228 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.member_management_btn, "field 'memberManagementBtn' and method 'onClick'");
    target.memberManagementBtn = Utils.castView(view, R.id.member_management_btn, "field 'memberManagementBtn'", LinearLayout.class);
    view2131821229 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.highseas_management_btn, "field 'highseasManagementBtn' and method 'onClick'");
    target.highseasManagementBtn = Utils.castView(view, R.id.highseas_management_btn, "field 'highseasManagementBtn'", LinearLayout.class);
    view2131821230 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.programme_btn, "field 'programmeBtn' and method 'onClick'");
    target.programmeBtn = Utils.castView(view, R.id.programme_btn, "field 'programmeBtn'", LinearLayout.class);
    view2131821231 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.notice_system_btn, "field 'noticeSystemBtn' and method 'onClick'");
    target.noticeSystemBtn = Utils.castView(view, R.id.notice_system_btn, "field 'noticeSystemBtn'", LinearLayout.class);
    view2131821295 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notice_Due_btn, "field 'noticeDueBtn' and method 'onClick'");
    target.noticeDueBtn = Utils.castView(view, R.id.notice_Due_btn, "field 'noticeDueBtn'", LinearLayout.class);
    view2131821302 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notice_Sign_btn, "field 'noticeSignBtn' and method 'onClick'");
    target.noticeSignBtn = Utils.castView(view, R.id.notice_Sign_btn, "field 'noticeSignBtn'", LinearLayout.class);
    view2131821307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notice_appointment_btn, "field 'noticeAppointmentBtn' and method 'onClick'");
    target.noticeAppointmentBtn = Utils.castView(view, R.id.notice_appointment_btn, "field 'noticeAppointmentBtn'", LinearLayout.class);
    view2131821312 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notice_change_btn, "field 'noticeChangeBtn' and method 'onClick'");
    target.noticeChangeBtn = Utils.castView(view, R.id.notice_change_btn, "field 'noticeChangeBtn'", LinearLayout.class);
    view2131821317 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notice_birthday_btn, "field 'noticeBirthdayBtn' and method 'onClick'");
    target.noticeBirthdayBtn = Utils.castView(view, R.id.notice_birthday_btn, "field 'noticeBirthdayBtn'", LinearLayout.class);
    view2131821323 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.textTitleSystem = Utils.findRequiredViewAsType(source, R.id.text_title_system, "field 'textTitleSystem'", TextView.class);
    target.textTimeSystem = Utils.findRequiredViewAsType(source, R.id.text_time_system, "field 'textTimeSystem'", TextView.class);
    target.msgLayout = Utils.findRequiredViewAsType(source, R.id.msg_layout, "field 'msgLayout'", LinearLayout.class);
    target.textView5 = Utils.findRequiredViewAsType(source, R.id.textView5, "field 'textView5'", TextView.class);
    target.btnHideList = Utils.findRequiredViewAsType(source, R.id.btn_hide_list, "field 'btnHideList'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_list_head, "field 'btnListHead' and method 'onClick'");
    target.btnListHead = Utils.castView(view, R.id.btn_list_head, "field 'btnListHead'", RelativeLayout.class);
    view2131821329 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.numResult = Utils.findRequiredViewAsType(source, R.id.num_result, "field 'numResult'", TextView.class);
    target.layoutBottomResult = Utils.findRequiredViewAsType(source, R.id.layout_bottom_result, "field 'layoutBottomResult'", LinearLayout.class);
    target.numExpireresult = Utils.findRequiredViewAsType(source, R.id.num_expireresult, "field 'numExpireresult'", TextView.class);
    target.titleExpireresult = Utils.findRequiredViewAsType(source, R.id.title_expireresult, "field 'titleExpireresult'", TextView.class);
    target.timeExpireresult = Utils.findRequiredViewAsType(source, R.id.time_expireresult, "field 'timeExpireresult'", TextView.class);
    target.layoutBottomExpireresult = Utils.findRequiredViewAsType(source, R.id.layout_bottom_expireresult, "field 'layoutBottomExpireresult'", LinearLayout.class);
    target.numSignresult = Utils.findRequiredViewAsType(source, R.id.num_signresult, "field 'numSignresult'", TextView.class);
    target.titleSignresult = Utils.findRequiredViewAsType(source, R.id.title_signresult, "field 'titleSignresult'", TextView.class);
    target.timeSignresult = Utils.findRequiredViewAsType(source, R.id.time_signresult, "field 'timeSignresult'", TextView.class);
    target.layoutBottomSignresult = Utils.findRequiredViewAsType(source, R.id.layout_bottom_signresult, "field 'layoutBottomSignresult'", LinearLayout.class);
    target.numAppointmentresult = Utils.findRequiredViewAsType(source, R.id.num_appointmentresult, "field 'numAppointmentresult'", TextView.class);
    target.titleAppointmentresult = Utils.findRequiredViewAsType(source, R.id.title_appointmentresult, "field 'titleAppointmentresult'", TextView.class);
    target.timeAppointmentresult = Utils.findRequiredViewAsType(source, R.id.time_appointmentresult, "field 'timeAppointmentresult'", TextView.class);
    target.layoutBottomAppointmentresult = Utils.findRequiredViewAsType(source, R.id.layout_bottom_appointmentresult, "field 'layoutBottomAppointmentresult'", LinearLayout.class);
    target.numChangeresult = Utils.findRequiredViewAsType(source, R.id.num_changeresult, "field 'numChangeresult'", TextView.class);
    target.titleChangeresult = Utils.findRequiredViewAsType(source, R.id.title_changeresult, "field 'titleChangeresult'", TextView.class);
    target.timeChangeresult = Utils.findRequiredViewAsType(source, R.id.time_changeresult, "field 'timeChangeresult'", TextView.class);
    target.layoutBottomChangeresult = Utils.findRequiredViewAsType(source, R.id.layout_bottom_changeresult, "field 'layoutBottomChangeresult'", LinearLayout.class);
    target.numBirthdayresult = Utils.findRequiredViewAsType(source, R.id.num_birthdayresult, "field 'numBirthdayresult'", TextView.class);
    target.titleBirthdayresult = Utils.findRequiredViewAsType(source, R.id.title_birthdayresult, "field 'titleBirthdayresult'", TextView.class);
    target.timeBirthdayresult = Utils.findRequiredViewAsType(source, R.id.time_birthdayresult, "field 'timeBirthdayresult'", TextView.class);
    target.layoutBottomBirthdayresult = Utils.findRequiredViewAsType(source, R.id.layout_bottom_birthdayresult, "field 'layoutBottomBirthdayresult'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.charts_btn, "field 'chartsBtn' and method 'onClick'");
    target.chartsBtn = Utils.castView(view, R.id.charts_btn, "field 'chartsBtn'", LinearLayout.class);
    view2131821232 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ScanBtn = null;
    target.activityMain = null;
    target.customerManagementBtn = null;
    target.memberManagementBtn = null;
    target.highseasManagementBtn = null;
    target.programmeBtn = null;
    target.recyclerView = null;
    target.noticeSystemBtn = null;
    target.noticeDueBtn = null;
    target.noticeSignBtn = null;
    target.noticeAppointmentBtn = null;
    target.noticeChangeBtn = null;
    target.noticeBirthdayBtn = null;
    target.textTitleSystem = null;
    target.textTimeSystem = null;
    target.msgLayout = null;
    target.textView5 = null;
    target.btnHideList = null;
    target.btnListHead = null;
    target.numResult = null;
    target.layoutBottomResult = null;
    target.numExpireresult = null;
    target.titleExpireresult = null;
    target.timeExpireresult = null;
    target.layoutBottomExpireresult = null;
    target.numSignresult = null;
    target.titleSignresult = null;
    target.timeSignresult = null;
    target.layoutBottomSignresult = null;
    target.numAppointmentresult = null;
    target.titleAppointmentresult = null;
    target.timeAppointmentresult = null;
    target.layoutBottomAppointmentresult = null;
    target.numChangeresult = null;
    target.titleChangeresult = null;
    target.timeChangeresult = null;
    target.layoutBottomChangeresult = null;
    target.numBirthdayresult = null;
    target.titleBirthdayresult = null;
    target.timeBirthdayresult = null;
    target.layoutBottomBirthdayresult = null;
    target.chartsBtn = null;
    target.swipeRefreshLayout = null;

    view2131821063.setOnClickListener(null);
    view2131821063 = null;
    view2131821228.setOnClickListener(null);
    view2131821228 = null;
    view2131821229.setOnClickListener(null);
    view2131821229 = null;
    view2131821230.setOnClickListener(null);
    view2131821230 = null;
    view2131821231.setOnClickListener(null);
    view2131821231 = null;
    view2131821295.setOnClickListener(null);
    view2131821295 = null;
    view2131821302.setOnClickListener(null);
    view2131821302 = null;
    view2131821307.setOnClickListener(null);
    view2131821307 = null;
    view2131821312.setOnClickListener(null);
    view2131821312 = null;
    view2131821317.setOnClickListener(null);
    view2131821317 = null;
    view2131821323.setOnClickListener(null);
    view2131821323 = null;
    view2131821329.setOnClickListener(null);
    view2131821329 = null;
    view2131821232.setOnClickListener(null);
    view2131821232 = null;

    this.target = null;
  }
}
