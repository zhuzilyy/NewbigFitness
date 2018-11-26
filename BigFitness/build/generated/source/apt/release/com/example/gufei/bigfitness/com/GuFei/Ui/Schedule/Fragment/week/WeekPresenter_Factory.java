package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week;

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
public final class WeekPresenter_Factory implements Factory<WeekPresenter> {
  private final MembersInjector<WeekPresenter> weekPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public WeekPresenter_Factory(
      MembersInjector<WeekPresenter> weekPresenterMembersInjector, Provider<Api> apiProvider) {
    assert weekPresenterMembersInjector != null;
    this.weekPresenterMembersInjector = weekPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public WeekPresenter get() {
    return MembersInjectors.injectMembers(
        weekPresenterMembersInjector, new WeekPresenter(apiProvider.get()));
  }

  public static Factory<WeekPresenter> create(
      MembersInjector<WeekPresenter> weekPresenterMembersInjector, Provider<Api> apiProvider) {
    return new WeekPresenter_Factory(weekPresenterMembersInjector, apiProvider);
  }
}
