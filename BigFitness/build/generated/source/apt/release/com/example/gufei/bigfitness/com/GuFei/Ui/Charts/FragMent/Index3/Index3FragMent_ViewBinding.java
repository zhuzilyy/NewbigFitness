// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3;

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
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Index3FragMent_ViewBinding<T extends Index3FragMent> implements Unbinder {
  protected T target;

  @UiThread
  public Index3FragMent_ViewBinding(T target, View source) {
    this.target = target;

    target.bar = Utils.findRequiredViewAsType(source, R.id.bar, "field 'bar'", RelativeLayout.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.title_spinner, "field 'spinner'", Spinner.class);
    target.btnTime = Utils.findRequiredViewAsType(source, R.id.btn_time, "field 'btnTime'", LinearLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.textUserName = Utils.findRequiredViewAsType(source, R.id.text_user_name, "field 'textUserName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bar = null;
    target.spinner = null;
    target.btnTime = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.textUserName = null;

    this.target = null;
  }
}
