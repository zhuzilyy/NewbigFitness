package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add;

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
public final class TrainingPlanAddActivityPresenter_Factory
    implements Factory<TrainingPlanAddActivityPresenter> {
  private final MembersInjector<TrainingPlanAddActivityPresenter>
      trainingPlanAddActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public TrainingPlanAddActivityPresenter_Factory(
      MembersInjector<TrainingPlanAddActivityPresenter>
          trainingPlanAddActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert trainingPlanAddActivityPresenterMembersInjector != null;
    this.trainingPlanAddActivityPresenterMembersInjector =
        trainingPlanAddActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrainingPlanAddActivityPresenter get() {
    return MembersInjectors.injectMembers(
        trainingPlanAddActivityPresenterMembersInjector,
        new TrainingPlanAddActivityPresenter(apiProvider.get()));
  }

  public static Factory<TrainingPlanAddActivityPresenter> create(
      MembersInjector<TrainingPlanAddActivityPresenter>
          trainingPlanAddActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new TrainingPlanAddActivityPresenter_Factory(
        trainingPlanAddActivityPresenterMembersInjector, apiProvider);
  }
}
