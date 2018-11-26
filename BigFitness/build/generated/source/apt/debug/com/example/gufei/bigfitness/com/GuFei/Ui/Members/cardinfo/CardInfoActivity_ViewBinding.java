// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo;

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

public class CardInfoActivity_ViewBinding<T extends CardInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public CardInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.stateImg = Utils.findRequiredViewAsType(source, R.id.state_img, "field 'stateImg'", ImageView.class);
    target.textState = Utils.findRequiredViewAsType(source, R.id.text_state, "field 'textState'", TextView.class);
    target.appointmentTypeImg = Utils.findRequiredViewAsType(source, R.id.appointment_type_img, "field 'appointmentTypeImg'", ImageView.class);
    target.textNcontract = Utils.findRequiredViewAsType(source, R.id.text_ncontract, "field 'textNcontract'", TextView.class);
    target.appointmentTypeBtn = Utils.findRequiredViewAsType(source, R.id.appointment_type_btn, "field 'appointmentTypeBtn'", RelativeLayout.class);
    target.courseTypeImg = Utils.findRequiredViewAsType(source, R.id.course_type_img, "field 'courseTypeImg'", ImageView.class);
    target.textNoCard = Utils.findRequiredViewAsType(source, R.id.text_no_card, "field 'textNoCard'", TextView.class);
    target.courseTypeBtn = Utils.findRequiredViewAsType(source, R.id.course_type_btn, "field 'courseTypeBtn'", RelativeLayout.class);
    target.beginVailableImg = Utils.findRequiredViewAsType(source, R.id.begin_vailable_img, "field 'beginVailableImg'", ImageView.class);
    target.textType = Utils.findRequiredViewAsType(source, R.id.text_type, "field 'textType'", TextView.class);
    target.beginVailableBtn = Utils.findRequiredViewAsType(source, R.id.begin_vailable_btn, "field 'beginVailableBtn'", RelativeLayout.class);
    target.remainingTimeImg = Utils.findRequiredViewAsType(source, R.id.remaining_time_img, "field 'remainingTimeImg'", ImageView.class);
    target.textRemaining = Utils.findRequiredViewAsType(source, R.id.text_remaining, "field 'textRemaining'", TextView.class);
    target.remainingTimeBtn = Utils.findRequiredViewAsType(source, R.id.remaining_time_btn, "field 'remainingTimeBtn'", RelativeLayout.class);
    target.remindTimeImg = Utils.findRequiredViewAsType(source, R.id.remind_time_img, "field 'remindTimeImg'", ImageView.class);
    target.textPaidInAmount = Utils.findRequiredViewAsType(source, R.id.text_Paid_in_amount, "field 'textPaidInAmount'", TextView.class);
    target.remindTimeBtn = Utils.findRequiredViewAsType(source, R.id.remind_time_btn, "field 'remindTimeBtn'", RelativeLayout.class);
    target.endTimeImg = Utils.findRequiredViewAsType(source, R.id.end_time_img, "field 'endTimeImg'", ImageView.class);
    target.endTimeText = Utils.findRequiredViewAsType(source, R.id.end_time_text, "field 'endTimeText'", TextView.class);
    target.endTimeBtn = Utils.findRequiredViewAsType(source, R.id.end_time_btn, "field 'endTimeBtn'", RelativeLayout.class);
    target.buyTimeText = Utils.findRequiredViewAsType(source, R.id.buy_time_text, "field 'buyTimeText'", TextView.class);
    target.buyTimeBtn = Utils.findRequiredViewAsType(source, R.id.buy_time_btn, "field 'buyTimeBtn'", RelativeLayout.class);
    target.detailsNote = Utils.findRequiredViewAsType(source, R.id.details_note, "field 'detailsNote'", TextView.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
    target.imgOneCardMulti = Utils.findRequiredViewAsType(source, R.id.img_one_card_multi, "field 'imgOneCardMulti'", ImageView.class);
    target.textOneCardMulti = Utils.findRequiredViewAsType(source, R.id.text_one_card_multi, "field 'textOneCardMulti'", TextView.class);
    target.btnOneCardMulti = Utils.findRequiredViewAsType(source, R.id.btn_one_card_multi, "field 'btnOneCardMulti'", RelativeLayout.class);
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
    target.stateImg = null;
    target.textState = null;
    target.appointmentTypeImg = null;
    target.textNcontract = null;
    target.appointmentTypeBtn = null;
    target.courseTypeImg = null;
    target.textNoCard = null;
    target.courseTypeBtn = null;
    target.beginVailableImg = null;
    target.textType = null;
    target.beginVailableBtn = null;
    target.remainingTimeImg = null;
    target.textRemaining = null;
    target.remainingTimeBtn = null;
    target.remindTimeImg = null;
    target.textPaidInAmount = null;
    target.remindTimeBtn = null;
    target.endTimeImg = null;
    target.endTimeText = null;
    target.endTimeBtn = null;
    target.buyTimeText = null;
    target.buyTimeBtn = null;
    target.detailsNote = null;
    target.detailsNoteText = null;
    target.imgOneCardMulti = null;
    target.textOneCardMulti = null;
    target.btnOneCardMulti = null;
    target.operatorImg = null;
    target.textOperator = null;
    target.operatorBtn = null;
    target.recyclerviewid = null;
    target.swiperefreshlayoutid = null;
    target.activityAddressDetails = null;

    this.target = null;
  }
}
