// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerMainActivity_ViewBinding<T extends CustomerMainActivity> implements Unbinder {
  protected T target;

  private View view2131820950;

  private View view2131820951;

  private View view2131820952;

  @UiThread
  public CustomerMainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.customer_acquisition_btn, "field 'customerAcquisitionBtn' and method 'onClick'");
    target.customerAcquisitionBtn = Utils.castView(view, R.id.customer_acquisition_btn, "field 'customerAcquisitionBtn'", LinearLayout.class);
    view2131820950 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.customer_list_btn, "field 'customerListBtn' and method 'onClick'");
    target.customerListBtn = Utils.castView(view, R.id.customer_list_btn, "field 'customerListBtn'", LinearLayout.class);
    view2131820951 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.non_members_list_btn, "field 'nonMembersListBtn' and method 'onClick'");
    target.nonMembersListBtn = Utils.castView(view, R.id.non_members_list_btn, "field 'nonMembersListBtn'", LinearLayout.class);
    view2131820952 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.customerAcquisitionBtn = null;
    target.customerListBtn = null;
    target.nonMembersListBtn = null;
    target.tvTitle = null;
    target.toolbar = null;

    view2131820950.setOnClickListener(null);
    view2131820950 = null;
    view2131820951.setOnClickListener(null);
    view2131820951 = null;
    view2131820952.setOnClickListener(null);
    view2131820952 = null;

    this.target = null;
  }
}
