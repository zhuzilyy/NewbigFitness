package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrainingPlanAddActivity_MembersInjector
    implements MembersInjector<TrainingPlanAddActivity> {
  private final Provider<TrainingPlanAddActivityPresenter> mPresenterProvider;

  public TrainingPlanAddActivity_MembersInjector(
      Provider<TrainingPlanAddActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TrainingPlanAddActivity> create(
      Provider<TrainingPlanAddActivityPresenter> mPresenterProvider) {
    return new TrainingPlanAddActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TrainingPlanAddActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
