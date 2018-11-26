package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo;

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
public final class LessonInfoActivityPresenter_Factory
    implements Factory<LessonInfoActivityPresenter> {
  private final MembersInjector<LessonInfoActivityPresenter>
      lessonInfoActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public LessonInfoActivityPresenter_Factory(
      MembersInjector<LessonInfoActivityPresenter> lessonInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert lessonInfoActivityPresenterMembersInjector != null;
    this.lessonInfoActivityPresenterMembersInjector = lessonInfoActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public LessonInfoActivityPresenter get() {
    return MembersInjectors.injectMembers(
        lessonInfoActivityPresenterMembersInjector,
        new LessonInfoActivityPresenter(apiProvider.get()));
  }

  public static Factory<LessonInfoActivityPresenter> create(
      MembersInjector<LessonInfoActivityPresenter> lessonInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new LessonInfoActivityPresenter_Factory(
        lessonInfoActivityPresenterMembersInjector, apiProvider);
  }
}
