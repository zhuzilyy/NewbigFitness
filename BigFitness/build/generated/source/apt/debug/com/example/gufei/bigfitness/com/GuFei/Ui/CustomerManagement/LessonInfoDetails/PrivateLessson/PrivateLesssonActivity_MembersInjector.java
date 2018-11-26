package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PrivateLesssonActivity_MembersInjector
    implements MembersInjector<PrivateLesssonActivity> {
  private final Provider<PrivateLesssonActivityPresenter> mPresenterProvider;

  public PrivateLesssonActivity_MembersInjector(
      Provider<PrivateLesssonActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PrivateLesssonActivity> create(
      Provider<PrivateLesssonActivityPresenter> mPresenterProvider) {
    return new PrivateLesssonActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PrivateLesssonActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
