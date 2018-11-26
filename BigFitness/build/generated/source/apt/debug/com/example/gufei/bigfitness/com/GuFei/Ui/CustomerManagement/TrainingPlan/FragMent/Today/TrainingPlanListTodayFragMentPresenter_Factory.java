package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today;

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
public final class TrainingPlanListTodayFragMentPresenter_Factory
    implements Factory<TrainingPlanListTodayFragMentPresenter> {
  private final MembersInjector<TrainingPlanListTodayFragMentPresenter>
      trainingPlanListTodayFragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public TrainingPlanListTodayFragMentPresenter_Factory(
      MembersInjector<TrainingPlanListTodayFragMentPresenter>
          trainingPlanListTodayFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert trainingPlanListTodayFragMentPresenterMembersInjector != null;
    this.trainingPlanListTodayFragMentPresenterMembersInjector =
        trainingPlanListTodayFragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrainingPlanListTodayFragMentPresenter get() {
    return MembersInjectors.injectMembers(
        trainingPlanListTodayFragMentPresenterMembersInjector,
        new TrainingPlanListTodayFragMentPresenter(apiProvider.get()));
  }

  public static Factory<TrainingPlanListTodayFragMentPresenter> create(
      MembersInjector<TrainingPlanListTodayFragMentPresenter>
          trainingPlanListTodayFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new TrainingPlanListTodayFragMentPresenter_Factory(
        trainingPlanListTodayFragMentPresenterMembersInjector, apiProvider);
  }
}
