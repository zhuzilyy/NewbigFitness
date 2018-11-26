package com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LessonInfoActivity_MembersInjector
    implements MembersInjector<LessonInfoActivity> {
  private final Provider<LessonInfoActivityPresenter> mPresenterProvider;

  public LessonInfoActivity_MembersInjector(
      Provider<LessonInfoActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<LessonInfoActivity> create(
      Provider<LessonInfoActivityPresenter> mPresenterProvider) {
    return new LessonInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(LessonInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
