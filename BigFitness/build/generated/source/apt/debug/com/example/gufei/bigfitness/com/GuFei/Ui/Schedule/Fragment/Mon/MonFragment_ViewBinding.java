// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.horizontalexpcalendar.HorizontalExpCalendar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MonFragment_ViewBinding<T extends MonFragment> implements Unbinder {
  protected T target;

  private View view2131820980;

  @UiThread
  public MonFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.horizontalExpCalendar = Utils.findRequiredViewAsType(source, R.id.calendar, "field 'horizontalExpCalendar'", HorizontalExpCalendar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820980 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.btnBack = Utils.findRequiredViewAsType(source, R.id.btn_back, "field 'btnBack'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.horizontalExpCalendar = null;
    target.recyclerView = null;
    target.title = null;
    target.btnComplete = null;
    target.toolbar = null;
    target.btnBack = null;

    view2131820980.setOnClickListener(null);
    view2131820980 = null;

    this.target = null;
  }
}
