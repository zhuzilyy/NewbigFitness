package com.example.gufei.bigfitness.com.GuFei.Ui.Charts;

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
public final class ChartsMainActivityPresenter_Factory
    implements Factory<ChartsMainActivityPresenter> {
  private final MembersInjector<ChartsMainActivityPresenter>
      chartsMainActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ChartsMainActivityPresenter_Factory(
      MembersInjector<ChartsMainActivityPresenter> chartsMainActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert chartsMainActivityPresenterMembersInjector != null;
    this.chartsMainActivityPresenterMembersInjector = chartsMainActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ChartsMainActivityPresenter get() {
    return MembersInjectors.injectMembers(
        chartsMainActivityPresenterMembersInjector,
        new ChartsMainActivityPresenter(apiProvider.get()));
  }

  public static Factory<ChartsMainActivityPresenter> create(
      MembersInjector<ChartsMainActivityPresenter> chartsMainActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ChartsMainActivityPresenter_Factory(
        chartsMainActivityPresenterMembersInjector, apiProvider);
  }
}
