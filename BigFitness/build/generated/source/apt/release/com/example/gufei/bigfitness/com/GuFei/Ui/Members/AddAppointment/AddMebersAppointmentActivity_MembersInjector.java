package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddMebersAppointmentActivity_MembersInjector
    implements MembersInjector<AddMebersAppointmentActivity> {
  private final Provider<AddMebersAppointmentActivityPresenter> mPresenterProvider;

  public AddMebersAppointmentActivity_MembersInjector(
      Provider<AddMebersAppointmentActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddMebersAppointmentActivity> create(
      Provider<AddMebersAppointmentActivityPresenter> mPresenterProvider) {
    return new AddMebersAppointmentActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddMebersAppointmentActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
