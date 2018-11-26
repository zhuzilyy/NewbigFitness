package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CoachInfoActivity_MembersInjector implements MembersInjector<CoachInfoActivity> {
  private final Provider<CoachInfoActivityPresenter> mPresenterProvider;

  public CoachInfoActivity_MembersInjector(
      Provider<CoachInfoActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CoachInfoActivity> create(
      Provider<CoachInfoActivityPresenter> mPresenterProvider) {
    return new CoachInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CoachInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
