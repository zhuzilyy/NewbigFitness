// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TimeCardInfoActivity_ViewBinding<T extends TimeCardInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public TimeCardInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.textState = Utils.findRequiredViewAsType(source, R.id.text_state, "field 'textState'", TextView.class);
    target.textNcontract = Utils.findRequiredViewAsType(source, R.id.text_ncontract, "field 'textNcontract'", TextView.class);
    target.textNoCard = Utils.findRequiredViewAsType(source, R.id.text_no_card, "field 'textNoCard'", TextView.class);
    target.textType = Utils.findRequiredViewAsType(source, R.id.text_type, "field 'textType'", TextView.class);
    target.textRemaining = Utils.findRequiredViewAsType(source, R.id.text_remaining, "field 'textRemaining'", TextView.class);
    target.textPaidInAmount = Utils.findRequiredViewAsType(source, R.id.text_Paid_in_amount, "field 'textPaidInAmount'", TextView.class);
    target.endTimeText = Utils.findRequiredViewAsType(source, R.id.end_time_text, "field 'endTimeText'", TextView.class);
    target.startTimeText = Utils.findRequiredViewAsType(source, R.id.start_time_text, "field 'startTimeText'", TextView.class);
    target.buyTimeText = Utils.findRequiredViewAsType(source, R.id.buy_time_text, "field 'buyTimeText'", TextView.class);
    target.iceText = Utils.findRequiredViewAsType(source, R.id.ice_text, "field 'iceText'", TextView.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
    target.textOneCardMulti = Utils.findRequiredViewAsType(source, R.id.text_one_card_multi, "field 'textOneCardMulti'", TextView.class);
    target.textOperator = Utils.findRequiredViewAsType(source, R.id.text_operator, "field 'textOperator'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.textState = null;
    target.textNcontract = null;
    target.textNoCard = null;
    target.textType = null;
    target.textRemaining = null;
    target.textPaidInAmount = null;
    target.endTimeText = null;
    target.startTimeText = null;
    target.buyTimeText = null;
    target.iceText = null;
    target.detailsNoteText = null;
    target.textOneCardMulti = null;
    target.textOperator = null;

    this.target = null;
  }
}
