// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChartsListActivity_ViewBinding<T extends ChartsListActivity> implements Unbinder {
  protected T target;

  private View view2131821142;

  private View view2131821145;

  @UiThread
  public ChartsListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.sorting_btn, "field 'sortingBtn' and method 'onClick'");
    target.sortingBtn = Utils.castView(view, R.id.sorting_btn, "field 'sortingBtn'", RelativeLayout.class);
    view2131821142 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.screening_btn, "field 'screeningBtn' and method 'onClick'");
    target.screeningBtn = Utils.castView(view, R.id.screening_btn, "field 'screeningBtn'", RelativeLayout.class);
    view2131821145 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.sortingImg = Utils.findRequiredViewAsType(source, R.id.sorting_img, "field 'sortingImg'", ImageView.class);
    target.screeningImg = Utils.findRequiredViewAsType(source, R.id.screening_img, "field 'screeningImg'", ImageView.class);
    target.sortingText = Utils.findRequiredViewAsType(source, R.id.sorting_text, "field 'sortingText'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.titleNum = Utils.findRequiredViewAsType(source, R.id.title_num, "field 'titleNum'", TextView.class);
    target.layoutAlpha = Utils.findRequiredViewAsType(source, R.id.layout_alpha, "field 'layoutAlpha'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.sortingBtn = null;
    target.screeningBtn = null;
    target.toolbar = null;
    target.sortingImg = null;
    target.screeningImg = null;
    target.sortingText = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.tvTitle = null;
    target.titleNum = null;
    target.layoutAlpha = null;

    view2131821142.setOnClickListener(null);
    view2131821142 = null;
    view2131821145.setOnClickListener(null);
    view2131821145 = null;

    this.target = null;
  }
}
