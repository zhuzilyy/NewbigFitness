// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddFollowActivity_ViewBinding<T extends AddFollowActivity> implements Unbinder {
  protected T target;

  private View view2131820977;

  private View view2131820968;

  @UiThread
  public AddFollowActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnRelease' and method 'onViewClicked'");
    target.btnRelease = Utils.castView(view, R.id.btn_complete, "field 'btnRelease'", Button.class);
    view2131820977 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textCustomerType = Utils.findRequiredViewAsType(source, R.id.text_customer_type, "field 'textCustomerType'", TextView.class);
    target.textCustomerName = Utils.findRequiredViewAsType(source, R.id.text_customer_name, "field 'textCustomerName'", TextView.class);
    target.textCustomerImg = Utils.findRequiredViewAsType(source, R.id.text_customer_img, "field 'textCustomerImg'", ImageView.class);
    target.textContext = Utils.findRequiredViewAsType(source, R.id.text_content, "field 'textContext'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_select_img, "field 'btnSelectImg' and method 'onViewClicked'");
    target.btnSelectImg = Utils.castView(view, R.id.btn_select_img, "field 'btnSelectImg'", ImageView.class);
    view2131820968 = view;
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
    target.textCustomerName = null;
    target.textCustomerImg = null;
    target.textContext = null;
    target.btnSelectImg = null;

    view2131820977.setOnClickListener(null);
    view2131820977 = null;
    view2131820968.setOnClickListener(null);
    view2131820968 = null;

    this.target = null;
  }
}
