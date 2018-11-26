// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppraiseActivity_ViewBinding<T extends AppraiseActivity> implements Unbinder {
  protected T target;

  private View view2131820797;

  private View view2131820800;

  private View view2131820802;

  private View view2131820804;

  private View view2131820806;

  private View view2131820809;

  @UiThread
  public AppraiseActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.five_star_btn, "field 'fiveStarBtn' and method 'onViewClicked'");
    target.fiveStarBtn = Utils.castView(view, R.id.five_star_btn, "field 'fiveStarBtn'", LinearLayout.class);
    view2131820797 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.four_star_btn, "field 'fourStarBtn' and method 'onViewClicked'");
    target.fourStarBtn = Utils.castView(view, R.id.four_star_btn, "field 'fourStarBtn'", LinearLayout.class);
    view2131820800 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.three_star_btn, "field 'threeStarBtn' and method 'onViewClicked'");
    target.threeStarBtn = Utils.castView(view, R.id.three_star_btn, "field 'threeStarBtn'", LinearLayout.class);
    view2131820802 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.two_star_btn, "field 'twoStarBtn' and method 'onViewClicked'");
    target.twoStarBtn = Utils.castView(view, R.id.two_star_btn, "field 'twoStarBtn'", LinearLayout.class);
    view2131820804 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.one_star_btn, "field 'oneStarBtn' and method 'onViewClicked'");
    target.oneStarBtn = Utils.castView(view, R.id.one_star_btn, "field 'oneStarBtn'", LinearLayout.class);
    view2131820806 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.contentText = Utils.findRequiredViewAsType(source, R.id.content_text, "field 'contentText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.show_all_btn, "field 'showAllBtn' and method 'onViewClicked'");
    target.showAllBtn = Utils.castView(view, R.id.show_all_btn, "field 'showAllBtn'", TextView.class);
    view2131820809 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.fiveStarBtn = null;
    target.fourStarBtn = null;
    target.threeStarBtn = null;
    target.twoStarBtn = null;
    target.oneStarBtn = null;
    target.contentText = null;
    target.showAllBtn = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.tvTitle = null;
    target.toolbar = null;
    target.activityAddressDetails = null;

    view2131820797.setOnClickListener(null);
    view2131820797 = null;
    view2131820800.setOnClickListener(null);
    view2131820800 = null;
    view2131820802.setOnClickListener(null);
    view2131820802 = null;
    view2131820804.setOnClickListener(null);
    view2131820804 = null;
    view2131820806.setOnClickListener(null);
    view2131820806 = null;
    view2131820809.setOnClickListener(null);
    view2131820809 = null;

    this.target = null;
  }
}
