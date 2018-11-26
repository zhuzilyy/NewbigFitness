package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WeekFragment_MembersInjector implements MembersInjector<WeekFragment> {
  private final Provider<WeekPresenter> mPresenterProvider;

  public WeekFragment_MembersInjector(Provider<WeekPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WeekFragment> create(Provider<WeekPresenter> mPresenterProvider) {
    return new WeekFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WeekFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
