// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddressListFragMent_ViewBinding<T extends AddressListFragMent> implements Unbinder {
  protected T target;

  @UiThread
  public AddressListFragMent_ViewBinding(T target, View source) {
    this.target = target;

    target.edit_search = Utils.findRequiredViewAsType(source, R.id.edit_search, "field 'edit_search'", EditText.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.phone_listview, "field 'listView'", PinnedSectionListView.class);
    target.letterIndexView = Utils.findRequiredViewAsType(source, R.id.phone_LetterIndexView, "field 'letterIndexView'", LetterIndexView.class);
    target.txt_center = Utils.findRequiredViewAsType(source, R.id.phone_txt_center, "field 'txt_center'", TextView.class);
    target.refresh_layout = Utils.findRequiredViewAsType(source, R.id.refresh_layout, "field 'refresh_layout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.edit_search = null;
    target.listView = null;
    target.letterIndexView = null;
    target.txt_center = null;
    target.refresh_layout = null;

    this.target = null;
  }
}
