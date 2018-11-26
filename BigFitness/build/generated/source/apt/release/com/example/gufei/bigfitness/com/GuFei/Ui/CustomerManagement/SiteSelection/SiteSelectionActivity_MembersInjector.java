package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SiteSelectionActivity_MembersInjector
    implements MembersInjector<SiteSelectionActivity> {
  private final Provider<SiteSelectionActivityPresenter> mPresenterProvider;

  public SiteSelectionActivity_MembersInjector(
      Provider<SiteSelectionActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<SiteSelectionActivity> create(
      Provider<SiteSelectionActivityPresenter> mPresenterProvider) {
    return new SiteSelectionActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(SiteSelectionActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
