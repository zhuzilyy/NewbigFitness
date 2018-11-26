package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CourseListActivity_MembersInjector
    implements MembersInjector<CourseListActivity> {
  private final Provider<CourseListActivityPresenter> mPresenterProvider;

  public CourseListActivity_MembersInjector(
      Provider<CourseListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CourseListActivity> create(
      Provider<CourseListActivityPresenter> mPresenterProvider) {
    return new CourseListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CourseListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
