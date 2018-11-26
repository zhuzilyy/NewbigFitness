package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson;

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
public final class PrivateLesssonActivityPresenter_Factory
    implements Factory<PrivateLesssonActivityPresenter> {
  private final MembersInjector<PrivateLesssonActivityPresenter>
      privateLesssonActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public PrivateLesssonActivityPresenter_Factory(
      MembersInjector<PrivateLesssonActivityPresenter>
          privateLesssonActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert privateLesssonActivityPresenterMembersInjector != null;
    this.privateLesssonActivityPresenterMembersInjector =
        privateLesssonActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public PrivateLesssonActivityPresenter get() {
    return MembersInjectors.injectMembers(
        privateLesssonActivityPresenterMembersInjector,
        new PrivateLesssonActivityPresenter(apiProvider.get()));
  }

  public static Factory<PrivateLesssonActivityPresenter> create(
      MembersInjector<PrivateLesssonActivityPresenter>
          privateLesssonActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new PrivateLesssonActivityPresenter_Factory(
        privateLesssonActivityPresenterMembersInjector, apiProvider);
  }
}
