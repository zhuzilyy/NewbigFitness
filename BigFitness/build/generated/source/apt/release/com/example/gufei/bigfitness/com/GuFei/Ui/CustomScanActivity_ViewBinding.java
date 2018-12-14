// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomScanActivity_ViewBinding<T extends CustomScanActivity> implements Unbinder {
  protected T target;

  private View view2131820906;

  @UiThread
  public CustomScanActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.dbvCustom = Utils.findRequiredViewAsType(source, R.id.dbv_custom, "field 'dbvCustom'", DecoratedBarcodeView.class);
    view = Utils.findRequiredView(source, R.id.btn_switch, "field 'btnSwitch' and method 'onViewClicked'");
    target.btnSwitch = Utils.castView(view, R.id.btn_switch, "field 'btnSwitch'", Button.class);
    view2131820906 = view;
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

    target.dbvCustom = null;
    target.btnSwitch = null;

    view2131820906.setOnClickListener(null);
    view2131820906 = null;

    this.target = null;
  }
}
