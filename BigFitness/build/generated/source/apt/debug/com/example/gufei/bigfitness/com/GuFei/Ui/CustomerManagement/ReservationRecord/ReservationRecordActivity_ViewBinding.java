// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord;

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

public class ReservationRecordActivity_ViewBinding<T extends ReservationRecordActivity> implements Unbinder {
  protected T target;

  private View view2131820815;

  private View view2131820745;

  private View view2131820817;

  private View view2131820832;

  private View view2131820827;

  private View view2131820838;

  private View view2131820821;

  private View view2131820824;

  @UiThread
  public ReservationRecordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.main_title, "field 'tvTitle'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btn_add_reservation, "field 'btnAddReservation' and method 'onViewClicked'");
    target.btnAddReservation = Utils.castView(view, R.id.btn_add_reservation, "field 'btnAddReservation'", Button.class);
    view2131820815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_back, "field 'btnBack' and method 'onViewClicked'");
    target.btnBack = Utils.castView(view, R.id.btn_back, "field 'btnBack'", ImageView.class);
    view2131820745 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_edit, "field 'btnEdit' and method 'onViewClicked'");
    target.btnEdit = Utils.castView(view, R.id.btn_edit, "field 'btnEdit'", TextView.class);
    view2131820817 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textUserName = Utils.findRequiredViewAsType(source, R.id.text_user_name, "field 'textUserName'", TextView.class);
    target.appointmentTypeText = Utils.findRequiredViewAsType(source, R.id.appointment_type_text, "field 'appointmentTypeText'", TextView.class);
    target.textAppointmentTimeBegin = Utils.findRequiredViewAsType(source, R.id.text_appointment_time_begin, "field 'textAppointmentTimeBegin'", TextView.class);
    target.textAppointmentTimeEnd = Utils.findRequiredViewAsType(source, R.id.text_appointment_time_end, "field 'textAppointmentTimeEnd'", TextView.class);
    target.userResultsText = Utils.findRequiredViewAsType(source, R.id.user_results_text, "field 'userResultsText'", TextView.class);
    target.textResults = Utils.findRequiredViewAsType(source, R.id.text_results, "field 'textResults'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_remind_time, "field 'btnRemindTime' and method 'onViewClicked'");
    target.btnRemindTime = Utils.castView(view, R.id.btn_remind_time, "field 'btnRemindTime'", RelativeLayout.class);
    view2131820832 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textRemindTime = Utils.findRequiredViewAsType(source, R.id.text_remind_time, "field 'textRemindTime'", TextView.class);
    target.textRemindIntervalTime = Utils.findRequiredViewAsType(source, R.id.text_remind_interval_time, "field 'textRemindIntervalTime'", TextView.class);
    target.userName = Utils.findRequiredViewAsType(source, R.id.user_name, "field 'userName'", TextView.class);
    target.imgAppointment = Utils.findRequiredViewAsType(source, R.id.img_appointment, "field 'imgAppointment'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_appointment, "field 'btnAppointment' and method 'onViewClicked'");
    target.btnAppointment = Utils.castView(view, R.id.btn_appointment, "field 'btnAppointment'", RelativeLayout.class);
    view2131820827 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.layoutTime = Utils.findRequiredViewAsType(source, R.id.layout_time, "field 'layoutTime'", RelativeLayout.class);
    target.time = Utils.findRequiredViewAsType(source, R.id.time, "field 'time'", TextView.class);
    target.idLayoutTime = Utils.findRequiredViewAsType(source, R.id.id_layout_time, "field 'idLayoutTime'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_appointment_type, "field 'btnAppointmentType' and method 'onViewClicked'");
    target.btnAppointmentType = Utils.castView(view, R.id.btn_appointment_type, "field 'btnAppointmentType'", RelativeLayout.class);
    view2131820838 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_appointment_time_begin, "field 'btnAppointmentTimeBegin' and method 'onViewClicked'");
    target.btnAppointmentTimeBegin = Utils.castView(view, R.id.btn_appointment_time_begin, "field 'btnAppointmentTimeBegin'", RelativeLayout.class);
    view2131820821 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_appointment_time_end, "field 'btnAppointmentTimeEnd' and method 'onViewClicked'");
    target.btnAppointmentTimeEnd = Utils.castView(view, R.id.btn_appointment_time_end, "field 'btnAppointmentTimeEnd'", RelativeLayout.class);
    view2131820824 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.layoutMain = Utils.findRequiredViewAsType(source, R.id.layout_main, "field 'layoutMain'", RelativeLayout.class);
    target.imgAppointmentType = Utils.findRequiredViewAsType(source, R.id.img_appointment_type, "field 'imgAppointmentType'", ImageView.class);
    target.imgAppointmentTimeBegin = Utils.findRequiredViewAsType(source, R.id.img_appointment_time_begin, "field 'imgAppointmentTimeBegin'", ImageView.class);
    target.imgAppointmentTimeEnd = Utils.findRequiredViewAsType(source, R.id.img_appointment_time_end, "field 'imgAppointmentTimeEnd'", ImageView.class);
    target.imgRemindTime = Utils.findRequiredViewAsType(source, R.id.img_remind_time, "field 'imgRemindTime'", ImageView.class);
    target.textDetailsNote = Utils.findRequiredViewAsType(source, R.id.text_details_note, "field 'textDetailsNote'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.recyclerView = null;
    target.btnAddReservation = null;
    target.btnBack = null;
    target.btnEdit = null;
    target.textUserName = null;
    target.appointmentTypeText = null;
    target.textAppointmentTimeBegin = null;
    target.textAppointmentTimeEnd = null;
    target.userResultsText = null;
    target.textResults = null;
    target.btnRemindTime = null;
    target.textRemindTime = null;
    target.textRemindIntervalTime = null;
    target.userName = null;
    target.imgAppointment = null;
    target.btnAppointment = null;
    target.layoutTime = null;
    target.time = null;
    target.idLayoutTime = null;
    target.btnAppointmentType = null;
    target.btnAppointmentTimeBegin = null;
    target.btnAppointmentTimeEnd = null;
    target.layoutMain = null;
    target.imgAppointmentType = null;
    target.imgAppointmentTimeBegin = null;
    target.imgAppointmentTimeEnd = null;
    target.imgRemindTime = null;
    target.textDetailsNote = null;

    view2131820815.setOnClickListener(null);
    view2131820815 = null;
    view2131820745.setOnClickListener(null);
    view2131820745 = null;
    view2131820817.setOnClickListener(null);
    view2131820817 = null;
    view2131820832.setOnClickListener(null);
    view2131820832 = null;
    view2131820827.setOnClickListener(null);
    view2131820827 = null;
    view2131820838.setOnClickListener(null);
    view2131820838 = null;
    view2131820821.setOnClickListener(null);
    view2131820821 = null;
    view2131820824.setOnClickListener(null);
    view2131820824 = null;

    this.target = null;
  }
}
