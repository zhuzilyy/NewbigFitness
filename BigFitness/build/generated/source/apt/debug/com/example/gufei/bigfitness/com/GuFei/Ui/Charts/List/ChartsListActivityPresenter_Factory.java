package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List;

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
public final class ChartsListActivityPresenter_Factory
    implements Factory<ChartsListActivityPresenter> {
  private final MembersInjector<ChartsListActivityPresenter>
      chartsListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ChartsListActivityPresenter_Factory(
      MembersInjector<ChartsListActivityPresenter> chartsListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert chartsListActivityPresenterMembersInjector != null;
    this.chartsListActivityPresenterMembersInjector = chartsListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ChartsListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        chartsListActivityPresenterMembersInjector,
        new ChartsListActivityPresenter(apiProvider.get()));
  }

  public static Factory<ChartsListActivityPresenter> create(
      MembersInjector<ChartsListActivityPresenter> chartsListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ChartsListActivityPresenter_Factory(
        chartsListActivityPresenterMembersInjector, apiProvider);
  }
}
