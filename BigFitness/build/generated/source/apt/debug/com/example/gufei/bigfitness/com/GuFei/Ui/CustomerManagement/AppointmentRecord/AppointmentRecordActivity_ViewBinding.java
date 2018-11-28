// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointmentRecordActivity_ViewBinding<T extends AppointmentRecordActivity> implements Unbinder {
  protected T target;

  private View view2131821156;

  @UiThread
  public AppointmentRecordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.textCustomerType = Utils.findRequiredViewAsType(source, R.id.text_customer_type, "field 'textCustomerType'", TextView.class);
    target.textCustomerName = Utils.findRequiredViewAsType(source, R.id.text_customer_name, "field 'textCustomerName'", TextView.class);
    target.textCustomerImg = Utils.findRequiredViewAsType(source, R.id.text_customer_img, "field 'textCustomerImg'", ImageView.class);
    target.btnAppointment = Utils.findRequiredViewAsType(source, R.id.btn_appointment, "field 'btnAppointment'", ImageView.class);
    target.btnCustomerInfo = Utils.findRequiredViewAsType(source, R.id.btn_customer_info, "field 'btnCustomerInfo'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'onViewClicked'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", FloatingActionButton.class);
    view2131821156 = view;
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
    target.fab = null;

    view2131821156.setOnClickListener(null);
    view2131821156 = null;

    this.target = null;
  }
}
