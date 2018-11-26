package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MembersAppointmentRecordActivity_MembersInjector
    implements MembersInjector<MembersAppointmentRecordActivity> {
  private final Provider<MembersAppointmentRecordActivityPresenter> mPresenterProvider;

  public MembersAppointmentRecordActivity_MembersInjector(
      Provider<MembersAppointmentRecordActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MembersAppointmentRecordActivity> create(
      Provider<MembersAppointmentRecordActivityPresenter> mPresenterProvider) {
    return new MembersAppointmentRecordActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MembersAppointmentRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
