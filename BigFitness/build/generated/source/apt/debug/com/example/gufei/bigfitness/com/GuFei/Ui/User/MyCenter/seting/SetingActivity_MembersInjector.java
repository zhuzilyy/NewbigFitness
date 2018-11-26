package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SetingActivity_MembersInjector implements MembersInjector<SetingActivity> {
  private final Provider<SetingActivityPresenter> mPresenterProvider;

  public SetingActivity_MembersInjector(Provider<SetingActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<SetingActivity> create(
      Provider<SetingActivityPresenter> mPresenterProvider) {
    return new SetingActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(SetingActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
