package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson;

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
public final class GroupLesssonActivityPresenter_Factory
    implements Factory<GroupLesssonActivityPresenter> {
  private final MembersInjector<GroupLesssonActivityPresenter>
      groupLesssonActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public GroupLesssonActivityPresenter_Factory(
      MembersInjector<GroupLesssonActivityPresenter> groupLesssonActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert groupLesssonActivityPresenterMembersInjector != null;
    this.groupLesssonActivityPresenterMembersInjector =
        groupLesssonActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public GroupLesssonActivityPresenter get() {
    return MembersInjectors.injectMembers(
        groupLesssonActivityPresenterMembersInjector,
        new GroupLesssonActivityPresenter(apiProvider.get()));
  }

  public static Factory<GroupLesssonActivityPresenter> create(
      MembersInjector<GroupLesssonActivityPresenter> groupLesssonActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new GroupLesssonActivityPresenter_Factory(
        groupLesssonActivityPresenterMembersInjector, apiProvider);
  }
}
