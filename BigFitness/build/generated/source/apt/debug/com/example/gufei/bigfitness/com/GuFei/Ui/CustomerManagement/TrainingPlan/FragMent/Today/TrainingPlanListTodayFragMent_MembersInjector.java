package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrainingPlanListTodayFragMent_MembersInjector
    implements MembersInjector<TrainingPlanListTodayFragMent> {
  private final Provider<TrainingPlanListTodayFragMentPresenter> mPresenterProvider;

  public TrainingPlanListTodayFragMent_MembersInjector(
      Provider<TrainingPlanListTodayFragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TrainingPlanListTodayFragMent> create(
      Provider<TrainingPlanListTodayFragMentPresenter> mPresenterProvider) {
    return new TrainingPlanListTodayFragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TrainingPlanListTodayFragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
