package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LessonReportDocumentsListActivity_MembersInjector
    implements MembersInjector<LessonReportDocumentsListActivity> {
  private final Provider<LessonReportDocumentsListActivityPresenter> mPresenterProvider;

  public LessonReportDocumentsListActivity_MembersInjector(
      Provider<LessonReportDocumentsListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<LessonReportDocumentsListActivity> create(
      Provider<LessonReportDocumentsListActivityPresenter> mPresenterProvider) {
    return new LessonReportDocumentsListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(LessonReportDocumentsListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
