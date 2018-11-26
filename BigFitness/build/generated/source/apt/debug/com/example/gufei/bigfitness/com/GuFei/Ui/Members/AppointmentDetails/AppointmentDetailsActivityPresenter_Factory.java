package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails;

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
public final class AppointmentDetailsActivityPresenter_Factory
    implements Factory<AppointmentDetailsActivityPresenter> {
  private final MembersInjector<AppointmentDetailsActivityPresenter>
      appointmentDetailsActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AppointmentDetailsActivityPresenter_Factory(
      MembersInjector<AppointmentDetailsActivityPresenter>
          appointmentDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert appointmentDetailsActivityPresenterMembersInjector != null;
    this.appointmentDetailsActivityPresenterMembersInjector =
        appointmentDetailsActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AppointmentDetailsActivityPresenter get() {
    return MembersInjectors.injectMembers(
        appointmentDetailsActivityPresenterMembersInjector,
        new AppointmentDetailsActivityPresenter(apiProvider.get()));
  }

  public static Factory<AppointmentDetailsActivityPresenter> create(
      MembersInjector<AppointmentDetailsActivityPresenter>
          appointmentDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AppointmentDetailsActivityPresenter_Factory(
        appointmentDetailsActivityPresenterMembersInjector, apiProvider);
  }
}
