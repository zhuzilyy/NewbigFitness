// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List;

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
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PublicSeaListActivity_ViewBinding<T extends PublicSeaListActivity> implements Unbinder {
  protected T target;

  private View view2131821141;

  private View view2131821144;

  private View view2131820815;

  private View view2131821140;

  private View view2131821150;

  private View view2131821151;

  private View view2131821152;

  private View view2131821153;

  private View view2131821149;

  @UiThread
  public PublicSeaListActivity_ViewBinding(final T target, View source) {
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
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.sp_title, "field 'title'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_edit, "field 'BtnEdit' and method 'onClick'");
    target.BtnEdit = Utils.castView(view, R.id.btn_edit, "field 'BtnEdit'", Button.class);
    view2131820815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_search, "field 'search' and method 'onClick'");
    target.search = Utils.castView(view, R.id.img_search, "field 'search'", ImageView.class);
    view2131821140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.layoutKeep0ut = Utils.findRequiredViewAsType(source, R.id.layout_keep_out, "field 'layoutKeep0ut'", RelativeLayout.class);
    target.sortingImg = Utils.findRequiredViewAsType(source, R.id.sorting_img, "field 'sortingImg'", ImageView.class);
    target.screeningImg = Utils.findRequiredViewAsType(source, R.id.screening_img, "field 'screeningImg'", ImageView.class);
    target.sortingText = Utils.findRequiredViewAsType(source, R.id.sorting_text, "field 'sortingText'", TextView.class);
    target.noRankScreenLayout = Utils.findRequiredViewAsType(source, R.id.no_rank_screen_layout, "field 'noRankScreenLayout'", LinearLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_gain_publicsea, "field 'btnGainPublicsea' and method 'onClick'");
    target.btnGainPublicsea = Utils.castView(view, R.id.btn_gain_publicsea, "field 'btnGainPublicsea'", TextView.class);
    view2131821150 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_Change_publicStype, "field 'btnChangePublicStype' and method 'onClick'");
    target.btnChangePublicStype = Utils.castView(view, R.id.btn_Change_publicStype, "field 'btnChangePublicStype'", TextView.class);
    view2131821151 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_Change_OwnManager, "field 'btnChangeOwnManager' and method 'onClick'");
    target.btnChangeOwnManager = Utils.castView(view, R.id.btn_Change_OwnManager, "field 'btnChangeOwnManager'", TextView.class);
    view2131821152 = view;
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
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.layoutEditBottom = Utils.findRequiredViewAsType(source, R.id.layout_edit_bottom, "field 'layoutEditBottom'", RelativeLayout.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", FloatingActionButton.class);
    view = Utils.findRequiredView(source, R.id.btn_selected_all, "field 'btnSelectedAll' and method 'onClick'");
    target.btnSelectedAll = Utils.castView(view, R.id.btn_selected_all, "field 'btnSelectedAll'", CheckBox.class);
    view2131821149 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
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
    target.title = null;
    target.BtnEdit = null;
    target.search = null;
    target.layoutKeep0ut = null;
    target.sortingImg = null;
    target.screeningImg = null;
    target.sortingText = null;
    target.noRankScreenLayout = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.btnGainPublicsea = null;
    target.btnChangePublicStype = null;
    target.btnChangeOwnManager = null;
    target.btnChangeCoachLesson = null;
    target.textTitle = null;
    target.layoutEditBottom = null;
    target.fab = null;
    target.btnSelectedAll = null;
    target.layoutAlpha = null;

    view2131821141.setOnClickListener(null);
    view2131821141 = null;
    view2131821144.setOnClickListener(null);
    view2131821144 = null;
    view2131820815.setOnClickListener(null);
    view2131820815 = null;
    view2131821140.setOnClickListener(null);
    view2131821140 = null;
    view2131821150.setOnClickListener(null);
    view2131821150 = null;
    view2131821151.setOnClickListener(null);
    view2131821151 = null;
    view2131821152.setOnClickListener(null);
    view2131821152 = null;
    view2131821153.setOnClickListener(null);
    view2131821153 = null;
    view2131821149.setOnClickListener(null);
    view2131821149 = null;

    this.target = null;
  }
}
