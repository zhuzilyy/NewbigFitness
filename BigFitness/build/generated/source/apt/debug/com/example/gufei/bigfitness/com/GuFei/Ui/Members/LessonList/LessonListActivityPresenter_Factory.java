package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList;

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
public final class LessonListActivityPresenter_Factory
    implements Factory<LessonListActivityPresenter> {
  private final MembersInjector<LessonListActivityPresenter>
      lessonListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public LessonListActivityPresenter_Factory(
      MembersInjector<LessonListActivityPresenter> lessonListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert lessonListActivityPresenterMembersInjector != null;
    this.lessonListActivityPresenterMembersInjector = lessonListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public LessonListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        lessonListActivityPresenterMembersInjector,
        new LessonListActivityPresenter(apiProvider.get()));
  }

  public static Factory<LessonListActivityPresenter> create(
      MembersInjector<LessonListActivityPresenter> lessonListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new LessonListActivityPresenter_Factory(
        lessonListActivityPresenterMembersInjector, apiProvider);
  }
}
