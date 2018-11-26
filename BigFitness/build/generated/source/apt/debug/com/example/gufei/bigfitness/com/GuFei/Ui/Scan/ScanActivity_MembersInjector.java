package com.example.gufei.bigfitness.com.GuFei.Ui.Scan;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScanActivity_MembersInjector implements MembersInjector<ScanActivity> {
  private final Provider<ScanActivityPresenter> mPresenterProvider;

  public ScanActivity_MembersInjector(Provider<ScanActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ScanActivity> create(
      Provider<ScanActivityPresenter> mPresenterProvider) {
    return new ScanActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ScanActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
