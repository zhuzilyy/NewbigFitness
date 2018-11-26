package com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord;

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
public final class ReservationRecordMembersActivityPresenter_Factory
    implements Factory<ReservationRecordMembersActivityPresenter> {
  private final MembersInjector<ReservationRecordMembersActivityPresenter>
      reservationRecordMembersActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ReservationRecordMembersActivityPresenter_Factory(
      MembersInjector<ReservationRecordMembersActivityPresenter>
          reservationRecordMembersActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert reservationRecordMembersActivityPresenterMembersInjector != null;
    this.reservationRecordMembersActivityPresenterMembersInjector =
        reservationRecordMembersActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ReservationRecordMembersActivityPresenter get() {
    return MembersInjectors.injectMembers(
        reservationRecordMembersActivityPresenterMembersInjector,
        new ReservationRecordMembersActivityPresenter(apiProvider.get()));
  }

  public static Factory<ReservationRecordMembersActivityPresenter> create(
      MembersInjector<ReservationRecordMembersActivityPresenter>
          reservationRecordMembersActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ReservationRecordMembersActivityPresenter_Factory(
        reservationRecordMembersActivityPresenterMembersInjector, apiProvider);
  }
}
