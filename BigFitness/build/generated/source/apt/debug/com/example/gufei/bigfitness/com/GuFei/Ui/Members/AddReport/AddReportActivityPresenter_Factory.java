package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport;

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
public final class AddReportActivityPresenter_Factory
    implements Factory<AddReportActivityPresenter> {
  private final MembersInjector<AddReportActivityPresenter>
      addReportActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddReportActivityPresenter_Factory(
      MembersInjector<AddReportActivityPresenter> addReportActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addReportActivityPresenterMembersInjector != null;
    this.addReportActivityPresenterMembersInjector = addReportActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddReportActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addReportActivityPresenterMembersInjector,
        new AddReportActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddReportActivityPresenter> create(
      MembersInjector<AddReportActivityPresenter> addReportActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddReportActivityPresenter_Factory(
        addReportActivityPresenterMembersInjector, apiProvider);
  }
}
