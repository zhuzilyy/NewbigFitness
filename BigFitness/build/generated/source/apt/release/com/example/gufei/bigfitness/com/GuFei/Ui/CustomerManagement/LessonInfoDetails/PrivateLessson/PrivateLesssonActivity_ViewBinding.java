// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson;

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

public class PrivateLesssonActivity_ViewBinding<T extends PrivateLesssonActivity> implements Unbinder {
  protected T target;

  @UiThread
  public PrivateLesssonActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.textState = Utils.findRequiredViewAsType(source, R.id.text_state, "field 'textState'", TextView.class);
    target.textNcontract = Utils.findRequiredViewAsType(source, R.id.text_ncontract, "field 'textNcontract'", TextView.class);
    target.textTypeClass = Utils.findRequiredViewAsType(source, R.id.text_type_class, "field 'textTypeClass'", TextView.class);
    target.textNameClass = Utils.findRequiredViewAsType(source, R.id.text_name_class, "field 'textNameClass'", TextView.class);
    target.textCoachSigning = Utils.findRequiredViewAsType(source, R.id.text_coach_signing, "field 'textCoachSigning'", TextView.class);
    target.textCoachLesson = Utils.findRequiredViewAsType(source, R.id.text_coach_lesson, "field 'textCoachLesson'", TextView.class);
    target.textRemaining = Utils.findRequiredViewAsType(source, R.id.text_remaining, "field 'textRemaining'", TextView.class);
    target.textMoney = Utils.findRequiredViewAsType(source, R.id.text_money, "field 'textMoney'", TextView.class);
    target.textTimeEnd = Utils.findRequiredViewAsType(source, R.id.text_time_end, "field 'textTimeEnd'", TextView.class);
    target.textTimeBuy = Utils.findRequiredViewAsType(source, R.id.text_time_buy, "field 'textTimeBuy'", TextView.class);
    target.detailsNote = Utils.findRequiredViewAsType(source, R.id.details_note, "field 'detailsNote'", TextView.class);
    target.detailsNoteText = Utils.findRequiredViewAsType(source, R.id.details_note_text, "field 'detailsNoteText'", TextView.class);
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
    target.textTypeClass = null;
    target.textNameClass = null;
    target.textCoachSigning = null;
    target.textCoachLesson = null;
    target.textRemaining = null;
    target.textMoney = null;
    target.textTimeEnd = null;
    target.textTimeBuy = null;
    target.detailsNote = null;
    target.detailsNoteText = null;
    target.textOperator = null;

    this.target = null;
  }
}
