package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow;

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
public final class AddMembersFollowActivityPresenter_Factory
    implements Factory<AddMembersFollowActivityPresenter> {
  private final MembersInjector<AddMembersFollowActivityPresenter>
      addMembersFollowActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddMembersFollowActivityPresenter_Factory(
      MembersInjector<AddMembersFollowActivityPresenter>
          addMembersFollowActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addMembersFollowActivityPresenterMembersInjector != null;
    this.addMembersFollowActivityPresenterMembersInjector =
        addMembersFollowActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddMembersFollowActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addMembersFollowActivityPresenterMembersInjector,
        new AddMembersFollowActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddMembersFollowActivityPresenter> create(
      MembersInjector<AddMembersFollowActivityPresenter>
          addMembersFollowActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddMembersFollowActivityPresenter_Factory(
        addMembersFollowActivityPresenterMembersInjector, apiProvider);
  }
}
