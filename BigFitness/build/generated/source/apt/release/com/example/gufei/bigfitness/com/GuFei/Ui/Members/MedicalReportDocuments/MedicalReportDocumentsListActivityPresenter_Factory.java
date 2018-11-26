package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments;

import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MedicalReportDocumentsListActivityPresenter_Factory
    implements Factory<MedicalReportDocumentsListActivityPresenter> {
  private final MembersInjector<MedicalReportDocumentsListActivityPresenter>
      medicalReportDocumentsListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MedicalReportDocumentsListActivityPresenter_Factory(
      MembersInjector<MedicalReportDocumentsListActivityPresenter>
          medicalReportDocumentsListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert medicalReportDocumentsListActivityPresenterMembersInjector != null;
    this.medicalReportDocumentsListActivityPresenterMembersInjector =
        medicalReportDocumentsListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MedicalReportDocumentsListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        medicalReportDocumentsListActivityPresenterMembersInjector,
        new MedicalReportDocumentsListActivityPresenter(apiProvider.get()));
  }

  public static Factory<MedicalReportDocumentsListActivityPresenter> create(
      MembersInjector<MedicalReportDocumentsListActivityPresenter>
          medicalReportDocumentsListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MedicalReportDocumentsListActivityPresenter_Factory(
        medicalReportDocumentsListActivityPresenterMembersInjector, apiProvider);
  }
}
