package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo;

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
public final class MembersInfoActivityPresenter_Factory
    implements Factory<MembersInfoActivityPresenter> {
  private final MembersInjector<MembersInfoActivityPresenter>
      membersInfoActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MembersInfoActivityPresenter_Factory(
      MembersInjector<MembersInfoActivityPresenter> membersInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert membersInfoActivityPresenterMembersInjector != null;
    this.membersInfoActivityPresenterMembersInjector = membersInfoActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MembersInfoActivityPresenter get() {
    return MembersInjectors.injectMembers(
        membersInfoActivityPresenterMembersInjector,
        new MembersInfoActivityPresenter(apiProvider.get()));
  }

  public static Factory<MembersInfoActivityPresenter> create(
      MembersInjector<MembersInfoActivityPresenter> membersInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MembersInfoActivityPresenter_Factory(
        membersInfoActivityPresenterMembersInjector, apiProvider);
  }
}
