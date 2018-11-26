// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GroupLesssonActivity_ViewBinding<T extends GroupLesssonActivity> implements Unbinder {
  protected T target;

  @UiThread
  public GroupLesssonActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.textState = Utils.findRequiredViewAsType(source, R.id.text_state, "field 'textState'", TextView.class);
    target.textNcontract = Utils.findRequiredViewAsType(source, R.id.text_ncontract, "field 'textNcontract'", TextView.class);
    target.textTypeClass = Utils.findRequiredViewAsType(source, R.id.text_type_class, "field 'textTypeClass'", TextView.class);
    target.textNameClass = Utils.findRequiredViewAsType(source, R.id.text_name_class, "field 'textNameClass'", TextView.class);
    target.textCoachLesson = Utils.findRequiredViewAsType(source, R.id.text_coach_lesson, "field 'textCoachLesson'", TextView.class);
    target.textRemaining = Utils.findRequiredViewAsType(source, R.id.text_remaining, "field 'textRemaining'", TextView.class);
    target.textMoney = Utils.findRequiredViewAsType(source, R.id.text_money, "field 'textMoney'", TextView.class);
    target.textTimeEnd = Utils.findRequiredViewAsType(source, R.id.text_time_end, "field 'textTimeEnd'", TextView.class);
    target.textTimeBuy = Utils.findRequiredViewAsType(source, R.id.text_time_buy, "field 'textTimeBuy'", TextView.class);
    target.detailsNote = Utils.findRequiredViewAsType(source, R.id.details_note, "field 'detailsNote'", TextView.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
    target.textTimeStart = Utils.findRequiredViewAsType(source, R.id.text_time_start, "field 'textTimeStart'", TextView.class);
    target.textTimeLesson = Utils.findRequiredViewAsType(source, R.id.text_time_lesson, "field 'textTimeLesson'", TextView.class);
    target.buyTimeBtn = Utils.findRequiredViewAsType(source, R.id.buy_time_btn, "field 'buyTimeBtn'", RelativeLayout.class);
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
    target.textNcontract = null;
    target.textTypeClass = null;
    target.textNameClass = null;
    target.textCoachLesson = null;
    target.textRemaining = null;
    target.textMoney = null;
    target.textTimeEnd = null;
    target.textTimeBuy = null;
    target.detailsNote = null;
    target.detailsNoteText = null;
    target.textTimeStart = null;
    target.textTimeLesson = null;
    target.buyTimeBtn = null;
    target.activityAddressDetails = null;

    this.target = null;
  }
}
