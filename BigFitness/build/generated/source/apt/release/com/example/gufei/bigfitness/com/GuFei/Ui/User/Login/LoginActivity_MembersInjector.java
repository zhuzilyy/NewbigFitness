package com.example.gufei.bigfitness.com.GuFei.Ui.User.Login;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final Provider<LoginActivityPresenter> mPresenterProvider;

  public LoginActivity_MembersInjector(Provider<LoginActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<LoginActivity> create(
      Provider<LoginActivityPresenter> mPresenterProvider) {
    return new LoginActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(LoginActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
