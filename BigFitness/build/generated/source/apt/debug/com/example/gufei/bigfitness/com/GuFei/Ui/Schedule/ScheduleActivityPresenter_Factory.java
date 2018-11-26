package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule;

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
public final class ScheduleActivityPresenter_Factory implements Factory<ScheduleActivityPresenter> {
  private final MembersInjector<ScheduleActivityPresenter> scheduleActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ScheduleActivityPresenter_Factory(
      MembersInjector<ScheduleActivityPresenter> scheduleActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert scheduleActivityPresenterMembersInjector != null;
    this.scheduleActivityPresenterMembersInjector = scheduleActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ScheduleActivityPresenter get() {
    return MembersInjectors.injectMembers(
        scheduleActivityPresenterMembersInjector, new ScheduleActivityPresenter(apiProvider.get()));
  }

  public static Factory<ScheduleActivityPresenter> create(
      MembersInjector<ScheduleActivityPresenter> scheduleActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ScheduleActivityPresenter_Factory(
        scheduleActivityPresenterMembersInjector, apiProvider);
  }
}
