package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CourseDetailsActivity_MembersInjector
    implements MembersInjector<CourseDetailsActivity> {
  private final Provider<CourseDetailsActivityPresenter> mPresenterProvider;

  public CourseDetailsActivity_MembersInjector(
      Provider<CourseDetailsActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CourseDetailsActivity> create(
      Provider<CourseDetailsActivityPresenter> mPresenterProvider) {
    return new CourseDetailsActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CourseDetailsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
