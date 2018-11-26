package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LessonListActivity_MembersInjector
    implements MembersInjector<LessonListActivity> {
  private final Provider<LessonListActivityPresenter> mPresenterProvider;

  public LessonListActivity_MembersInjector(
      Provider<LessonListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<LessonListActivity> create(
      Provider<LessonListActivityPresenter> mPresenterProvider) {
    return new LessonListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(LessonListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
