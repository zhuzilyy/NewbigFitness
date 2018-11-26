package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TimeCardInfoActivity_MembersInjector
    implements MembersInjector<TimeCardInfoActivity> {
  private final Provider<TimeCardInfoActivityPresenter> mPresenterProvider;

  public TimeCardInfoActivity_MembersInjector(
      Provider<TimeCardInfoActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TimeCardInfoActivity> create(
      Provider<TimeCardInfoActivityPresenter> mPresenterProvider) {
    return new TimeCardInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TimeCardInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
