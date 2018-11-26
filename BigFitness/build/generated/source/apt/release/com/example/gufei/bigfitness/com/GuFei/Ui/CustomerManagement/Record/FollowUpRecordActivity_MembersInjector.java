package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FollowUpRecordActivity_MembersInjector
    implements MembersInjector<FollowUpRecordActivity> {
  private final Provider<FollowUpRecordActivityPresenter> mPresenterProvider;

  public FollowUpRecordActivity_MembersInjector(
      Provider<FollowUpRecordActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<FollowUpRecordActivity> create(
      Provider<FollowUpRecordActivityPresenter> mPresenterProvider) {
    return new FollowUpRecordActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(FollowUpRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
