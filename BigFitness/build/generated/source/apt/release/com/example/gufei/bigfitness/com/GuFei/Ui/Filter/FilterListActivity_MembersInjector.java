package com.example.gufei.bigfitness.com.GuFei.Ui.Filter;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FilterListActivity_MembersInjector
    implements MembersInjector<FilterListActivity> {
  private final Provider<FilterListActivityPresenter> mPresenterProvider;

  public FilterListActivity_MembersInjector(
      Provider<FilterListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<FilterListActivity> create(
      Provider<FilterListActivityPresenter> mPresenterProvider) {
    return new FilterListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(FilterListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
