// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Index2FragMent_ViewBinding<T extends Index2FragMent> implements Unbinder {
  protected T target;

  private View view2131821332;

  @UiThread
  public Index2FragMent_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.bar = Utils.findRequiredViewAsType(source, R.id.bar, "field 'bar'", RelativeLayout.class);
    target.mWebView = Utils.findRequiredViewAsType(source, R.id.webview, "field 'mWebView'", WebView.class);
    target.textTime = Utils.findRequiredViewAsType(source, R.id.text_time, "field 'textTime'", TextView.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.title_spinner, "field 'spinner'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_time, "field 'btnTime' and method 'onViewClicked'");
    target.btnTime = Utils.castView(view, R.id.btn_time, "field 'btnTime'", LinearLayout.class);
    view2131821332 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.textUserName = Utils.findRequiredViewAsType(source, R.id.text_user_name, "field 'textUserName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bar = null;
    target.mWebView = null;
    target.textTime = null;
    target.spinner = null;
    target.btnTime = null;
    target.textUserName = null;

    view2131821332.setOnClickListener(null);
    view2131821332 = null;

    this.target = null;
  }
}
