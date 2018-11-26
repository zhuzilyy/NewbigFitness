// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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

public class LessonReportDocumentsListActivity_ViewBinding<T extends LessonReportDocumentsListActivity> implements Unbinder {
  protected T target;

  private View view2131821022;

  private View view2131821021;

  @UiThread
  public LessonReportDocumentsListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_screen, "field 'btnScreen' and method 'onViewClicked'");
    target.btnScreen = Utils.castView(view, R.id.btn_screen, "field 'btnScreen'", ImageView.class);
    view2131821022 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNoMore = Utils.findRequiredViewAsType(source, R.id.tv_noMore, "field 'tvNoMore'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_up_img, "method 'onViewClicked'");
    view2131821021 = view;
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
    target.btnScreen = null;
    target.tvNoMore = null;

    view2131821022.setOnClickListener(null);
    view2131821022 = null;
    view2131821021.setOnClickListener(null);
    view2131821021 = null;

    this.target = null;
  }
}
