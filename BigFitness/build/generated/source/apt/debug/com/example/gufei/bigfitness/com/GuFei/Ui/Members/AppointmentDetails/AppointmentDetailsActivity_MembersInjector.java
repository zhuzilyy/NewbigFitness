package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppointmentDetailsActivity_MembersInjector
    implements MembersInjector<AppointmentDetailsActivity> {
  private final Provider<AppointmentDetailsActivityPresenter> mPresenterProvider;

  public AppointmentDetailsActivity_MembersInjector(
      Provider<AppointmentDetailsActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AppointmentDetailsActivity> create(
      Provider<AppointmentDetailsActivityPresenter> mPresenterProvider) {
    return new AppointmentDetailsActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AppointmentDetailsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
