package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment;

import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScheduleAddAppointmentActivityPresenter_Factory
    implements Factory<ScheduleAddAppointmentActivityPresenter> {
  private final MembersInjector<ScheduleAddAppointmentActivityPresenter>
      scheduleAddAppointmentActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ScheduleAddAppointmentActivityPresenter_Factory(
      MembersInjector<ScheduleAddAppointmentActivityPresenter>
          scheduleAddAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert scheduleAddAppointmentActivityPresenterMembersInjector != null;
    this.scheduleAddAppointmentActivityPresenterMembersInjector =
        scheduleAddAppointmentActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ScheduleAddAppointmentActivityPresenter get() {
    return MembersInjectors.injectMembers(
        scheduleAddAppointmentActivityPresenterMembersInjector,
        new ScheduleAddAppointmentActivityPresenter(apiProvider.get()));
  }

  public static Factory<ScheduleAddAppointmentActivityPresenter> create(
      MembersInjector<ScheduleAddAppointmentActivityPresenter>
          scheduleAddAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ScheduleAddAppointmentActivityPresenter_Factory(
        scheduleAddAppointmentActivityPresenterMembersInjector, apiProvider);
  }
}
