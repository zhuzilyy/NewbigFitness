package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails;

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
public final class MembersInfoDetailsActivityPresenter_Factory
    implements Factory<MembersInfoDetailsActivityPresenter> {
  private final MembersInjector<MembersInfoDetailsActivityPresenter>
      membersInfoDetailsActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MembersInfoDetailsActivityPresenter_Factory(
      MembersInjector<MembersInfoDetailsActivityPresenter>
          membersInfoDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert membersInfoDetailsActivityPresenterMembersInjector != null;
    this.membersInfoDetailsActivityPresenterMembersInjector =
        membersInfoDetailsActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MembersInfoDetailsActivityPresenter get() {
    return MembersInjectors.injectMembers(
        membersInfoDetailsActivityPresenterMembersInjector,
        new MembersInfoDetailsActivityPresenter(apiProvider.get()));
  }

  public static Factory<MembersInfoDetailsActivityPresenter> create(
      MembersInjector<MembersInfoDetailsActivityPresenter>
          membersInfoDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MembersInfoDetailsActivityPresenter_Factory(
        membersInfoDetailsActivityPresenterMembersInjector, apiProvider);
  }
}
