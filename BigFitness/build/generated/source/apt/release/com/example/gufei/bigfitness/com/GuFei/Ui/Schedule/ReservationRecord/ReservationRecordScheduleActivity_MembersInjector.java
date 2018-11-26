package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReservationRecordScheduleActivity_MembersInjector
    implements MembersInjector<ReservationRecordScheduleActivity> {
  private final Provider<ReservationRecordScheduleActivityPresenter> mPresenterProvider;

  public ReservationRecordScheduleActivity_MembersInjector(
      Provider<ReservationRecordScheduleActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ReservationRecordScheduleActivity> create(
      Provider<ReservationRecordScheduleActivityPresenter> mPresenterProvider) {
    return new ReservationRecordScheduleActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ReservationRecordScheduleActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
