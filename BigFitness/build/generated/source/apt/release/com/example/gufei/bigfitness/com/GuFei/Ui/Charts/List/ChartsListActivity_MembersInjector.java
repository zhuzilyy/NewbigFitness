package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChartsListActivity_MembersInjector
    implements MembersInjector<ChartsListActivity> {
  private final Provider<ChartsListActivityPresenter> mPresenterProvider;

  public ChartsListActivity_MembersInjector(
      Provider<ChartsListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ChartsListActivity> create(
      Provider<ChartsListActivityPresenter> mPresenterProvider) {
    return new ChartsListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ChartsListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
