// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.Login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  private View view2131821055;

  private View view2131821058;

  private View view2131821053;

  @UiThread
  public LoginActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.username = Utils.findRequiredViewAsType(source, R.id.username, "field 'username'", EditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", EditText.class);
    view = Utils.findRequiredView(source, R.id.invisible_password, "field 'invisiblePassword' and method 'onClick'");
    target.invisiblePassword = Utils.castView(view, R.id.invisible_password, "field 'invisiblePassword'", ImageView.class);
    view2131821055 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.remberCheckBox, "field 'remberCheckBox' and method 'onClick'");
    target.remberCheckBox = Utils.castView(view, R.id.remberCheckBox, "field 'remberCheckBox'", CheckBox.class);
    view2131821058 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.login_btn, "field 'loginBtn' and method 'onClick'");
    target.loginBtn = Utils.castView(view, R.id.login_btn, "field 'loginBtn'", Button.class);
    view2131821053 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.username = null;
    target.password = null;
    target.invisiblePassword = null;
    target.remberCheckBox = null;
    target.loginBtn = null;

    view2131821055.setOnClickListener(null);
    view2131821055 = null;
    view2131821058.setOnClickListener(null);
    view2131821058 = null;
    view2131821053.setOnClickListener(null);
    view2131821053 = null;

    this.target = null;
  }
}
