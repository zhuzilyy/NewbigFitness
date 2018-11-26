package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment;

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
public final class AddAppointmentScheduleActivityActivityPresenter_Factory
    implements Factory<AddAppointmentScheduleActivityActivityPresenter> {
  private final MembersInjector<AddAppointmentScheduleActivityActivityPresenter>
      addAppointmentScheduleActivityActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddAppointmentScheduleActivityActivityPresenter_Factory(
      MembersInjector<AddAppointmentScheduleActivityActivityPresenter>
          addAppointmentScheduleActivityActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addAppointmentScheduleActivityActivityPresenterMembersInjector != null;
    this.addAppointmentScheduleActivityActivityPresenterMembersInjector =
        addAppointmentScheduleActivityActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddAppointmentScheduleActivityActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addAppointmentScheduleActivityActivityPresenterMembersInjector,
        new AddAppointmentScheduleActivityActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddAppointmentScheduleActivityActivityPresenter> create(
      MembersInjector<AddAppointmentScheduleActivityActivityPresenter>
          addAppointmentScheduleActivityActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddAppointmentScheduleActivityActivityPresenter_Factory(
        addAppointmentScheduleActivityActivityPresenterMembersInjector, apiProvider);
  }
}
