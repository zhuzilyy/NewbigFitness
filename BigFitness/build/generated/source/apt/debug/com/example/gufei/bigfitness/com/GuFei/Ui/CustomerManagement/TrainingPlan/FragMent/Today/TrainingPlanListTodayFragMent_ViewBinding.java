// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrainingPlanListTodayFragMent_ViewBinding<T extends TrainingPlanListTodayFragMent> implements Unbinder {
  protected T target;

  private View view2131821338;

  @UiThread
  public TrainingPlanListTodayFragMent_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_null_Training_add, "field 'btnNullTrainingAdd' and method 'onViewClicked'");
    target.btnNullTrainingAdd = Utils.castView(view, R.id.btn_null_Training_add, "field 'btnNullTrainingAdd'", LinearLayout.class);
    view2131821338 = view;
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

    target.recyclerView = null;
    target.swipeRefreshLayout = null;
    target.btnNullTrainingAdd = null;

    view2131821338.setOnClickListener(null);
    view2131821338 = null;

    this.target = null;
  }
}
