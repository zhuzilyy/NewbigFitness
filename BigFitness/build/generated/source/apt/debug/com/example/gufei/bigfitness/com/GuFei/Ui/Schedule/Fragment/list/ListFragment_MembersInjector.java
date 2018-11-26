package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ListFragment_MembersInjector implements MembersInjector<ListFragment> {
  private final Provider<LIstPresenter> mPresenterProvider;

  public ListFragment_MembersInjector(Provider<LIstPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ListFragment> create(Provider<LIstPresenter> mPresenterProvider) {
    return new ListFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ListFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
