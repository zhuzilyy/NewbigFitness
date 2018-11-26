package com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TeacherFilterListActivity_MembersInjector
    implements MembersInjector<TeacherFilterListActivity> {
  private final Provider<TeacherFilterListActivityPresenter> mPresenterProvider;

  public TeacherFilterListActivity_MembersInjector(
      Provider<TeacherFilterListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TeacherFilterListActivity> create(
      Provider<TeacherFilterListActivityPresenter> mPresenterProvider) {
    return new TeacherFilterListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TeacherFilterListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
