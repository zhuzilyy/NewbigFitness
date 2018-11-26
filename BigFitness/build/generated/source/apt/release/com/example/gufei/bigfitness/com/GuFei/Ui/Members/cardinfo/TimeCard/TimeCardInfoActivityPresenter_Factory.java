package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard;

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
public final class TimeCardInfoActivityPresenter_Factory
    implements Factory<TimeCardInfoActivityPresenter> {
  private final MembersInjector<TimeCardInfoActivityPresenter>
      timeCardInfoActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public TimeCardInfoActivityPresenter_Factory(
      MembersInjector<TimeCardInfoActivityPresenter> timeCardInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert timeCardInfoActivityPresenterMembersInjector != null;
    this.timeCardInfoActivityPresenterMembersInjector =
        timeCardInfoActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public TimeCardInfoActivityPresenter get() {
    return MembersInjectors.injectMembers(
        timeCardInfoActivityPresenterMembersInjector,
        new TimeCardInfoActivityPresenter(apiProvider.get()));
  }

  public static Factory<TimeCardInfoActivityPresenter> create(
      MembersInjector<TimeCardInfoActivityPresenter> timeCardInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new TimeCardInfoActivityPresenter_Factory(
        timeCardInfoActivityPresenterMembersInjector, apiProvider);
  }
}
