package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord;

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
public final class MembersAppointmentRecordActivityPresenter_Factory
    implements Factory<MembersAppointmentRecordActivityPresenter> {
  private final MembersInjector<MembersAppointmentRecordActivityPresenter>
      membersAppointmentRecordActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MembersAppointmentRecordActivityPresenter_Factory(
      MembersInjector<MembersAppointmentRecordActivityPresenter>
          membersAppointmentRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert membersAppointmentRecordActivityPresenterMembersInjector != null;
    this.membersAppointmentRecordActivityPresenterMembersInjector =
        membersAppointmentRecordActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MembersAppointmentRecordActivityPresenter get() {
    return MembersInjectors.injectMembers(
        membersAppointmentRecordActivityPresenterMembersInjector,
        new MembersAppointmentRecordActivityPresenter(apiProvider.get()));
  }

  public static Factory<MembersAppointmentRecordActivityPresenter> create(
      MembersInjector<MembersAppointmentRecordActivityPresenter>
          membersAppointmentRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MembersAppointmentRecordActivityPresenter_Factory(
        membersAppointmentRecordActivityPresenterMembersInjector, apiProvider);
  }
}
