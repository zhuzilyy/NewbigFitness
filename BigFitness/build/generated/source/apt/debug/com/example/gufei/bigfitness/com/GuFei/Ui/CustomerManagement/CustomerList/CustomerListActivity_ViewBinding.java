// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerListActivity_ViewBinding<T extends CustomerListActivity> implements Unbinder {
  protected T target;

  private View view2131821141;

  private View view2131821144;

  private View view2131821430;

  private View view2131821155;

  private View view2131820977;

  private View view2131821149;

  private View view2131821433;

  private View view2131821434;

  private View view2131821435;

  private View view2131821153;

  @UiThread
  public CustomerListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.sorting_btn, "field 'sortingBtn' and method 'onClick'");
    target.sortingBtn = Utils.castView(view, R.id.sorting_btn, "field 'sortingBtn'", RelativeLayout.class);
    view2131821141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.screening_btn, "field 'screeningBtn' and method 'onClick'");
    target.screeningBtn = Utils.castView(view, R.id.screening_btn, "field 'screeningBtn'", RelativeLayout.class);
    view2131821144 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.type_department_btn, "field 'departmentBtn' and method 'onClick'");
    target.departmentBtn = Utils.castView(view, R.id.type_department_btn, "field 'departmentBtn'", RelativeLayout.class);
    view2131821430 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.textDepartment = Utils.findRequiredViewAsType(source, R.id.text_department, "field 'textDepartment'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.searchView, "field 'searchView'", SearchView.class);
    target.sortingImg = Utils.findRequiredViewAsType(source, R.id.sorting_img, "field 'sortingImg'", ImageView.class);
    target.screeningImg = Utils.findRequiredViewAsType(source, R.id.screening_img, "field 'screeningImg'", ImageView.class);
    target.sortingText = Utils.findRequiredViewAsType(source, R.id.sorting_text, "field 'sortingText'", TextView.class);
    target.noRankScreenLayout = Utils.findRequiredViewAsType(source, R.id.no_rank_screen_layout, "field 'noRankScreenLayout'", LinearLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.linearLayoutBottom = Utils.findRequiredViewAsType(source, R.id.layout_edit_bottom, "field 'linearLayoutBottom'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.fab, "field 'floatingActionButton' and method 'onClick'");
    target.floatingActionButton = Utils.castView(view, R.id.fab, "field 'floatingActionButton'", FloatingActionButton.class);
    view2131821155 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnEdit' and method 'onClick'");
    target.btnEdit = Utils.castView(view, R.id.btn_complete, "field 'btnEdit'", Button.class);
    view2131820977 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_selected_all, "field 'btnSelectedAll' and method 'onClick'");
    target.btnSelectedAll = Utils.castView(view, R.id.btn_selected_all, "field 'btnSelectedAll'", CheckBox.class);
    view2131821149 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_thrown_public, "field 'btnThrownPublic' and method 'onClick'");
    target.btnThrownPublic = Utils.castView(view, R.id.btn_thrown_public, "field 'btnThrownPublic'", TextView.class);
    view2131821433 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_Change_membertype, "field 'btnChangeMembertype' and method 'onClick'");
    target.btnChangeMembertype = Utils.castView(view, R.id.btn_Change_membertype, "field 'btnChangeMembertype'", TextView.class);
    view2131821434 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_Change_coachTrack, "field 'btnChangeCoachTrack' and method 'onClick'");
    target.btnChangeCoachTrack = Utils.castView(view, R.id.btn_Change_coachTrack, "field 'btnChangeCoachTrack'", TextView.class);
    view2131821435 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_Change_coachLesson, "field 'btnChangeCoachLesson' and method 'onClick'");
    target.btnChangeCoachLesson = Utils.castView(view, R.id.btn_Change_coachLesson, "field 'btnChangeCoachLesson'", TextView.class);
    view2131821153 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.layoutAlpha = Utils.findRequiredViewAsType(source, R.id.layout_alpha, "field 'layoutAlpha'", LinearLayout.class);
    target.tvNoMore = Utils.findRequiredViewAsType(source, R.id.tv_noMore, "field 'tvNoMore'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.sortingBtn = null;
    target.screeningBtn = null;
    target.departmentBtn = null;
    target.textDepartment = null;
    target.toolbar = null;
    target.searchView = null;
    target.sortingImg = null;
    target.screeningImg = null;
    target.sortingText = null;
    target.noRankScreenLayout = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.linearLayoutBottom = null;
    target.floatingActionButton = null;
    target.btnEdit = null;
    target.btnSelectedAll = null;
    target.btnThrownPublic = null;
    target.btnChangeMembertype = null;
    target.btnChangeCoachTrack = null;
    target.btnChangeCoachLesson = null;
    target.layoutAlpha = null;
    target.tvNoMore = null;

    view2131821141.setOnClickListener(null);
    view2131821141 = null;
    view2131821144.setOnClickListener(null);
    view2131821144 = null;
    view2131821430.setOnClickListener(null);
    view2131821430 = null;
    view2131821155.setOnClickListener(null);
    view2131821155 = null;
    view2131820977.setOnClickListener(null);
    view2131820977 = null;
    view2131821149.setOnClickListener(null);
    view2131821149 = null;
    view2131821433.setOnClickListener(null);
    view2131821433 = null;
    view2131821434.setOnClickListener(null);
    view2131821434 = null;
    view2131821435.setOnClickListener(null);
    view2131821435 = null;
    view2131821153.setOnClickListener(null);
    view2131821153 = null;

    this.target = null;
  }
}
