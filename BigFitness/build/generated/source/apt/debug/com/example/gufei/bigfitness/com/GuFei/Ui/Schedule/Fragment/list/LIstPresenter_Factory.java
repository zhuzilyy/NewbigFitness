package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list;

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
public final class LIstPresenter_Factory implements Factory<LIstPresenter> {
  private final MembersInjector<LIstPresenter> lIstPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public LIstPresenter_Factory(
      MembersInjector<LIstPresenter> lIstPresenterMembersInjector, Provider<Api> apiProvider) {
    assert lIstPresenterMembersInjector != null;
    this.lIstPresenterMembersInjector = lIstPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public LIstPresenter get() {
    return MembersInjectors.injectMembers(
        lIstPresenterMembersInjector, new LIstPresenter(apiProvider.get()));
  }

  public static Factory<LIstPresenter> create(
      MembersInjector<LIstPresenter> lIstPresenterMembersInjector, Provider<Api> apiProvider) {
    return new LIstPresenter_Factory(lIstPresenterMembersInjector, apiProvider);
  }
}
