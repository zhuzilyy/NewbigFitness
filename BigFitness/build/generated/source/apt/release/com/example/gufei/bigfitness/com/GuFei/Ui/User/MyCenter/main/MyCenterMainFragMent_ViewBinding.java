// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyCenterMainFragMent_ViewBinding<T extends MyCenterMainFragMent> implements Unbinder {
  protected T target;

  private View view2131821106;

  private View view2131821110;

  @UiThread
  public MyCenterMainFragMent_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.my_center_btn, "field 'myCenterBtn' and method 'onViewClicked'");
    target.myCenterBtn = Utils.castView(view, R.id.my_center_btn, "field 'myCenterBtn'", ImageView.class);
    view2131821106 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.seting_btn, "field 'setingBtn' and method 'onViewClicked'");
    target.setingBtn = Utils.castView(view, R.id.seting_btn, "field 'setingBtn'", LinearLayout.class);
    view2131821110 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.itemTxtName = Utils.findRequiredViewAsType(source, R.id.item_txt_name, "field 'itemTxtName'", TextView.class);
    target.itemTxtSex = Utils.findRequiredViewAsType(source, R.id.item_txt_sex, "field 'itemTxtSex'", TextView.class);
    target.itemTxtPosition = Utils.findRequiredViewAsType(source, R.id.item_txt_position, "field 'itemTxtPosition'", TextView.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.myCenterBtn = null;
    target.setingBtn = null;
    target.itemTxtName = null;
    target.itemTxtSex = null;
    target.itemTxtPosition = null;
    target.activityAddressDetails = null;

    view2131821106.setOnClickListener(null);
    view2131821106 = null;
    view2131821110.setOnClickListener(null);
    view2131821110 = null;

    this.target = null;
  }
}
