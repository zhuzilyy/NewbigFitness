package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List;

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
public final class TrainingPlanListActivityPresenter_Factory
    implements Factory<TrainingPlanListActivityPresenter> {
  private final MembersInjector<TrainingPlanListActivityPresenter>
      trainingPlanListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public TrainingPlanListActivityPresenter_Factory(
      MembersInjector<TrainingPlanListActivityPresenter>
          trainingPlanListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert trainingPlanListActivityPresenterMembersInjector != null;
    this.trainingPlanListActivityPresenterMembersInjector =
        trainingPlanListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrainingPlanListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        trainingPlanListActivityPresenterMembersInjector,
        new TrainingPlanListActivityPresenter(apiProvider.get()));
  }

  public static Factory<TrainingPlanListActivityPresenter> create(
      MembersInjector<TrainingPlanListActivityPresenter>
          trainingPlanListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new TrainingPlanListActivityPresenter_Factory(
        trainingPlanListActivityPresenterMembersInjector, apiProvider);
  }
}
