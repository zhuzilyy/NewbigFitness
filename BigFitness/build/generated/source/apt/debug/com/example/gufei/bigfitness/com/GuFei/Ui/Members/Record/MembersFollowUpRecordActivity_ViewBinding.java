// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MembersFollowUpRecordActivity_ViewBinding<T extends MembersFollowUpRecordActivity> implements Unbinder {
  protected T target;

  private View view2131820827;

  private View view2131821445;

  private View view2131821158;

  private View view2131821448;

  private View view2131821449;

  private View view2131821450;

  @UiThread
  public MembersFollowUpRecordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.textCustomerType = Utils.findRequiredViewAsType(source, R.id.text_customer_type, "field 'textCustomerType'", TextView.class);
    target.textCustomerName = Utils.findRequiredViewAsType(source, R.id.text_customer_name, "field 'textCustomerName'", TextView.class);
    target.textCustomerImg = Utils.findRequiredViewAsType(source, R.id.text_customer_img, "field 'textCustomerImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_appointment, "field 'btnAppointment' and method 'onViewClicked'");
    target.btnAppointment = Utils.castView(view, R.id.btn_appointment, "field 'btnAppointment'", ImageView.class);
    view2131820827 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_customer_info, "field 'btnCustomerInfo' and method 'onViewClicked'");
    target.btnCustomerInfo = Utils.castView(view, R.id.btn_customer_info, "field 'btnCustomerInfo'", ImageView.class);
    view2131821445 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fab, "field 'floatingActionButton' and method 'onViewClicked'");
    target.floatingActionButton = Utils.castView(view, R.id.fab, "field 'floatingActionButton'", FloatingActionButton.class);
    view2131821158 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_report_medical, "field 'btnReportMedical' and method 'onViewClicked'");
    target.btnReportMedical = Utils.castView(view, R.id.btn_report_medical, "field 'btnReportMedical'", LinearLayout.class);
    view2131821448 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_report_appointment, "field 'btnReportAppointment' and method 'onViewClicked'");
    target.btnReportAppointment = Utils.castView(view, R.id.btn_report_appointment, "field 'btnReportAppointment'", LinearLayout.class);
    view2131821449 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_class_record, "field 'btnClassRecord' and method 'onViewClicked'");
    target.btnClassRecord = Utils.castView(view, R.id.btn_class_record, "field 'btnClassRecord'", LinearLayout.class);
    view2131821450 = view;
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

    target.tvTitle = null;
    target.toolbar = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.textCustomerType = null;
    target.textCustomerName = null;
    target.textCustomerImg = null;
    target.btnAppointment = null;
    target.btnCustomerInfo = null;
    target.floatingActionButton = null;
    target.btnReportMedical = null;
    target.btnReportAppointment = null;
    target.btnClassRecord = null;

    view2131820827.setOnClickListener(null);
    view2131820827 = null;
    view2131821445.setOnClickListener(null);
    view2131821445 = null;
    view2131821158.setOnClickListener(null);
    view2131821158 = null;
    view2131821448.setOnClickListener(null);
    view2131821448 = null;
    view2131821449.setOnClickListener(null);
    view2131821449 = null;
    view2131821450.setOnClickListener(null);
    view2131821450 = null;

    this.target = null;
  }
}
