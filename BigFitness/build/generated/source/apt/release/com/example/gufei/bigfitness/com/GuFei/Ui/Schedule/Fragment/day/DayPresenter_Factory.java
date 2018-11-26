package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day;

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
public final class DayPresenter_Factory implements Factory<DayPresenter> {
  private final MembersInjector<DayPresenter> dayPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public DayPresenter_Factory(
      MembersInjector<DayPresenter> dayPresenterMembersInjector, Provider<Api> apiProvider) {
    assert dayPresenterMembersInjector != null;
    this.dayPresenterMembersInjector = dayPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public DayPresenter get() {
    return MembersInjectors.injectMembers(
        dayPresenterMembersInjector, new DayPresenter(apiProvider.get()));
  }

  public static Factory<DayPresenter> create(
      MembersInjector<DayPresenter> dayPresenterMembersInjector, Provider<Api> apiProvider) {
    return new DayPresenter_Factory(dayPresenterMembersInjector, apiProvider);
  }
}
