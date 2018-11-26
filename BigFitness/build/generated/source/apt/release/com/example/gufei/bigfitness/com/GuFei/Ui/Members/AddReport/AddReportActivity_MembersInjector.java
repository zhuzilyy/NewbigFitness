package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddReportActivity_MembersInjector implements MembersInjector<AddReportActivity> {
  private final Provider<AddReportActivityPresenter> mPresenterProvider;

  public AddReportActivity_MembersInjector(
      Provider<AddReportActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddReportActivity> create(
      Provider<AddReportActivityPresenter> mPresenterProvider) {
    return new AddReportActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddReportActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
