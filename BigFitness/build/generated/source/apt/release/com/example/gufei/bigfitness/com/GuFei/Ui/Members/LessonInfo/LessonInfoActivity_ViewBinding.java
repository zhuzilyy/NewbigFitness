// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LessonInfoActivity_ViewBinding<T extends LessonInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LessonInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'title'", TextView.class);
    target.userNameText = Utils.findRequiredViewAsType(source, R.id.user_name_text, "field 'userNameText'", TextView.class);
    target.textTypeLesson = Utils.findRequiredViewAsType(source, R.id.text_type_lesson, "field 'textTypeLesson'", TextView.class);
    target.textNameLesson = Utils.findRequiredViewAsType(source, R.id.text_name_lesson, "field 'textNameLesson'", TextView.class);
    target.userSexText = Utils.findRequiredViewAsType(source, R.id.user_sex_text, "field 'userSexText'", TextView.class);
    target.collectionUserTelText = Utils.findRequiredViewAsType(source, R.id.collection_user_tel_text, "field 'collectionUserTelText'", TextView.class);
    target.textCoachLesson = Utils.findRequiredViewAsType(source, R.id.text_coach_lesson, "field 'textCoachLesson'", TextView.class);
    target.referencesText = Utils.findRequiredViewAsType(source, R.id.references_text, "field 'referencesText'", TextView.class);
    target.textTimeLesson = Utils.findRequiredViewAsType(source, R.id.text_time_lesson, "field 'textTimeLesson'", TextView.class);
    target.customerSourceText = Utils.findRequiredViewAsType(source, R.id.customer_source_text, "field 'customerSourceText'", TextView.class);
    target.customerSource = Utils.findRequiredViewAsType(source, R.id.customer_source, "field 'customerSource'", TextView.class);
    target.noteText = Utils.findRequiredViewAsType(source, R.id.note_text, "field 'noteText'", TextView.class);
    target.noteContent = Utils.findRequiredViewAsType(source, R.id.note_content, "field 'noteContent'", TextView.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.title = null;
    target.userNameText = null;
    target.textTypeLesson = null;
    target.textNameLesson = null;
    target.userSexText = null;
    target.collectionUserTelText = null;
    target.textCoachLesson = null;
    target.referencesText = null;
    target.textTimeLesson = null;
    target.customerSourceText = null;
    target.customerSource = null;
    target.noteText = null;
    target.noteContent = null;
    target.activityAddressDetails = null;

    this.target = null;
  }
}
