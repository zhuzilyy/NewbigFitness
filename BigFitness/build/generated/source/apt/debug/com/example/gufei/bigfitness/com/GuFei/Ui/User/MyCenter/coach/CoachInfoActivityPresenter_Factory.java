package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach;

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
public final class CoachInfoActivityPresenter_Factory
    implements Factory<CoachInfoActivityPresenter> {
  private final MembersInjector<CoachInfoActivityPresenter>
      coachInfoActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CoachInfoActivityPresenter_Factory(
      MembersInjector<CoachInfoActivityPresenter> coachInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert coachInfoActivityPresenterMembersInjector != null;
    this.coachInfoActivityPresenterMembersInjector = coachInfoActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CoachInfoActivityPresenter get() {
    return MembersInjectors.injectMembers(
        coachInfoActivityPresenterMembersInjector,
        new CoachInfoActivityPresenter(apiProvider.get()));
  }

  public static Factory<CoachInfoActivityPresenter> create(
      MembersInjector<CoachInfoActivityPresenter> coachInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CoachInfoActivityPresenter_Factory(
        coachInfoActivityPresenterMembersInjector, apiProvider);
  }
}
