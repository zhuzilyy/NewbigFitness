package com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query;

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
public final class QueryActivityPresenter_Factory implements Factory<QueryActivityPresenter> {
  private final MembersInjector<QueryActivityPresenter> queryActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public QueryActivityPresenter_Factory(
      MembersInjector<QueryActivityPresenter> queryActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert queryActivityPresenterMembersInjector != null;
    this.queryActivityPresenterMembersInjector = queryActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public QueryActivityPresenter get() {
    return MembersInjectors.injectMembers(
        queryActivityPresenterMembersInjector, new QueryActivityPresenter(apiProvider.get()));
  }

  public static Factory<QueryActivityPresenter> create(
      MembersInjector<QueryActivityPresenter> queryActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new QueryActivityPresenter_Factory(queryActivityPresenterMembersInjector, apiProvider);
  }
}
