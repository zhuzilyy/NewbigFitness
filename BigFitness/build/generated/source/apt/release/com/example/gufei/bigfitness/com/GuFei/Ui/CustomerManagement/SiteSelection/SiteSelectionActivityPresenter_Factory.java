package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection;

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
public final class SiteSelectionActivityPresenter_Factory
    implements Factory<SiteSelectionActivityPresenter> {
  private final MembersInjector<SiteSelectionActivityPresenter>
      siteSelectionActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public SiteSelectionActivityPresenter_Factory(
      MembersInjector<SiteSelectionActivityPresenter> siteSelectionActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert siteSelectionActivityPresenterMembersInjector != null;
    this.siteSelectionActivityPresenterMembersInjector =
        siteSelectionActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public SiteSelectionActivityPresenter get() {
    return MembersInjectors.injectMembers(
        siteSelectionActivityPresenterMembersInjector,
        new SiteSelectionActivityPresenter(apiProvider.get()));
  }

  public static Factory<SiteSelectionActivityPresenter> create(
      MembersInjector<SiteSelectionActivityPresenter> siteSelectionActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new SiteSelectionActivityPresenter_Factory(
        siteSelectionActivityPresenterMembersInjector, apiProvider);
  }
}
