// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.component.CustomViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScheduleActivity_ViewBinding<T extends ScheduleActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ScheduleActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.vp_main, "field 'mViewPager'", CustomViewPager.class);
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
