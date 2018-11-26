package com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CourseAppointmentAddActivity_MembersInjector
    implements MembersInjector<CourseAppointmentAddActivity> {
  private final Provider<CourseAppointmentAddActivityPresenter> mPresenterProvider;

  public CourseAppointmentAddActivity_MembersInjector(
      Provider<CourseAppointmentAddActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CourseAppointmentAddActivity> create(
      Provider<CourseAppointmentAddActivityPresenter> mPresenterProvider) {
    return new CourseAppointmentAddActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CourseAppointmentAddActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
