package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment;

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
public final class AddMebersAppointmentActivityPresenter_Factory
    implements Factory<AddMebersAppointmentActivityPresenter> {
  private final MembersInjector<AddMebersAppointmentActivityPresenter>
      addMebersAppointmentActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddMebersAppointmentActivityPresenter_Factory(
      MembersInjector<AddMebersAppointmentActivityPresenter>
          addMebersAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addMebersAppointmentActivityPresenterMembersInjector != null;
    this.addMebersAppointmentActivityPresenterMembersInjector =
        addMebersAppointmentActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddMebersAppointmentActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addMebersAppointmentActivityPresenterMembersInjector,
        new AddMebersAppointmentActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddMebersAppointmentActivityPresenter> create(
      MembersInjector<AddMebersAppointmentActivityPresenter>
          addMebersAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddMebersAppointmentActivityPresenter_Factory(
        addMebersAppointmentActivityPresenterMembersInjector, apiProvider);
  }
}
