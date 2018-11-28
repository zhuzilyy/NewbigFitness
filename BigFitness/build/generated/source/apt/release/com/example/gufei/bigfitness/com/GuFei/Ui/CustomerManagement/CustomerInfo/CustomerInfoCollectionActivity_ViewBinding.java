// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
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

public class CustomerInfoCollectionActivity_ViewBinding<T extends CustomerInfoCollectionActivity> implements Unbinder {
  protected T target;

  private View view2131820978;

  private View view2131820786;

  private View view2131820914;

  private View view2131820917;

  private View view2131820924;

  private View view2131820920;

  @UiThread
  public CustomerInfoCollectionActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.userNameText = Utils.findRequiredViewAsType(source, R.id.user_name_text, "field 'userNameText'", TextView.class);
    target.userName = Utils.findRequiredViewAsType(source, R.id.user_name, "field 'userName'", EditText.class);
    target.userSxy = Utils.findRequiredViewAsType(source, R.id.user_sxy, "field 'userSxy'", TextView.class);
    target.userSexText = Utils.findRequiredViewAsType(source, R.id.user_sex_text, "field 'userSexText'", TextView.class);
    target.collectionUserTelText = Utils.findRequiredViewAsType(source, R.id.collection_user_tel_text, "field 'collectionUserTelText'", TextView.class);
    target.collectionUserTel = Utils.findRequiredViewAsType(source, R.id.collection_user_tel, "field 'collectionUserTel'", EditText.class);
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
    target.cardTypeText = Utils.findRequiredViewAsType(source, R.id.card_type_text, "field 'cardTypeText'", TextView.class);
    target.cardType = Utils.findRequiredViewAsType(source, R.id.card_type, "field 'cardType'", TextView.class);
    target.prepareMoneyText = Utils.findRequiredViewAsType(source, R.id.prepare_money_text, "field 'prepareMoneyText'", TextView.class);
    target.prepareMoney = Utils.findRequiredViewAsType(source, R.id.prepare_money, "field 'prepareMoney'", TextView.class);
    target.noteText = Utils.findRequiredViewAsType(source, R.id.note_text, "field 'noteText'", TextView.class);
    target.noteContent = Utils.findRequiredViewAsType(source, R.id.note_content, "field 'noteContent'", EditText.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onViewClicked'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
    target.userSxyImg = Utils.findRequiredViewAsType(source, R.id.user_sxy_img, "field 'userSxyImg'", ImageView.class);
    target.customerWillImg = Utils.findRequiredViewAsType(source, R.id.customer_will_img, "field 'customerWillImg'", ImageView.class);
    target.userNameImg = Utils.findRequiredViewAsType(source, R.id.user_name_img, "field 'userNameImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.user_sxy_btn, "field 'userSxyBtn' and method 'onViewClicked'");
    target.userSxyBtn = Utils.castView(view, R.id.user_sxy_btn, "field 'userSxyBtn'", RelativeLayout.class);
    view2131820786 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.references_btn, "field 'referencesBtn' and method 'onViewClicked'");
    target.referencesBtn = Utils.castView(view, R.id.references_btn, "field 'referencesBtn'", RelativeLayout.class);
    view2131820914 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_source_btn, "field 'userSourceBtn' and method 'onViewClicked'");
    target.userSourceBtn = Utils.castView(view, R.id.user_source_btn, "field 'userSourceBtn'", RelativeLayout.class);
    view2131820917 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.customer_identification_btn, "field 'customerIdentificationBtn' and method 'onViewClicked'");
    target.customerIdentificationBtn = Utils.castView(view, R.id.customer_identification_btn, "field 'customerIdentificationBtn'", RelativeLayout.class);
    view2131820924 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.customer_will_btn, "field 'customerWillBtn' and method 'onViewClicked'");
    target.customerWillBtn = Utils.castView(view, R.id.customer_will_btn, "field 'customerWillBtn'", RelativeLayout.class);
    view2131820920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.collectionUserTelImg = Utils.findRequiredViewAsType(source, R.id.collection_user_tel_img, "field 'collectionUserTelImg'", ImageView.class);
    target.referencesImg = Utils.findRequiredViewAsType(source, R.id.references_img, "field 'referencesImg'", ImageView.class);
    target.userSourceImg = Utils.findRequiredViewAsType(source, R.id.user_source_img, "field 'userSourceImg'", ImageView.class);
    target.customerIdentificationImg = Utils.findRequiredViewAsType(source, R.id.customer_identification_img, "field 'customerIdentificationImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

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
    target.cardTypeText = null;
    target.cardType = null;
    target.prepareMoneyText = null;
    target.prepareMoney = null;
    target.noteText = null;
    target.noteContent = null;
    target.tvTitle = null;
    target.btnComplete = null;
    target.toolbar = null;
    target.activityAddressDetails = null;
    target.userSxyImg = null;
    target.customerWillImg = null;
    target.userNameImg = null;
    target.userSxyBtn = null;
    target.referencesBtn = null;
    target.userSourceBtn = null;
    target.customerIdentificationBtn = null;
    target.customerWillBtn = null;
    target.collectionUserTelImg = null;
    target.referencesImg = null;
    target.userSourceImg = null;
    target.customerIdentificationImg = null;

    view2131820978.setOnClickListener(null);
    view2131820978 = null;
    view2131820786.setOnClickListener(null);
    view2131820786 = null;
    view2131820914.setOnClickListener(null);
    view2131820914 = null;
    view2131820917.setOnClickListener(null);
    view2131820917 = null;
    view2131820924.setOnClickListener(null);
    view2131820924 = null;
    view2131820920.setOnClickListener(null);
    view2131820920 = null;

    this.target = null;
  }
}
