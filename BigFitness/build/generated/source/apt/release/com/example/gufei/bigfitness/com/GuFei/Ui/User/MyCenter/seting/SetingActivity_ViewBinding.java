// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetingActivity_ViewBinding<T extends SetingActivity> implements Unbinder {
  protected T target;

  private View view2131821175;

  private View view2131821176;

  private View view2131821177;

  @UiThread
  public SetingActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.change_password_btn, "field 'changePasswordBtn' and method 'onViewClicked'");
    target.changePasswordBtn = Utils.castView(view, R.id.change_password_btn, "field 'changePasswordBtn'", TextView.class);
    view2131821175 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.about_btn, "field 'aboutBtn' and method 'onViewClicked'");
    target.aboutBtn = Utils.castView(view, R.id.about_btn, "field 'aboutBtn'", TextView.class);
    view2131821176 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.login_out_btn, "field 'loginOutBtn' and method 'onViewClicked'");
    target.loginOutBtn = Utils.castView(view, R.id.login_out_btn, "field 'loginOutBtn'", Button.class);
    view2131821177 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.changePasswordBtn = null;
    target.aboutBtn = null;
    target.loginOutBtn = null;
    target.activityAddressDetails = null;

    view2131821175.setOnClickListener(null);
    view2131821175 = null;
    view2131821176.setOnClickListener(null);
    view2131821176 = null;
    view2131821177.setOnClickListener(null);
    view2131821177 = null;

    this.target = null;
  }
}
