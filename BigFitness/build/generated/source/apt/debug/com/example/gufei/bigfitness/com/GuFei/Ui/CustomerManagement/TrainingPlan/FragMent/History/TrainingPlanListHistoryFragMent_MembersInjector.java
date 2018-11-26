package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrainingPlanListHistoryFragMent_MembersInjector
    implements MembersInjector<TrainingPlanListHistoryFragMent> {
  private final Provider<TrainingPlanListHistoryFragMentPresenter> mPresenterProvider;

  public TrainingPlanListHistoryFragMent_MembersInjector(
      Provider<TrainingPlanListHistoryFragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TrainingPlanListHistoryFragMent> create(
      Provider<TrainingPlanListHistoryFragMentPresenter> mPresenterProvider) {
    return new TrainingPlanListHistoryFragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TrainingPlanListHistoryFragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
