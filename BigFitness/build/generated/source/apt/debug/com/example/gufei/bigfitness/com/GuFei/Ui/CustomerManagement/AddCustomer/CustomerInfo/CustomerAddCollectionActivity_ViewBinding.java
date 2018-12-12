// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerAddCollectionActivity_ViewBinding<T extends CustomerAddCollectionActivity> implements Unbinder {
  protected T target;

  private View view2131820914;

  private View view2131820916;

  private View view2131820919;

  private View view2131820922;

  private View view2131820926;

  private View view2131820930;

  private View view2131820933;

  private View view2131820937;

  private View view2131820980;

  private View view2131820908;

  private View view2131820909;

  @UiThread
  public CustomerAddCollectionActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.EdituserName = Utils.findRequiredViewAsType(source, R.id.text_user_name, "field 'EdituserName'", EditText.class);
    target.userSxyBtn = Utils.findRequiredViewAsType(source, R.id.user_sxy_btn, "field 'userSxyBtn'", RelativeLayout.class);
    target.userSexText = Utils.findRequiredViewAsType(source, R.id.user_sex_text, "field 'userSexText'", TextView.class);
    target.collectionUserTelText = Utils.findRequiredViewAsType(source, R.id.collection_user_tel_text, "field 'collectionUserTelText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.query_tel_btn, "field 'queryTelBtn' and method 'onClick'");
    target.queryTelBtn = Utils.castView(view, R.id.query_tel_btn, "field 'queryTelBtn'", TextView.class);
    view2131820914 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.collectionUserTel = Utils.findRequiredViewAsType(source, R.id.collection_user_tel, "field 'collectionUserTel'", TextView.class);
    view = Utils.findRequiredView(source, R.id.references_btn, "field 'referencesBtn' and method 'onClick'");
    target.referencesBtn = Utils.castView(view, R.id.references_btn, "field 'referencesBtn'", RelativeLayout.class);
    view2131820916 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.referencesText = Utils.findRequiredViewAsType(source, R.id.references_text, "field 'referencesText'", TextView.class);
    target.references = Utils.findRequiredViewAsType(source, R.id.references, "field 'references'", TextView.class);
    view = Utils.findRequiredView(source, R.id.user_source_btn, "field 'userSourceBtn' and method 'onClick'");
    target.userSourceBtn = Utils.castView(view, R.id.user_source_btn, "field 'userSourceBtn'", RelativeLayout.class);
    view2131820919 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.customerSourceText = Utils.findRequiredViewAsType(source, R.id.customer_source_text, "field 'customerSourceText'", TextView.class);
    target.customerSource = Utils.findRequiredViewAsType(source, R.id.customer_source, "field 'customerSource'", TextView.class);
    view = Utils.findRequiredView(source, R.id.customer_will_btn, "field 'customerWillBtn' and method 'onClick'");
    target.customerWillBtn = Utils.castView(view, R.id.customer_will_btn, "field 'customerWillBtn'", RelativeLayout.class);
    view2131820922 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.customerWillText = Utils.findRequiredViewAsType(source, R.id.customer_will_text, "field 'customerWillText'", TextView.class);
    target.customerWill = Utils.findRequiredViewAsType(source, R.id.customer_will, "field 'customerWill'", TextView.class);
    view = Utils.findRequiredView(source, R.id.customer_identification_btn, "field 'customerIdentificationBtn' and method 'onClick'");
    target.customerIdentificationBtn = Utils.castView(view, R.id.customer_identification_btn, "field 'customerIdentificationBtn'", RelativeLayout.class);
    view2131820926 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.customerIdentificationText = Utils.findRequiredViewAsType(source, R.id.customer_identification_text, "field 'customerIdentificationText'", TextView.class);
    target.customerIdentification = Utils.findRequiredViewAsType(source, R.id.customer_identification, "field 'customerIdentification'", TextView.class);
    view = Utils.findRequiredView(source, R.id.collectors_btn, "field 'collectorsBtn' and method 'onClick'");
    target.collectorsBtn = Utils.castView(view, R.id.collectors_btn, "field 'collectorsBtn'", RelativeLayout.class);
    view2131820930 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.collectorsText = Utils.findRequiredViewAsType(source, R.id.collectors_text, "field 'collectorsText'", TextView.class);
    target.collectors = Utils.findRequiredViewAsType(source, R.id.collectors, "field 'collectors'", TextView.class);
    target.membershipConsultantText = Utils.findRequiredViewAsType(source, R.id.membership_consultant_text, "field 'membershipConsultantText'", TextView.class);
    target.membershipConsultant = Utils.findRequiredViewAsType(source, R.id.membership_consultant, "field 'membershipConsultant'", TextView.class);
    view = Utils.findRequiredView(source, R.id.membership_consultant_btn, "field 'membershipConsultantBtn' and method 'onClick'");
    target.membershipConsultantBtn = Utils.castView(view, R.id.membership_consultant_btn, "field 'membershipConsultantBtn'", RelativeLayout.class);
    view2131820933 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.card_type_btn, "field 'cardTypeBtn' and method 'onClick'");
    target.cardTypeBtn = Utils.castView(view, R.id.card_type_btn, "field 'cardTypeBtn'", RelativeLayout.class);
    view2131820937 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.cardTypeText = Utils.findRequiredViewAsType(source, R.id.card_type_text, "field 'cardTypeText'", TextView.class);
    target.cardType = Utils.findRequiredViewAsType(source, R.id.card_type, "field 'cardType'", TextView.class);
    target.prepareMoneyText = Utils.findRequiredViewAsType(source, R.id.prepare_money_text, "field 'prepareMoneyText'", TextView.class);
    target.prepareMoney = Utils.findRequiredViewAsType(source, R.id.prepare_money, "field 'prepareMoney'", TextView.class);
    target.noteText = Utils.findRequiredViewAsType(source, R.id.note_text, "field 'noteText'", TextView.class);
    target.noteContent = Utils.findRequiredViewAsType(source, R.id.note_content, "field 'noteContent'", EditText.class);
    target.activityAddressDetails = Utils.findRequiredViewAsType(source, R.id.activity_address_details, "field 'activityAddressDetails'", LinearLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnComplete' and method 'onClick'");
    target.btnComplete = Utils.castView(view, R.id.btn_complete, "field 'btnComplete'", Button.class);
    view2131820980 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_sex_men, "field 'btnSexMen' and method 'onClick'");
    target.btnSexMen = Utils.castView(view, R.id.btn_sex_men, "field 'btnSexMen'", RadioButton.class);
    view2131820908 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sex_women, "field 'btnSexWomen' and method 'onClick'");
    target.btnSexWomen = Utils.castView(view, R.id.btn_sex_women, "field 'btnSexWomen'", RadioButton.class);
    view2131820909 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.starTel = Utils.findRequiredViewAsType(source, R.id.star_tel, "field 'starTel'", TextView.class);
    target.star1 = Utils.findRequiredViewAsType(source, R.id.star1, "field 'star1'", TextView.class);
    target.star2 = Utils.findRequiredViewAsType(source, R.id.star2, "field 'star2'", TextView.class);
    target.starOwn = Utils.findRequiredViewAsType(source, R.id.star_own, "field 'starOwn'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.EdituserName = null;
    target.userSxyBtn = null;
    target.userSexText = null;
    target.collectionUserTelText = null;
    target.queryTelBtn = null;
    target.collectionUserTel = null;
    target.referencesBtn = null;
    target.referencesText = null;
    target.references = null;
    target.userSourceBtn = null;
    target.customerSourceText = null;
    target.customerSource = null;
    target.customerWillBtn = null;
    target.customerWillText = null;
    target.customerWill = null;
    target.customerIdentificationBtn = null;
    target.customerIdentificationText = null;
    target.customerIdentification = null;
    target.collectorsBtn = null;
    target.collectorsText = null;
    target.collectors = null;
    target.membershipConsultantText = null;
    target.membershipConsultant = null;
    target.membershipConsultantBtn = null;
    target.cardTypeBtn = null;
    target.cardTypeText = null;
    target.cardType = null;
    target.prepareMoneyText = null;
    target.prepareMoney = null;
    target.noteText = null;
    target.noteContent = null;
    target.activityAddressDetails = null;
    target.tvTitle = null;
    target.btnComplete = null;
    target.toolbar = null;
    target.btnSexMen = null;
    target.btnSexWomen = null;
    target.starTel = null;
    target.star1 = null;
    target.star2 = null;
    target.starOwn = null;

    view2131820914.setOnClickListener(null);
    view2131820914 = null;
    view2131820916.setOnClickListener(null);
    view2131820916 = null;
    view2131820919.setOnClickListener(null);
    view2131820919 = null;
    view2131820922.setOnClickListener(null);
    view2131820922 = null;
    view2131820926.setOnClickListener(null);
    view2131820926 = null;
    view2131820930.setOnClickListener(null);
    view2131820930 = null;
    view2131820933.setOnClickListener(null);
    view2131820933 = null;
    view2131820937.setOnClickListener(null);
    view2131820937 = null;
    view2131820980.setOnClickListener(null);
    view2131820980 = null;
    view2131820908.setOnClickListener(null);
    view2131820908 = null;
    view2131820909.setOnClickListener(null);
    view2131820909 = null;

    this.target = null;
  }
}
