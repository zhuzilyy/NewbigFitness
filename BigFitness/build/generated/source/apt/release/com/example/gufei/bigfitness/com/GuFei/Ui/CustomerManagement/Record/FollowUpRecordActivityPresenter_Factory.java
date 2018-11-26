package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record;

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
public final class FollowUpRecordActivityPresenter_Factory
    implements Factory<FollowUpRecordActivityPresenter> {
  private final MembersInjector<FollowUpRecordActivityPresenter>
      followUpRecordActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public FollowUpRecordActivityPresenter_Factory(
      MembersInjector<FollowUpRecordActivityPresenter>
          followUpRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert followUpRecordActivityPresenterMembersInjector != null;
    this.followUpRecordActivityPresenterMembersInjector =
        followUpRecordActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public FollowUpRecordActivityPresenter get() {
    return MembersInjectors.injectMembers(
        followUpRecordActivityPresenterMembersInjector,
        new FollowUpRecordActivityPresenter(apiProvider.get()));
  }

  public static Factory<FollowUpRecordActivityPresenter> create(
      MembersInjector<FollowUpRecordActivityPresenter>
          followUpRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new FollowUpRecordActivityPresenter_Factory(
        followUpRecordActivityPresenterMembersInjector, apiProvider);
  }
}
