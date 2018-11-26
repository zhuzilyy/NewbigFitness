package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord;

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
public final class AppointmentRecordActivityPresenter_Factory
    implements Factory<AppointmentRecordActivityPresenter> {
  private final MembersInjector<AppointmentRecordActivityPresenter>
      appointmentRecordActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AppointmentRecordActivityPresenter_Factory(
      MembersInjector<AppointmentRecordActivityPresenter>
          appointmentRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert appointmentRecordActivityPresenterMembersInjector != null;
    this.appointmentRecordActivityPresenterMembersInjector =
        appointmentRecordActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AppointmentRecordActivityPresenter get() {
    return MembersInjectors.injectMembers(
        appointmentRecordActivityPresenterMembersInjector,
        new AppointmentRecordActivityPresenter(apiProvider.get()));
  }

  public static Factory<AppointmentRecordActivityPresenter> create(
      MembersInjector<AppointmentRecordActivityPresenter>
          appointmentRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AppointmentRecordActivityPresenter_Factory(
        appointmentRecordActivityPresenterMembersInjector, apiProvider);
  }
}
