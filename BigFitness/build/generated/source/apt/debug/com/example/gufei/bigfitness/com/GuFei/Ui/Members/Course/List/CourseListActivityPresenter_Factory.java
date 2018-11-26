package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List;

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
public final class CourseListActivityPresenter_Factory
    implements Factory<CourseListActivityPresenter> {
  private final MembersInjector<CourseListActivityPresenter>
      courseListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CourseListActivityPresenter_Factory(
      MembersInjector<CourseListActivityPresenter> courseListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert courseListActivityPresenterMembersInjector != null;
    this.courseListActivityPresenterMembersInjector = courseListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CourseListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        courseListActivityPresenterMembersInjector,
        new CourseListActivityPresenter(apiProvider.get()));
  }

  public static Factory<CourseListActivityPresenter> create(
      MembersInjector<CourseListActivityPresenter> courseListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CourseListActivityPresenter_Factory(
        courseListActivityPresenterMembersInjector, apiProvider);
  }
}
