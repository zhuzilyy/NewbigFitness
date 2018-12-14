// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class Index4FragMent_ViewBinding<T extends Index4FragMent> implements Unbinder {
  protected T target;

  private View view2131821343;

  @UiThread
  public Index4FragMent_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.bar = Utils.findRequiredViewAsType(source, R.id.bar, "field 'bar'", RelativeLayout.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.title_spinner, "field 'spinner'", Spinner.class);
    target.spinner1 = Utils.findRequiredViewAsType(source, R.id.class_spinner, "field 'spinner1'", Spinner.class);
    target.textTime = Utils.findRequiredViewAsType(source, R.id.text_time, "field 'textTime'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btn_time, "field 'btnTime' and method 'onViewClicked'");
    target.btnTime = Utils.castView(view, R.id.btn_time, "field 'btnTime'", LinearLayout.class);
    view2131821343 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bar = null;
    target.spinner = null;
    target.spinner1 = null;
    target.textTime = null;
    target.recyclerView = null;
    target.btnTime = null;
    target.swipeRefreshLayout = null;

    view2131821343.setOnClickListener(null);
    view2131821343 = null;

    this.target = null;
  }
}
