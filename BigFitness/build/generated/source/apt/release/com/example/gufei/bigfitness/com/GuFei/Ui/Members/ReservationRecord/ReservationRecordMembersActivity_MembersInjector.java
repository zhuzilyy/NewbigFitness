package com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReservationRecordMembersActivity_MembersInjector
    implements MembersInjector<ReservationRecordMembersActivity> {
  private final Provider<ReservationRecordMembersActivityPresenter> mPresenterProvider;

  public ReservationRecordMembersActivity_MembersInjector(
      Provider<ReservationRecordMembersActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ReservationRecordMembersActivity> create(
      Provider<ReservationRecordMembersActivityPresenter> mPresenterProvider) {
    return new ReservationRecordMembersActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ReservationRecordMembersActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
