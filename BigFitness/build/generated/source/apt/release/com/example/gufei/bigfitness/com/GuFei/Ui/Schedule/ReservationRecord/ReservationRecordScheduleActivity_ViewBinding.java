// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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

public class ReservationRecordScheduleActivity_ViewBinding<T extends ReservationRecordScheduleActivity> implements Unbinder {
  protected T target;

  private View view2131820813;

  private View view2131820743;

  private View view2131820815;

  private View view2131820820;

  private View view2131820823;

  private View view2131820826;

  private View view2131820825;

  private View view2131820830;

  private View view2131820780;

  @UiThread
  public ReservationRecordScheduleActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_add_reservation, "field 'btnAddReservation' and method 'onViewClicked'");
    target.btnAddReservation = Utils.castView(view, R.id.btn_add_reservation, "field 'btnAddReservation'", Button.class);
    view2131820813 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.bottomLayout = Utils.findRequiredViewAsType(source, R.id.bottom_layout, "field 'bottomLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_back, "field 'btnBack' and method 'onViewClicked'");
    target.btnBack = Utils.castView(view, R.id.btn_back, "field 'btnBack'", ImageView.class);
    view2131820743 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_edit, "field 'btnEdit' and method 'onViewClicked'");
    target.btnEdit = Utils.castView(view, R.id.btn_edit, "field 'btnEdit'", TextView.class);
    view2131820815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mainTitle = Utils.findRequiredViewAsType(source, R.id.main_title, "field 'mainTitle'", TextView.class);
    target.mainHeadLayout = Utils.findRequiredViewAsType(source, R.id.main_head_layout, "field 'mainHeadLayout'", RelativeLayout.class);
    target.userName = Utils.findRequiredViewAsType(source, R.id.user_name, "field 'userName'", TextView.class);
    target.textUserName = Utils.findRequiredViewAsType(source, R.id.text_user_name, "field 'textUserName'", EditText.class);
    target.appointmentTypeText = Utils.findRequiredViewAsType(source, R.id.appointment_type_text, "field 'appointmentTypeText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.img_appointment_time_begin, "field 'imgAppointmentTimeBegin' and method 'onViewClicked'");
    target.imgAppointmentTimeBegin = Utils.castView(view, R.id.img_appointment_time_begin, "field 'imgAppointmentTimeBegin'", ImageView.class);
    view2131820820 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textAppointmentTimeBegin = Utils.findRequiredViewAsType(source, R.id.text_appointment_time_begin, "field 'textAppointmentTimeBegin'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_appointment_time_end, "field 'imgAppointmentTimeEnd' and method 'onViewClicked'");
    target.imgAppointmentTimeEnd = Utils.castView(view, R.id.img_appointment_time_end, "field 'imgAppointmentTimeEnd'", ImageView.class);
    view2131820823 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textAppointmentTimeEnd = Utils.findRequiredViewAsType(source, R.id.text_appointment_time_end, "field 'textAppointmentTimeEnd'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_appointment, "field 'imgAppointment' and method 'onViewClicked'");
    target.imgAppointment = Utils.castView(view, R.id.img_appointment, "field 'imgAppointment'", ImageView.class);
    view2131820826 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.userResultsText = Utils.findRequiredViewAsType(source, R.id.user_results_text, "field 'userResultsText'", TextView.class);
    target.textResults = Utils.findRequiredViewAsType(source, R.id.text_results, "field 'textResults'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_appointment, "field 'btnAppointment' and method 'onViewClicked'");
    target.btnAppointment = Utils.castView(view, R.id.btn_appointment, "field 'btnAppointment'", RelativeLayout.class);
    view2131820825 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_remind_time, "field 'btnRemindTime' and method 'onViewClicked'");
    target.btnRemindTime = Utils.castView(view, R.id.btn_remind_time, "field 'btnRemindTime'", ImageView.class);
    view2131820830 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textRemindTime = Utils.findRequiredViewAsType(source, R.id.text_remind_time, "field 'textRemindTime'", TextView.class);
    target.time = Utils.findRequiredViewAsType(source, R.id.time, "field 'time'", TextView.class);
    target.textRemindIntervalTime = Utils.findRequiredViewAsType(source, R.id.text_remind_interval_time, "field 'textRemindIntervalTime'", EditText.class);
    target.layoutTime = Utils.findRequiredViewAsType(source, R.id.layout_time, "field 'layoutTime'", RelativeLayout.class);
    target.idLayoutTime = Utils.findRequiredViewAsType(source, R.id.id_layout_time, "field 'idLayoutTime'", LinearLayout.class);
    target.trainingPlan = Utils.findRequiredViewAsType(source, R.id.training_plan, "field 'trainingPlan'", TextView.class);
    target.trainingPlanImg = Utils.findRequiredViewAsType(source, R.id.training_plan_img, "field 'trainingPlanImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_training_plan, "field 'btnTrainingPlan' and method 'onViewClicked'");
    target.btnTrainingPlan = Utils.castView(view, R.id.btn_training_plan, "field 'btnTrainingPlan'", RelativeLayout.class);
    view2131820780 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textTrainingPlan = Utils.findRequiredViewAsType(source, R.id.text_training_plan, "field 'textTrainingPlan'", TextView.class);
    target.layoutTrainingPlan = Utils.findRequiredViewAsType(source, R.id.layout_training_plan, "field 'layoutTrainingPlan'", LinearLayout.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
    target.textDetailsNote = Utils.findRequiredViewAsType(source, R.id.text_details_note, "field 'textDetailsNote'", EditText.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnAddReservation = null;
    target.bottomLayout = null;
    target.btnBack = null;
    target.btnEdit = null;
    target.mainTitle = null;
    target.mainHeadLayout = null;
    target.userName = null;
    target.textUserName = null;
    target.appointmentTypeText = null;
    target.imgAppointmentTimeBegin = null;
    target.textAppointmentTimeBegin = null;
    target.imgAppointmentTimeEnd = null;
    target.textAppointmentTimeEnd = null;
    target.imgAppointment = null;
    target.userResultsText = null;
    target.textResults = null;
    target.btnAppointment = null;
    target.btnRemindTime = null;
    target.textRemindTime = null;
    target.time = null;
    target.textRemindIntervalTime = null;
    target.layoutTime = null;
    target.idLayoutTime = null;
    target.trainingPlan = null;
    target.trainingPlanImg = null;
    target.btnTrainingPlan = null;
    target.textTrainingPlan = null;
    target.layoutTrainingPlan = null;
    target.detailsNoteText = null;
    target.textDetailsNote = null;
    target.recyclerView = null;
    target.activityAddressDetails = null;

    view2131820813.setOnClickListener(null);
    view2131820813 = null;
    view2131820743.setOnClickListener(null);
    view2131820743 = null;
    view2131820815.setOnClickListener(null);
    view2131820815 = null;
    view2131820820.setOnClickListener(null);
    view2131820820 = null;
    view2131820823.setOnClickListener(null);
    view2131820823 = null;
    view2131820826.setOnClickListener(null);
    view2131820826 = null;
    view2131820825.setOnClickListener(null);
    view2131820825 = null;
    view2131820830.setOnClickListener(null);
    view2131820830 = null;
    view2131820780.setOnClickListener(null);
    view2131820780 = null;

    this.target = null;
  }
}
