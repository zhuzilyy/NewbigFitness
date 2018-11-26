package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MedicalReportDocumentsListActivity_MembersInjector
    implements MembersInjector<MedicalReportDocumentsListActivity> {
  private final Provider<MedicalReportDocumentsListActivityPresenter> mPresenterProvider;

  public MedicalReportDocumentsListActivity_MembersInjector(
      Provider<MedicalReportDocumentsListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MedicalReportDocumentsListActivity> create(
      Provider<MedicalReportDocumentsListActivityPresenter> mPresenterProvider) {
    return new MedicalReportDocumentsListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MedicalReportDocumentsListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
