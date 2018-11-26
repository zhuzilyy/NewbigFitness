package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddAppointmentActivity_MembersInjector
    implements MembersInjector<AddAppointmentActivity> {
  private final Provider<AddAppointmentActivityPresenter> mPresenterProvider;

  public AddAppointmentActivity_MembersInjector(
      Provider<AddAppointmentActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddAppointmentActivity> create(
      Provider<AddAppointmentActivityPresenter> mPresenterProvider) {
    return new AddAppointmentActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddAppointmentActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
