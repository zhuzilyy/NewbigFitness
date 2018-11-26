package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo;

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
public final class LessonInfoPrivateActivityPresenter_Factory
    implements Factory<LessonInfoPrivateActivityPresenter> {
  private final MembersInjector<LessonInfoPrivateActivityPresenter>
      lessonInfoPrivateActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public LessonInfoPrivateActivityPresenter_Factory(
      MembersInjector<LessonInfoPrivateActivityPresenter>
          lessonInfoPrivateActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert lessonInfoPrivateActivityPresenterMembersInjector != null;
    this.lessonInfoPrivateActivityPresenterMembersInjector =
        lessonInfoPrivateActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public LessonInfoPrivateActivityPresenter get() {
    return MembersInjectors.injectMembers(
        lessonInfoPrivateActivityPresenterMembersInjector,
        new LessonInfoPrivateActivityPresenter(apiProvider.get()));
  }

  public static Factory<LessonInfoPrivateActivityPresenter> create(
      MembersInjector<LessonInfoPrivateActivityPresenter>
          lessonInfoPrivateActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new LessonInfoPrivateActivityPresenter_Factory(
        lessonInfoPrivateActivityPresenterMembersInjector, apiProvider);
  }
}
