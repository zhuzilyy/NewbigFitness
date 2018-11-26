package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScheduleActivity_MembersInjector implements MembersInjector<ScheduleActivity> {
  private final Provider<ScheduleActivityPresenter> mPresenterProvider;

  public ScheduleActivity_MembersInjector(Provider<ScheduleActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ScheduleActivity> create(
      Provider<ScheduleActivityPresenter> mPresenterProvider) {
    return new ScheduleActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ScheduleActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
