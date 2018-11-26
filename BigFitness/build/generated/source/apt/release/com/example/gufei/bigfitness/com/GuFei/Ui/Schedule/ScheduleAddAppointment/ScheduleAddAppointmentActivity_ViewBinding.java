// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScheduleAddAppointmentActivity_ViewBinding<T extends ScheduleAddAppointmentActivity> implements Unbinder {
  protected T target;

  private View view2131820761;

  private View view2131820770;

  private View view2131820773;

  private View view2131820776;

  private View view2131820767;

  private View view2131820757;

  private View view2131820780;

  private View view2131820783;

  @UiThread
  public ScheduleAddAppointmentActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
    target.beginTimeText = Utils.findRequiredViewAsType(source, R.id.begin_time_text, "field 'beginTimeText'", TextView.class);
    target.endTimeText = Utils.findRequiredViewAsType(source, R.id.end_time_text, "field 'endTimeText'", TextView.class);
    target.remindTimeText = Utils.findRequiredViewAsType(source, R.id.remind_time_text, "field 'remindTimeText'", TextView.class);
    target.intervalTimeText = Utils.findRequiredViewAsType(source, R.id.interval_time_text, "field 'intervalTimeText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.appointment_type_btn, "field 'appointmentTypeBtn' and method 'onViewClicked'");
    target.appointmentTypeBtn = Utils.castView(view, R.id.appointment_type_btn, "field 'appointmentTypeBtn'", RelativeLayout.class);
    view2131820761 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.end_time_btn, "field 'endTimeBtn' and method 'onViewClicked'");
    target.endTimeBtn = Utils.castView(view, R.id.end_time_btn, "field 'endTimeBtn'", RelativeLayout.class);
    view2131820770 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.remind_time_btn, "field 'remindTimeBtn' and method 'onViewClicked'");
    target.remindTimeBtn = Utils.castView(view, R.id.remind_time_btn, "field 'remindTimeBtn'", RelativeLayout.class);
    view2131820773 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.interval_time_btn, "field 'intervalTimeBtn' and method 'onViewClicked'");
    target.intervalTimeBtn = Utils.castView(view, R.id.interval_time_btn, "field 'intervalTimeBtn'", RelativeLayout.class);
    view2131820776 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.begin_time_btn, "field 'beginTimeBtn' and method 'onViewClicked'");
    target.beginTimeBtn = Utils.castView(view, R.id.begin_time_btn, "field 'beginTimeBtn'", RelativeLayout.class);
    view2131820767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.layoutTrainingPlan = Utils.findRequiredViewAsType(source, R.id.layout_training_plan, "field 'layoutTrainingPlan'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_confirm, "field 'btnConfirm' and method 'onViewClicked'");
    target.btnConfirm = Utils.castView(view, R.id.btn_confirm, "field 'btnConfirm'", TextView.class);
    view2131820757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.appointmentTypeText = Utils.findRequiredViewAsType(source, R.id.appointment_type_text, "field 'appointmentTypeText'", TextView.class);
    target.textNameUser = Utils.findRequiredViewAsType(source, R.id.text_name_user, "field 'textNameUser'", TextView.class);
    target.trainingPlan = Utils.findRequiredViewAsType(source, R.id.training_plan, "field 'trainingPlan'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_training_plan, "field 'btnTrainingPlan' and method 'onViewClicked'");
    target.btnTrainingPlan = Utils.castView(view, R.id.btn_training_plan, "field 'btnTrainingPlan'", RelativeLayout.class);
    view2131820780 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.beginTimeImg = Utils.findRequiredViewAsType(source, R.id.begin_time_img, "field 'beginTimeImg'", ImageView.class);
    target.endTimeImg = Utils.findRequiredViewAsType(source, R.id.end_time_img, "field 'endTimeImg'", ImageView.class);
    target.remindTimeImg = Utils.findRequiredViewAsType(source, R.id.remind_time_img, "field 'remindTimeImg'", ImageView.class);
    target.intervalTimeImg = Utils.findRequiredViewAsType(source, R.id.interval_time_img, "field 'intervalTimeImg'", ImageView.class);
    target.trainingPlanImg = Utils.findRequiredViewAsType(source, R.id.training_plan_img, "field 'trainingPlanImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.text_training_plan, "field 'textTrainingPlan' and method 'onViewClicked'");
    target.textTrainingPlan = Utils.castView(view, R.id.text_training_plan, "field 'textTrainingPlan'", TextView.class);
    view2131820783 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.textNote = Utils.findRequiredViewAsType(source, R.id.text_note, "field 'textNote'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.detailsNoteText = null;
    target.beginTimeText = null;
    target.endTimeText = null;
    target.remindTimeText = null;
    target.intervalTimeText = null;
    target.appointmentTypeBtn = null;
    target.endTimeBtn = null;
    target.remindTimeBtn = null;
    target.intervalTimeBtn = null;
    target.beginTimeBtn = null;
    target.layoutTrainingPlan = null;
    target.btnConfirm = null;
    target.appointmentTypeText = null;
    target.textNameUser = null;
    target.trainingPlan = null;
    target.btnTrainingPlan = null;
    target.beginTimeImg = null;
    target.endTimeImg = null;
    target.remindTimeImg = null;
    target.intervalTimeImg = null;
    target.trainingPlanImg = null;
    target.textTrainingPlan = null;
    target.textNote = null;

    view2131820761.setOnClickListener(null);
    view2131820761 = null;
    view2131820770.setOnClickListener(null);
    view2131820770 = null;
    view2131820773.setOnClickListener(null);
    view2131820773 = null;
    view2131820776.setOnClickListener(null);
    view2131820776 = null;
    view2131820767.setOnClickListener(null);
    view2131820767 = null;
    view2131820757.setOnClickListener(null);
    view2131820757 = null;
    view2131820780.setOnClickListener(null);
    view2131820780 = null;
    view2131820783.setOnClickListener(null);
    view2131820783 = null;

    this.target = null;
  }
}
