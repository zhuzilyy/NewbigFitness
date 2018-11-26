package com.example.gufei.bigfitness.com.GuFei.Ui.User.Login;

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
public final class LoginActivityPresenter_Factory implements Factory<LoginActivityPresenter> {
  private final MembersInjector<LoginActivityPresenter> loginActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public LoginActivityPresenter_Factory(
      MembersInjector<LoginActivityPresenter> loginActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert loginActivityPresenterMembersInjector != null;
    this.loginActivityPresenterMembersInjector = loginActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public LoginActivityPresenter get() {
    return MembersInjectors.injectMembers(
        loginActivityPresenterMembersInjector, new LoginActivityPresenter(apiProvider.get()));
  }

  public static Factory<LoginActivityPresenter> create(
      MembersInjector<LoginActivityPresenter> loginActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new LoginActivityPresenter_Factory(loginActivityPresenterMembersInjector, apiProvider);
  }
}
