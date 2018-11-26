package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History;

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
public final class TrainingPlanListHistoryFragMentPresenter_Factory
    implements Factory<TrainingPlanListHistoryFragMentPresenter> {
  private final MembersInjector<TrainingPlanListHistoryFragMentPresenter>
      trainingPlanListHistoryFragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public TrainingPlanListHistoryFragMentPresenter_Factory(
      MembersInjector<TrainingPlanListHistoryFragMentPresenter>
          trainingPlanListHistoryFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert trainingPlanListHistoryFragMentPresenterMembersInjector != null;
    this.trainingPlanListHistoryFragMentPresenterMembersInjector =
        trainingPlanListHistoryFragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrainingPlanListHistoryFragMentPresenter get() {
    return MembersInjectors.injectMembers(
        trainingPlanListHistoryFragMentPresenterMembersInjector,
        new TrainingPlanListHistoryFragMentPresenter(apiProvider.get()));
  }

  public static Factory<TrainingPlanListHistoryFragMentPresenter> create(
      MembersInjector<TrainingPlanListHistoryFragMentPresenter>
          trainingPlanListHistoryFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new TrainingPlanListHistoryFragMentPresenter_Factory(
        trainingPlanListHistoryFragMentPresenterMembersInjector, apiProvider);
  }
}
