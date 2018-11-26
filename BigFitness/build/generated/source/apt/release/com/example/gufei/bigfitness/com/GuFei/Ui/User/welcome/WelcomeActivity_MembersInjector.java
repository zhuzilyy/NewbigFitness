package com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomeActivity_MembersInjector implements MembersInjector<WelcomeActivity> {
  private final Provider<WelcomeActivityPresenter> mPresenterProvider;

  public WelcomeActivity_MembersInjector(Provider<WelcomeActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WelcomeActivity> create(
      Provider<WelcomeActivityPresenter> mPresenterProvider) {
    return new WelcomeActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WelcomeActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
