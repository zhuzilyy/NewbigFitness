// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PublicSeaSearchListActivity_ViewBinding<T extends PublicSeaSearchListActivity> implements Unbinder {
  protected T target;

  private View view2131820980;

  @UiThread
  public PublicSeaSearchListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.searchView, "field 'searchView'", SearchView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820980 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
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
    target.searchView = null;
    target.toolbar = null;
    target.btnComplete = null;

    view2131820980.setOnClickListener(null);
    view2131820980 = null;

    this.target = null;
  }
}
