package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord;

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
public final class ReservationRecordActivityPresenter_Factory
    implements Factory<ReservationRecordActivityPresenter> {
  private final MembersInjector<ReservationRecordActivityPresenter>
      reservationRecordActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ReservationRecordActivityPresenter_Factory(
      MembersInjector<ReservationRecordActivityPresenter>
          reservationRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert reservationRecordActivityPresenterMembersInjector != null;
    this.reservationRecordActivityPresenterMembersInjector =
        reservationRecordActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ReservationRecordActivityPresenter get() {
    return MembersInjectors.injectMembers(
        reservationRecordActivityPresenterMembersInjector,
        new ReservationRecordActivityPresenter(apiProvider.get()));
  }

  public static Factory<ReservationRecordActivityPresenter> create(
      MembersInjector<ReservationRecordActivityPresenter>
          reservationRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ReservationRecordActivityPresenter_Factory(
        reservationRecordActivityPresenterMembersInjector, apiProvider);
  }
}
