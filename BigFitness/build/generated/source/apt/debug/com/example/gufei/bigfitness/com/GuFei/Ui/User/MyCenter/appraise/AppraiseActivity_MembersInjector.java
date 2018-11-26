package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppraiseActivity_MembersInjector implements MembersInjector<AppraiseActivity> {
  private final Provider<AppraiseActivityPresenter> mPresenterProvider;

  public AppraiseActivity_MembersInjector(Provider<AppraiseActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AppraiseActivity> create(
      Provider<AppraiseActivityPresenter> mPresenterProvider) {
    return new AppraiseActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AppraiseActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
