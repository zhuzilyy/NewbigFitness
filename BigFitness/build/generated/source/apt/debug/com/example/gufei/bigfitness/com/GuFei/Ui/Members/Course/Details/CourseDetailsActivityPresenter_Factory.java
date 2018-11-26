package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details;

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
public final class CourseDetailsActivityPresenter_Factory
    implements Factory<CourseDetailsActivityPresenter> {
  private final MembersInjector<CourseDetailsActivityPresenter>
      courseDetailsActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CourseDetailsActivityPresenter_Factory(
      MembersInjector<CourseDetailsActivityPresenter> courseDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert courseDetailsActivityPresenterMembersInjector != null;
    this.courseDetailsActivityPresenterMembersInjector =
        courseDetailsActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CourseDetailsActivityPresenter get() {
    return MembersInjectors.injectMembers(
        courseDetailsActivityPresenterMembersInjector,
        new CourseDetailsActivityPresenter(apiProvider.get()));
  }

  public static Factory<CourseDetailsActivityPresenter> create(
      MembersInjector<CourseDetailsActivityPresenter> courseDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CourseDetailsActivityPresenter_Factory(
        courseDetailsActivityPresenterMembersInjector, apiProvider);
  }
}
