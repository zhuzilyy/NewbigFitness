package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow;

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
public final class AddFollowActivityPresenter_Factory
    implements Factory<AddFollowActivityPresenter> {
  private final MembersInjector<AddFollowActivityPresenter>
      addFollowActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddFollowActivityPresenter_Factory(
      MembersInjector<AddFollowActivityPresenter> addFollowActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addFollowActivityPresenterMembersInjector != null;
    this.addFollowActivityPresenterMembersInjector = addFollowActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddFollowActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addFollowActivityPresenterMembersInjector,
        new AddFollowActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddFollowActivityPresenter> create(
      MembersInjector<AddFollowActivityPresenter> addFollowActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddFollowActivityPresenter_Factory(
        addFollowActivityPresenterMembersInjector, apiProvider);
  }
}
