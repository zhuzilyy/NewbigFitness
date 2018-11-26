// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MessagesListActivity_ViewBinding<T extends MessagesListActivity> implements Unbinder {
  protected T target;

  private View viewSource;

  @UiThread
  public MessagesListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.spinnerSelect = Utils.findRequiredViewAsType(source, R.id.spinner_select, "field 'spinnerSelect'", Spinner.class);
    target.titletext = Utils.findRequiredViewAsType(source, R.id.titletext, "field 'titletext'", TextView.class);
    target.ScanImg = Utils.findRequiredViewAsType(source, R.id.ScanImg, "field 'ScanImg'", ImageView.class);
    target.mainHeadLayout = Utils.findRequiredViewAsType(source, R.id.main_head_layout, "field 'mainHeadLayout'", RelativeLayout.class);
    target.activityMain = Utils.findRequiredViewAsType(source, R.id.activity_main, "field 'activityMain'", RelativeLayout.class);
    target.tvNoMore = Utils.findRequiredViewAsType(source, R.id.tv_noMore, "field 'tvNoMore'", TextView.class);
    viewSource = source;
    source.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.spinnerSelect = null;
    target.titletext = null;
    target.ScanImg = null;
    target.mainHeadLayout = null;
    target.activityMain = null;
    target.tvNoMore = null;

    viewSource.setOnClickListener(null);
    viewSource = null;

    this.target = null;
  }
}
