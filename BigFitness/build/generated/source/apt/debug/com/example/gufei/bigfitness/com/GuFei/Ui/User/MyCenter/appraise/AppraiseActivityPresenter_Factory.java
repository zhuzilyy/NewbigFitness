package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise;

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
public final class AppraiseActivityPresenter_Factory implements Factory<AppraiseActivityPresenter> {
  private final MembersInjector<AppraiseActivityPresenter> appraiseActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AppraiseActivityPresenter_Factory(
      MembersInjector<AppraiseActivityPresenter> appraiseActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert appraiseActivityPresenterMembersInjector != null;
    this.appraiseActivityPresenterMembersInjector = appraiseActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AppraiseActivityPresenter get() {
    return MembersInjectors.injectMembers(
        appraiseActivityPresenterMembersInjector, new AppraiseActivityPresenter(apiProvider.get()));
  }

  public static Factory<AppraiseActivityPresenter> create(
      MembersInjector<AppraiseActivityPresenter> appraiseActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AppraiseActivityPresenter_Factory(
        appraiseActivityPresenterMembersInjector, apiProvider);
  }
}
