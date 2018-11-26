package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MembersFollowUpRecordActivity_MembersInjector
    implements MembersInjector<MembersFollowUpRecordActivity> {
  private final Provider<MembersFollowUpRecordActivityPresenter> mPresenterProvider;

  public MembersFollowUpRecordActivity_MembersInjector(
      Provider<MembersFollowUpRecordActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MembersFollowUpRecordActivity> create(
      Provider<MembersFollowUpRecordActivityPresenter> mPresenterProvider) {
    return new MembersFollowUpRecordActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MembersFollowUpRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
