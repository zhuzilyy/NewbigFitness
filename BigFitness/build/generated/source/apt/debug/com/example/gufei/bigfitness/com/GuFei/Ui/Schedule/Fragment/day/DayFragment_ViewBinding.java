// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import com.guojunustb.library.WeekDayView;
import com.guojunustb.library.WeekHeaderView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DayFragment_ViewBinding<T extends DayFragment> implements Unbinder {
  protected T target;

  private View view2131820978;

  @UiThread
  public DayFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mWeekHeaderView = Utils.findRequiredViewAsType(source, R.id.weekheaderview, "field 'mWeekHeaderView'", WeekHeaderView.class);
    target.mWeekView = Utils.findRequiredViewAsType(source, R.id.weekdayview, "field 'mWeekView'", WeekDayView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.btnBack = Utils.findRequiredViewAsType(source, R.id.btn_back, "field 'btnBack'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mWeekHeaderView = null;
    target.mWeekView = null;
    target.title = null;
    target.btnComplete = null;
    target.btnBack = null;

    view2131820978.setOnClickListener(null);
    view2131820978 = null;

    this.target = null;
  }
}
