// Generated code from Butter Knife. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.gufei.bigfitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImageActivity_ViewBinding<T extends ImageActivity> implements Unbinder {
  protected T target;

  private View view2131820970;

  @UiThread
  public ImageActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgView, "field 'imgView' and method 'onViewClicked'");
    target.imgView = Utils.castView(view, R.id.imgView, "field 'imgView'", ImageView.class);
    view2131820970 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imgView = null;

    view2131820970.setOnClickListener(null);
    view2131820970 = null;

    this.target = null;
  }
}
