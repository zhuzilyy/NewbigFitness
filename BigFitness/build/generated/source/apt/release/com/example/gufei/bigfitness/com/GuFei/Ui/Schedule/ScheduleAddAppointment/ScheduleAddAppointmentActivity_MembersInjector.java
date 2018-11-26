package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScheduleAddAppointmentActivity_MembersInjector
    implements MembersInjector<ScheduleAddAppointmentActivity> {
  private final Provider<ScheduleAddAppointmentActivityPresenter> mPresenterProvider;

  public ScheduleAddAppointmentActivity_MembersInjector(
      Provider<ScheduleAddAppointmentActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ScheduleAddAppointmentActivity> create(
      Provider<ScheduleAddAppointmentActivityPresenter> mPresenterProvider) {
    return new ScheduleAddAppointmentActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ScheduleAddAppointmentActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
