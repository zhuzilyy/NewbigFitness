package com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome;

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
public final class WelcomeActivityPresenter_Factory implements Factory<WelcomeActivityPresenter> {
  private final MembersInjector<WelcomeActivityPresenter> welcomeActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public WelcomeActivityPresenter_Factory(
      MembersInjector<WelcomeActivityPresenter> welcomeActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert welcomeActivityPresenterMembersInjector != null;
    this.welcomeActivityPresenterMembersInjector = welcomeActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public WelcomeActivityPresenter get() {
    return MembersInjectors.injectMembers(
        welcomeActivityPresenterMembersInjector, new WelcomeActivityPresenter(apiProvider.get()));
  }

  public static Factory<WelcomeActivityPresenter> create(
      MembersInjector<WelcomeActivityPresenter> welcomeActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new WelcomeActivityPresenter_Factory(
        welcomeActivityPresenterMembersInjector, apiProvider);
  }
}
