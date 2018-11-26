package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddAppointmentScheduleActivity_MembersInjector
    implements MembersInjector<AddAppointmentScheduleActivity> {
  private final Provider<AddAppointmentScheduleActivityActivityPresenter> mPresenterProvider;

  public AddAppointmentScheduleActivity_MembersInjector(
      Provider<AddAppointmentScheduleActivityActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddAppointmentScheduleActivity> create(
      Provider<AddAppointmentScheduleActivityActivityPresenter> mPresenterProvider) {
    return new AddAppointmentScheduleActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddAppointmentScheduleActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
