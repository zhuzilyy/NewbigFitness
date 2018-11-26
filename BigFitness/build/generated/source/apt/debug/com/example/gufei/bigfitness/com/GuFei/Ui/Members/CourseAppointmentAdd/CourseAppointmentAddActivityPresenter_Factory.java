package com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd;

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
public final class CourseAppointmentAddActivityPresenter_Factory
    implements Factory<CourseAppointmentAddActivityPresenter> {
  private final MembersInjector<CourseAppointmentAddActivityPresenter>
      courseAppointmentAddActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CourseAppointmentAddActivityPresenter_Factory(
      MembersInjector<CourseAppointmentAddActivityPresenter>
          courseAppointmentAddActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert courseAppointmentAddActivityPresenterMembersInjector != null;
    this.courseAppointmentAddActivityPresenterMembersInjector =
        courseAppointmentAddActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CourseAppointmentAddActivityPresenter get() {
    return MembersInjectors.injectMembers(
        courseAppointmentAddActivityPresenterMembersInjector,
        new CourseAppointmentAddActivityPresenter(apiProvider.get()));
  }

  public static Factory<CourseAppointmentAddActivityPresenter> create(
      MembersInjector<CourseAppointmentAddActivityPresenter>
          courseAppointmentAddActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CourseAppointmentAddActivityPresenter_Factory(
        courseAppointmentAddActivityPresenterMembersInjector, apiProvider);
  }
}
