package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MonFragment_MembersInjector implements MembersInjector<MonFragment> {
  private final Provider<MonPresenter> mPresenterProvider;

  public MonFragment_MembersInjector(Provider<MonPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MonFragment> create(Provider<MonPresenter> mPresenterProvider) {
    return new MonFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MonFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
