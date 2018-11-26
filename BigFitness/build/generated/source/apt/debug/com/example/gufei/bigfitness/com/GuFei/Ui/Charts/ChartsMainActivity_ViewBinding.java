// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Charts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChartsMainActivity_ViewBinding<T extends ChartsMainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ChartsMainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.vp_main, "field 'mViewPager'", ViewPager.class);
    target.mTabLayout = Utils.findRequiredViewAsType(source, R.id.tab_main, "field 'mTabLayout'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mViewPager = null;
    target.mTabLayout = null;

    this.target = null;
  }
}
