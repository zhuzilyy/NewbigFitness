// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.util.MyImageView.MyImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddMembersFollowActivity_ViewBinding<T extends AddMembersFollowActivity> implements Unbinder {
  protected T target;

  private View view2131820980;

  private View view2131820971;

  private View view2131820962;

  private View view2131820964;

  private View view2131820966;

  private View view2131820968;

  private View view2131820970;

  @UiThread
  public AddMembersFollowActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_complete, "field 'btnRelease' and method 'onViewClicked'");
    target.btnRelease = Utils.castView(view, R.id.btn_complete, "field 'btnRelease'", Button.class);
    view2131820980 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textCustomerType = Utils.findRequiredViewAsType(source, R.id.text_customer_type, "field 'textCustomerType'", TextView.class);
    target.textCustomerName = Utils.findRequiredViewAsType(source, R.id.text_customer_name, "field 'textCustomerName'", TextView.class);
    target.textCustomerImg = Utils.findRequiredViewAsType(source, R.id.text_customer_img, "field 'textCustomerImg'", ImageView.class);
    target.textContext = Utils.findRequiredViewAsType(source, R.id.text_content, "field 'textContext'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_select_img, "field 'btnSelectImg' and method 'onViewClicked'");
    target.btnSelectImg = Utils.castView(view, R.id.btn_select_img, "field 'btnSelectImg'", ImageView.class);
    view2131820971 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img1 = Utils.findRequiredViewAsType(source, R.id.img1, "field 'img1'", MyImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_del_1, "field 'btnDel1' and method 'onViewClicked'");
    target.btnDel1 = Utils.castView(view, R.id.btn_del_1, "field 'btnDel1'", ImageView.class);
    view2131820962 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img2 = Utils.findRequiredViewAsType(source, R.id.img2, "field 'img2'", MyImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_del_2, "field 'btnDel2' and method 'onViewClicked'");
    target.btnDel2 = Utils.castView(view, R.id.btn_del_2, "field 'btnDel2'", ImageView.class);
    view2131820964 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img3 = Utils.findRequiredViewAsType(source, R.id.img3, "field 'img3'", MyImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_del_3, "field 'btnDel3' and method 'onViewClicked'");
    target.btnDel3 = Utils.castView(view, R.id.btn_del_3, "field 'btnDel3'", ImageView.class);
    view2131820966 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img4 = Utils.findRequiredViewAsType(source, R.id.img4, "field 'img4'", MyImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_del_4, "field 'btnDel4' and method 'onViewClicked'");
    target.btnDel4 = Utils.castView(view, R.id.btn_del_4, "field 'btnDel4'", ImageView.class);
    view2131820968 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img5 = Utils.findRequiredViewAsType(source, R.id.img5, "field 'img5'", MyImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_del_5, "field 'btnDel5' and method 'onViewClicked'");
    target.btnDel5 = Utils.castView(view, R.id.btn_del_5, "field 'btnDel5'", ImageView.class);
    view2131820970 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;
    target.toolbar = null;
    target.btnRelease = null;
    target.textCustomerType = null;
    target.textCustomerName = null;
    target.textCustomerImg = null;
    target.textContext = null;
    target.btnSelectImg = null;
    target.img1 = null;
    target.btnDel1 = null;
    target.img2 = null;
    target.btnDel2 = null;
    target.img3 = null;
    target.btnDel3 = null;
    target.img4 = null;
    target.btnDel4 = null;
    target.img5 = null;
    target.btnDel5 = null;

    view2131820980.setOnClickListener(null);
    view2131820980 = null;
    view2131820971.setOnClickListener(null);
    view2131820971 = null;
    view2131820962.setOnClickListener(null);
    view2131820962 = null;
    view2131820964.setOnClickListener(null);
    view2131820964 = null;
    view2131820966.setOnClickListener(null);
    view2131820966 = null;
    view2131820968.setOnClickListener(null);
    view2131820968 = null;
    view2131820970.setOnClickListener(null);
    view2131820970 = null;

    this.target = null;
  }
}
