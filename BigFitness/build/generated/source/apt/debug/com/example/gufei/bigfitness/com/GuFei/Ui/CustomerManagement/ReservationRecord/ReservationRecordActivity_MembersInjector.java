package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReservationRecordActivity_MembersInjector
    implements MembersInjector<ReservationRecordActivity> {
  private final Provider<ReservationRecordActivityPresenter> mPresenterProvider;

  public ReservationRecordActivity_MembersInjector(
      Provider<ReservationRecordActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ReservationRecordActivity> create(
      Provider<ReservationRecordActivityPresenter> mPresenterProvider) {
    return new ReservationRecordActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ReservationRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
