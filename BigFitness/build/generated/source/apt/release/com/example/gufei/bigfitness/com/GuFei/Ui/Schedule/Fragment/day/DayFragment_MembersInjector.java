package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DayFragment_MembersInjector implements MembersInjector<DayFragment> {
  private final Provider<DayPresenter> mPresenterProvider;

  public DayFragment_MembersInjector(Provider<DayPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<DayFragment> create(Provider<DayPresenter> mPresenterProvider) {
    return new DayFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(DayFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
