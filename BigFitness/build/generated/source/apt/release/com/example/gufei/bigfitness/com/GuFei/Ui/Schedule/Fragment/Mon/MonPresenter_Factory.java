package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon;

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
public final class MonPresenter_Factory implements Factory<MonPresenter> {
  private final MembersInjector<MonPresenter> monPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MonPresenter_Factory(
      MembersInjector<MonPresenter> monPresenterMembersInjector, Provider<Api> apiProvider) {
    assert monPresenterMembersInjector != null;
    this.monPresenterMembersInjector = monPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MonPresenter get() {
    return MembersInjectors.injectMembers(
        monPresenterMembersInjector, new MonPresenter(apiProvider.get()));
  }

  public static Factory<MonPresenter> create(
      MembersInjector<MonPresenter> monPresenterMembersInjector, Provider<Api> apiProvider) {
    return new MonPresenter_Factory(monPresenterMembersInjector, apiProvider);
  }
}
