package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record;

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
public final class MembersFollowUpRecordActivityPresenter_Factory
    implements Factory<MembersFollowUpRecordActivityPresenter> {
  private final MembersInjector<MembersFollowUpRecordActivityPresenter>
      membersFollowUpRecordActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MembersFollowUpRecordActivityPresenter_Factory(
      MembersInjector<MembersFollowUpRecordActivityPresenter>
          membersFollowUpRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert membersFollowUpRecordActivityPresenterMembersInjector != null;
    this.membersFollowUpRecordActivityPresenterMembersInjector =
        membersFollowUpRecordActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MembersFollowUpRecordActivityPresenter get() {
    return MembersInjectors.injectMembers(
        membersFollowUpRecordActivityPresenterMembersInjector,
        new MembersFollowUpRecordActivityPresenter(apiProvider.get()));
  }

  public static Factory<MembersFollowUpRecordActivityPresenter> create(
      MembersInjector<MembersFollowUpRecordActivityPresenter>
          membersFollowUpRecordActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MembersFollowUpRecordActivityPresenter_Factory(
        membersFollowUpRecordActivityPresenterMembersInjector, apiProvider);
  }
}
