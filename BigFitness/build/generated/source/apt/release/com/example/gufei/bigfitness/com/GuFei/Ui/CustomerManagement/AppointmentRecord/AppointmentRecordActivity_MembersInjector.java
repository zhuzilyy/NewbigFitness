package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppointmentRecordActivity_MembersInjector
    implements MembersInjector<AppointmentRecordActivity> {
  private final Provider<AppointmentRecordActivityPresenter> mPresenterProvider;

  public AppointmentRecordActivity_MembersInjector(
      Provider<AppointmentRecordActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AppointmentRecordActivity> create(
      Provider<AppointmentRecordActivityPresenter> mPresenterProvider) {
    return new AppointmentRecordActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AppointmentRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
