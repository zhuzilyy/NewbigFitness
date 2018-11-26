package com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter;

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
public final class TeacherFilterListActivityPresenter_Factory
    implements Factory<TeacherFilterListActivityPresenter> {
  private final MembersInjector<TeacherFilterListActivityPresenter>
      teacherFilterListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public TeacherFilterListActivityPresenter_Factory(
      MembersInjector<TeacherFilterListActivityPresenter>
          teacherFilterListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert teacherFilterListActivityPresenterMembersInjector != null;
    this.teacherFilterListActivityPresenterMembersInjector =
        teacherFilterListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public TeacherFilterListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        teacherFilterListActivityPresenterMembersInjector,
        new TeacherFilterListActivityPresenter(apiProvider.get()));
  }

  public static Factory<TeacherFilterListActivityPresenter> create(
      MembersInjector<TeacherFilterListActivityPresenter>
          teacherFilterListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new TeacherFilterListActivityPresenter_Factory(
        teacherFilterListActivityPresenterMembersInjector, apiProvider);
  }
}
