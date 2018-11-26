package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LessonInfoPrivateActivity_MembersInjector
    implements MembersInjector<LessonInfoPrivateActivity> {
  private final Provider<LessonInfoPrivateActivityPresenter> mPresenterProvider;

  public LessonInfoPrivateActivity_MembersInjector(
      Provider<LessonInfoPrivateActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<LessonInfoPrivateActivity> create(
      Provider<LessonInfoPrivateActivityPresenter> mPresenterProvider) {
    return new LessonInfoPrivateActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(LessonInfoPrivateActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
