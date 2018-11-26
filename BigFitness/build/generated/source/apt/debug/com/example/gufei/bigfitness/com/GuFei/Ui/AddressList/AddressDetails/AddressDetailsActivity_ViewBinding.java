// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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

public class AddressDetailsActivity_ViewBinding<T extends AddressDetailsActivity> implements Unbinder {
  protected T target;

  private View view2131820743;

  private View view2131820748;

  private View view2131820749;

  @UiThread
  public AddressDetailsActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_back, "field 'btnBack' and method 'onViewClicked'");
    target.btnBack = Utils.castView(view, R.id.btn_back, "field 'btnBack'", ImageView.class);
    view2131820743 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.itemPhoneTxtName = Utils.findRequiredViewAsType(source, R.id.item_phone_txt_name, "field 'itemPhoneTxtName'", TextView.class);
    target.itemPhoneTxtPosition = Utils.findRequiredViewAsType(source, R.id.item_phone_txt_position, "field 'itemPhoneTxtPosition'", TextView.class);
    target.tel = Utils.findRequiredViewAsType(source, R.id.tel, "field 'tel'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_msg, "field 'btnMsg' and method 'onViewClicked'");
    target.btnMsg = Utils.castView(view, R.id.btn_msg, "field 'btnMsg'", ImageView.class);
    view2131820748 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_tel, "field 'btnTel' and method 'onViewClicked'");
    target.btnTel = Utils.castView(view, R.id.btn_tel, "field 'btnTel'", ImageView.class);
    view2131820749 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.departtext = Utils.findRequiredViewAsType(source, R.id.departtext, "field 'departtext'", TextView.class);
    target.headImg = Utils.findRequiredViewAsType(source, R.id.head_img, "field 'headImg'", ImageView.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnBack = null;
    target.itemPhoneTxtName = null;
    target.itemPhoneTxtPosition = null;
    target.tel = null;
    target.btnMsg = null;
    target.btnTel = null;
    target.departtext = null;
    target.headImg = null;
    target.activityAddressDetails = null;

    view2131820743.setOnClickListener(null);
    view2131820743 = null;
    view2131820748.setOnClickListener(null);
    view2131820748 = null;
    view2131820749.setOnClickListener(null);
    view2131820749 = null;

    this.target = null;
  }
}
