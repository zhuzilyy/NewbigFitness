// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details;

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

public class PublicSeaInfoActivity_ViewBinding<T extends PublicSeaInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public PublicSeaInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.userNameText = Utils.findRequiredViewAsType(source, R.id.user_name_text, "field 'userNameText'", TextView.class);
    target.userName = Utils.findRequiredViewAsType(source, R.id.user_name, "field 'userName'", TextView.class);
    target.userSxy = Utils.findRequiredViewAsType(source, R.id.user_sxy, "field 'userSxy'", TextView.class);
    target.userSexText = Utils.findRequiredViewAsType(source, R.id.user_sex_text, "field 'userSexText'", TextView.class);
    target.collectionUserTelText = Utils.findRequiredViewAsType(source, R.id.collection_user_tel_text, "field 'collectionUserTelText'", TextView.class);
    target.collectionUserTel = Utils.findRequiredViewAsType(source, R.id.collection_user_tel, "field 'collectionUserTel'", TextView.class);
    target.referencesText = Utils.findRequiredViewAsType(source, R.id.references_text, "field 'referencesText'", TextView.class);
    target.references = Utils.findRequiredViewAsType(source, R.id.references, "field 'references'", TextView.class);
    target.customerSourceText = Utils.findRequiredViewAsType(source, R.id.customer_source_text, "field 'customerSourceText'", TextView.class);
    target.customerSource = Utils.findRequiredViewAsType(source, R.id.customer_source, "field 'customerSource'", TextView.class);
    target.customerWillText = Utils.findRequiredViewAsType(source, R.id.customer_will_text, "field 'customerWillText'", TextView.class);
    target.customerWill = Utils.findRequiredViewAsType(source, R.id.customer_will, "field 'customerWill'", TextView.class);
    target.customerIdentification = Utils.findRequiredViewAsType(source, R.id.customer_identification, "field 'customerIdentification'", TextView.class);
    target.customerIdentificationText = Utils.findRequiredViewAsType(source, R.id.customer_identification_text, "field 'customerIdentificationText'", TextView.class);
    target.collectorsText = Utils.findRequiredViewAsType(source, R.id.collectors_text, "field 'collectorsText'", TextView.class);
    target.collectors = Utils.findRequiredViewAsType(source, R.id.collectors, "field 'collectors'", TextView.class);
    target.membershipConsultantText = Utils.findRequiredViewAsType(source, R.id.membership_consultant_text, "field 'membershipConsultantText'", TextView.class);
    target.membershipConsultant = Utils.findRequiredViewAsType(source, R.id.membership_consultant, "field 'membershipConsultant'", TextView.class);
    target.noteText = Utils.findRequiredViewAsType(source, R.id.note_text, "field 'noteText'", TextView.class);
    target.noteContent = Utils.findRequiredViewAsType(source, R.id.note_content, "field 'noteContent'", TextView.class);
    target.cardTypeText = Utils.findRequiredViewAsType(source, R.id.card_type_text, "field 'cardTypeText'", TextView.class);
    target.cardType = Utils.findRequiredViewAsType(source, R.id.card_type, "field 'cardType'", TextView.class);
    target.prepareMoneyText = Utils.findRequiredViewAsType(source, R.id.prepare_money_text, "field 'prepareMoneyText'", TextView.class);
    target.prepareMoney = Utils.findRequiredViewAsType(source, R.id.prepare_money, "field 'prepareMoney'", TextView.class);
    target.abandonReasonText = Utils.findRequiredViewAsType(source, R.id.abandon_reason_text, "field 'abandonReasonText'", TextView.class);
    target.abandonReasonContent = Utils.findRequiredViewAsType(source, R.id.abandon_reason_content, "field 'abandonReasonContent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.userNameText = null;
    target.userName = null;
    target.userSxy = null;
    target.userSexText = null;
    target.collectionUserTelText = null;
    target.collectionUserTel = null;
    target.referencesText = null;
    target.references = null;
    target.customerSourceText = null;
    target.customerSource = null;
    target.customerWillText = null;
    target.customerWill = null;
    target.customerIdentification = null;
    target.customerIdentificationText = null;
    target.collectorsText = null;
    target.collectors = null;
    target.membershipConsultantText = null;
    target.membershipConsultant = null;
    target.noteText = null;
    target.noteContent = null;
    target.cardTypeText = null;
    target.cardType = null;
    target.prepareMoneyText = null;
    target.prepareMoney = null;
    target.abandonReasonText = null;
    target.abandonReasonContent = null;

    this.target = null;
  }
}
