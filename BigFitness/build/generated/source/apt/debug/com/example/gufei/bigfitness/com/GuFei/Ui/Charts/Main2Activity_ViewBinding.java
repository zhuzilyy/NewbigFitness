// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Charts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.util.MyViewPager.MyViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Main2Activity_ViewBinding<T extends Main2Activity> implements Unbinder {
  protected T target;

  @UiThread
  public Main2Activity_ViewBinding(T target, View source) {
    this.target = target;

    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.vp_main, "field 'mViewPager'", MyViewPager.class);
    target.mTabLayout = Utils.findRequiredViewAsType(source, R.id.tab_main, "field 'mTabLayout'", TabLayout.class);
    target.LeftBtn = Utils.findRequiredViewAsType(source, R.id.ScanImg, "field 'LeftBtn'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mViewPager = null;
    target.mTabLayout = null;
    target.LeftBtn = null;

    this.target = null;
  }
}
