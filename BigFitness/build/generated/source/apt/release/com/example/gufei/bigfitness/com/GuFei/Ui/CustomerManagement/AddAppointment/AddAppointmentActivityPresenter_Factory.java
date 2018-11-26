package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment;

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
public final class AddAppointmentActivityPresenter_Factory
    implements Factory<AddAppointmentActivityPresenter> {
  private final MembersInjector<AddAppointmentActivityPresenter>
      addAppointmentActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddAppointmentActivityPresenter_Factory(
      MembersInjector<AddAppointmentActivityPresenter>
          addAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addAppointmentActivityPresenterMembersInjector != null;
    this.addAppointmentActivityPresenterMembersInjector =
        addAppointmentActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddAppointmentActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addAppointmentActivityPresenterMembersInjector,
        new AddAppointmentActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddAppointmentActivityPresenter> create(
      MembersInjector<AddAppointmentActivityPresenter>
          addAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddAppointmentActivityPresenter_Factory(
        addAppointmentActivityPresenterMembersInjector, apiProvider);
  }
}
