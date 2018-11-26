package com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment;

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
public final class EditMebersAppointmentActivityPresenter_Factory
    implements Factory<EditMebersAppointmentActivityPresenter> {
  private final MembersInjector<EditMebersAppointmentActivityPresenter>
      editMebersAppointmentActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public EditMebersAppointmentActivityPresenter_Factory(
      MembersInjector<EditMebersAppointmentActivityPresenter>
          editMebersAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert editMebersAppointmentActivityPresenterMembersInjector != null;
    this.editMebersAppointmentActivityPresenterMembersInjector =
        editMebersAppointmentActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public EditMebersAppointmentActivityPresenter get() {
    return MembersInjectors.injectMembers(
        editMebersAppointmentActivityPresenterMembersInjector,
        new EditMebersAppointmentActivityPresenter(apiProvider.get()));
  }

  public static Factory<EditMebersAppointmentActivityPresenter> create(
      MembersInjector<EditMebersAppointmentActivityPresenter>
          editMebersAppointmentActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new EditMebersAppointmentActivityPresenter_Factory(
        editMebersAppointmentActivityPresenterMembersInjector, apiProvider);
  }
}
