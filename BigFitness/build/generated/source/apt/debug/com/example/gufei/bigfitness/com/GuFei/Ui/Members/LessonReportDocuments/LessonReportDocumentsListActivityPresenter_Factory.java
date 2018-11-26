package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments;

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
public final class LessonReportDocumentsListActivityPresenter_Factory
    implements Factory<LessonReportDocumentsListActivityPresenter> {
  private final MembersInjector<LessonReportDocumentsListActivityPresenter>
      lessonReportDocumentsListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public LessonReportDocumentsListActivityPresenter_Factory(
      MembersInjector<LessonReportDocumentsListActivityPresenter>
          lessonReportDocumentsListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert lessonReportDocumentsListActivityPresenterMembersInjector != null;
    this.lessonReportDocumentsListActivityPresenterMembersInjector =
        lessonReportDocumentsListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public LessonReportDocumentsListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        lessonReportDocumentsListActivityPresenterMembersInjector,
        new LessonReportDocumentsListActivityPresenter(apiProvider.get()));
  }

  public static Factory<LessonReportDocumentsListActivityPresenter> create(
      MembersInjector<LessonReportDocumentsListActivityPresenter>
          lessonReportDocumentsListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new LessonReportDocumentsListActivityPresenter_Factory(
        lessonReportDocumentsListActivityPresenterMembersInjector, apiProvider);
  }
}
