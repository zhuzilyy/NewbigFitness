package com.example.gufei.bigfitness.com.GuFei.Ui.Charts;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChartsMainActivity_MembersInjector
    implements MembersInjector<ChartsMainActivity> {
  private final Provider<ChartsMainActivityPresenter> mPresenterProvider;

  public ChartsMainActivity_MembersInjector(
      Provider<ChartsMainActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ChartsMainActivity> create(
      Provider<ChartsMainActivityPresenter> mPresenterProvider) {
    return new ChartsMainActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ChartsMainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
