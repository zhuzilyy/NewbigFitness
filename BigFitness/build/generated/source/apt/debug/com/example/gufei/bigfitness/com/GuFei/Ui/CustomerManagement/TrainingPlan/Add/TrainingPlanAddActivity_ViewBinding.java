// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrainingPlanAddActivity_ViewBinding<T extends TrainingPlanAddActivity> implements Unbinder {
  protected T target;

  private View view2131820978;

  private View view2131821183;

  @UiThread
  public TrainingPlanAddActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.activityTrainingPlanAdd = Utils.findRequiredViewAsType(source, R.id.activity_training_plan_add, "field 'activityTrainingPlanAdd'", LinearLayout.class);
    target.textView6 = Utils.findRequiredViewAsType(source, R.id.textView6, "field 'textView6'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn, "field 'btn' and method 'onViewClicked'");
    target.btn = Utils.castView(view, R.id.btn, "field 'btn'", Button.class);
    view2131821183 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.btnComplete = null;
    target.toolbar = null;
    target.recyclerView = null;
    target.activityTrainingPlanAdd = null;
    target.textView6 = null;
    target.btn = null;

    view2131820978.setOnClickListener(null);
    view2131820978 = null;
    view2131821183.setOnClickListener(null);
    view2131821183 = null;

    this.target = null;
  }
}
