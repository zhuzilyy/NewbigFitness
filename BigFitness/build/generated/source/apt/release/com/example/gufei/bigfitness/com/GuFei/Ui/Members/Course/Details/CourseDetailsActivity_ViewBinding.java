// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CourseDetailsActivity_ViewBinding<T extends CourseDetailsActivity> implements Unbinder {
  protected T target;

  @UiThread
  public CourseDetailsActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.textState = Utils.findRequiredViewAsType(source, R.id.text_state, "field 'textState'", TextView.class);
    target.appointmentTypeImg = Utils.findRequiredViewAsType(source, R.id.appointment_type_img, "field 'appointmentTypeImg'", ImageView.class);
    target.textNcontract = Utils.findRequiredViewAsType(source, R.id.text_ncontract, "field 'textNcontract'", TextView.class);
    target.appointmentTypeBtn = Utils.findRequiredViewAsType(source, R.id.appointment_type_btn, "field 'appointmentTypeBtn'", RelativeLayout.class);
    target.courseTypeImg = Utils.findRequiredViewAsType(source, R.id.course_type_img, "field 'courseTypeImg'", ImageView.class);
    target.textNoWardrobe = Utils.findRequiredViewAsType(source, R.id.text_no_wardrobe, "field 'textNoWardrobe'", TextView.class);
    target.courseTypeBtn = Utils.findRequiredViewAsType(source, R.id.course_type_btn, "field 'courseTypeBtn'", RelativeLayout.class);
    target.beginVailableImg = Utils.findRequiredViewAsType(source, R.id.begin_vailable_img, "field 'beginVailableImg'", ImageView.class);
    target.textVailable = Utils.findRequiredViewAsType(source, R.id.text_vailable, "field 'textVailable'", TextView.class);
    target.beginVailableBtn = Utils.findRequiredViewAsType(source, R.id.begin_vailable_btn, "field 'beginVailableBtn'", RelativeLayout.class);
    target.beginTimeImg = Utils.findRequiredViewAsType(source, R.id.begin_time_img, "field 'beginTimeImg'", ImageView.class);
    target.beginTimeText = Utils.findRequiredViewAsType(source, R.id.begin_time_text, "field 'beginTimeText'", TextView.class);
    target.beginTimeBtn = Utils.findRequiredViewAsType(source, R.id.begin_time_btn, "field 'beginTimeBtn'", RelativeLayout.class);
    target.endTimeImg = Utils.findRequiredViewAsType(source, R.id.end_time_img, "field 'endTimeImg'", ImageView.class);
    target.endTimeText = Utils.findRequiredViewAsType(source, R.id.end_time_text, "field 'endTimeText'", TextView.class);
    target.endTimeBtn = Utils.findRequiredViewAsType(source, R.id.end_time_btn, "field 'endTimeBtn'", RelativeLayout.class);
    target.remindTimeImg = Utils.findRequiredViewAsType(source, R.id.remind_time_img, "field 'remindTimeImg'", ImageView.class);
    target.textPaidInAmount = Utils.findRequiredViewAsType(source, R.id.text_Paid_in_amount, "field 'textPaidInAmount'", TextView.class);
    target.remindTimeBtn = Utils.findRequiredViewAsType(source, R.id.remind_time_btn, "field 'remindTimeBtn'", RelativeLayout.class);
    target.intervalTimeImg = Utils.findRequiredViewAsType(source, R.id.interval_time_img, "field 'intervalTimeImg'", ImageView.class);
    target.textWardrobeDeposit = Utils.findRequiredViewAsType(source, R.id.text_wardrobe_deposit, "field 'textWardrobeDeposit'", TextView.class);
    target.intervalTimeBtn = Utils.findRequiredViewAsType(source, R.id.interval_time_btn, "field 'intervalTimeBtn'", RelativeLayout.class);
    target.buyTimeImg = Utils.findRequiredViewAsType(source, R.id.buy_time_img, "field 'buyTimeImg'", ImageView.class);
    target.textTimeBuy = Utils.findRequiredViewAsType(source, R.id.text_time_buy, "field 'textTimeBuy'", TextView.class);
    target.buyTimeBtn = Utils.findRequiredViewAsType(source, R.id.buy_time_btn, "field 'buyTimeBtn'", RelativeLayout.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
    target.operatorImg = Utils.findRequiredViewAsType(source, R.id.operator_img, "field 'operatorImg'", ImageView.class);
    target.textOperator = Utils.findRequiredViewAsType(source, R.id.text_operator, "field 'textOperator'", TextView.class);
    target.operatorBtn = Utils.findRequiredViewAsType(source, R.id.operator_btn, "field 'operatorBtn'", RelativeLayout.class);
    target.recyclerviewid = Utils.findRequiredViewAsType(source, R.id.recyclerviewid, "field 'recyclerviewid'", RecyclerView.class);
    target.swiperefreshlayoutid = Utils.findRequiredViewAsType(source, R.id.swiperefreshlayoutid, "field 'swiperefreshlayoutid'", SwipeRefreshLayout.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.textState = null;
    target.appointmentTypeImg = null;
    target.textNcontract = null;
    target.appointmentTypeBtn = null;
    target.courseTypeImg = null;
    target.textNoWardrobe = null;
    target.courseTypeBtn = null;
    target.beginVailableImg = null;
    target.textVailable = null;
    target.beginVailableBtn = null;
    target.beginTimeImg = null;
    target.beginTimeText = null;
    target.beginTimeBtn = null;
    target.endTimeImg = null;
    target.endTimeText = null;
    target.endTimeBtn = null;
    target.remindTimeImg = null;
    target.textPaidInAmount = null;
    target.remindTimeBtn = null;
    target.intervalTimeImg = null;
    target.textWardrobeDeposit = null;
    target.intervalTimeBtn = null;
    target.buyTimeImg = null;
    target.textTimeBuy = null;
    target.buyTimeBtn = null;
    target.detailsNoteText = null;
    target.operatorImg = null;
    target.textOperator = null;
    target.operatorBtn = null;
    target.recyclerviewid = null;
    target.swiperefreshlayoutid = null;
    target.activityAddressDetails = null;

    this.target = null;
  }
}
