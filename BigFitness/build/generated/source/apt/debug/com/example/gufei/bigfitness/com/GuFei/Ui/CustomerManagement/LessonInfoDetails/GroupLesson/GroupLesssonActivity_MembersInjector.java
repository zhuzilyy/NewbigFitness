package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GroupLesssonActivity_MembersInjector
    implements MembersInjector<GroupLesssonActivity> {
  private final Provider<GroupLesssonActivityPresenter> mPresenterProvider;

  public GroupLesssonActivity_MembersInjector(
      Provider<GroupLesssonActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<GroupLesssonActivity> create(
      Provider<GroupLesssonActivityPresenter> mPresenterProvider) {
    return new GroupLesssonActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(GroupLesssonActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
