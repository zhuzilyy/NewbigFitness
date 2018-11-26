package com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QueryActivity_MembersInjector implements MembersInjector<QueryActivity> {
  private final Provider<QueryActivityPresenter> mPresenterProvider;

  public QueryActivity_MembersInjector(Provider<QueryActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<QueryActivity> create(
      Provider<QueryActivityPresenter> mPresenterProvider) {
    return new QueryActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(QueryActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
