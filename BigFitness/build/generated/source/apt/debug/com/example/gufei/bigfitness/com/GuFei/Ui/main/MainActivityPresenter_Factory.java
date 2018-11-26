package com.example.gufei.bigfitness.com.GuFei.Ui.main;

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
public final class MainActivityPresenter_Factory implements Factory<MainActivityPresenter> {
  private final MembersInjector<MainActivityPresenter> mainActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MainActivityPresenter_Factory(
      MembersInjector<MainActivityPresenter> mainActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert mainActivityPresenterMembersInjector != null;
    this.mainActivityPresenterMembersInjector = mainActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MainActivityPresenter get() {
    return MembersInjectors.injectMembers(
        mainActivityPresenterMembersInjector, new MainActivityPresenter(apiProvider.get()));
  }

  public static Factory<MainActivityPresenter> create(
      MembersInjector<MainActivityPresenter> mainActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MainActivityPresenter_Factory(mainActivityPresenterMembersInjector, apiProvider);
  }
}
