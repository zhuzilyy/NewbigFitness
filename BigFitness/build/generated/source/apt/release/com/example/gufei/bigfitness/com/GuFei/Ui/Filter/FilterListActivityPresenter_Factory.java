package com.example.gufei.bigfitness.com.GuFei.Ui.Filter;

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
public final class FilterListActivityPresenter_Factory
    implements Factory<FilterListActivityPresenter> {
  private final MembersInjector<FilterListActivityPresenter>
      filterListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public FilterListActivityPresenter_Factory(
      MembersInjector<FilterListActivityPresenter> filterListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert filterListActivityPresenterMembersInjector != null;
    this.filterListActivityPresenterMembersInjector = filterListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public FilterListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        filterListActivityPresenterMembersInjector,
        new FilterListActivityPresenter(apiProvider.get()));
  }

  public static Factory<FilterListActivityPresenter> create(
      MembersInjector<FilterListActivityPresenter> filterListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new FilterListActivityPresenter_Factory(
        filterListActivityPresenterMembersInjector, apiProvider);
  }
}
