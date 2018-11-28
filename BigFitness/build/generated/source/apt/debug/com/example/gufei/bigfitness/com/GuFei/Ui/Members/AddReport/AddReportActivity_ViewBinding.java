// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddReportActivity_ViewBinding<T extends AddReportActivity> implements Unbinder {
  protected T target;

  private View view2131820978;

  private View view2131821160;

  private View view2131820969;

  @UiThread
  public AddReportActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnRelease' and method 'onViewClicked'");
    target.btnRelease = Utils.castView(view, R.id.btn_complete, "field 'btnRelease'", Button.class);
    view2131820978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textCustomerType = Utils.findRequiredViewAsType(source, R.id.text_customer_type, "field 'textCustomerType'", TextView.class);
    view = Utils.findRequiredView(source, R.id.text_time, "field 'textTime' and method 'onViewClicked'");
    target.textTime = Utils.castView(view, R.id.text_time, "field 'textTime'", TextView.class);
    view2131821160 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textCustomerImg = Utils.findRequiredViewAsType(source, R.id.text_customer_img, "field 'textCustomerImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_select_img, "field 'btnSelectImg' and method 'onViewClicked'");
    target.btnSelectImg = Utils.castView(view, R.id.btn_select_img, "field 'btnSelectImg'", ImageView.class);
    view2131820969 = view;
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
    target.btnRelease = null;
    target.textCustomerType = null;
    target.textTime = null;
    target.textCustomerImg = null;
    target.btnSelectImg = null;

    view2131820978.setOnClickListener(null);
    view2131820978 = null;
    view2131821160.setOnClickListener(null);
    view2131821160 = null;
    view2131820969.setOnClickListener(null);
    view2131820969 = null;

    this.target = null;
  }
}
