package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting;

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
public final class SetingActivityPresenter_Factory implements Factory<SetingActivityPresenter> {
  private final MembersInjector<SetingActivityPresenter> setingActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public SetingActivityPresenter_Factory(
      MembersInjector<SetingActivityPresenter> setingActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert setingActivityPresenterMembersInjector != null;
    this.setingActivityPresenterMembersInjector = setingActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public SetingActivityPresenter get() {
    return MembersInjectors.injectMembers(
        setingActivityPresenterMembersInjector, new SetingActivityPresenter(apiProvider.get()));
  }

  public static Factory<SetingActivityPresenter> create(
      MembersInjector<SetingActivityPresenter> setingActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new SetingActivityPresenter_Factory(setingActivityPresenterMembersInjector, apiProvider);
  }
}
