package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord;

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
public final class ReservationRecordScheduleActivityPresenter_Factory
    implements Factory<ReservationRecordScheduleActivityPresenter> {
  private final MembersInjector<ReservationRecordScheduleActivityPresenter>
      reservationRecordScheduleActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ReservationRecordScheduleActivityPresenter_Factory(
      MembersInjector<ReservationRecordScheduleActivityPresenter>
          reservationRecordScheduleActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert reservationRecordScheduleActivityPresenterMembersInjector != null;
    this.reservationRecordScheduleActivityPresenterMembersInjector =
        reservationRecordScheduleActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ReservationRecordScheduleActivityPresenter get() {
    return MembersInjectors.injectMembers(
        reservationRecordScheduleActivityPresenterMembersInjector,
        new ReservationRecordScheduleActivityPresenter(apiProvider.get()));
  }

  public static Factory<ReservationRecordScheduleActivityPresenter> create(
      MembersInjector<ReservationRecordScheduleActivityPresenter>
          reservationRecordScheduleActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ReservationRecordScheduleActivityPresenter_Factory(
        reservationRecordScheduleActivityPresenterMembersInjector, apiProvider);
  }
}
