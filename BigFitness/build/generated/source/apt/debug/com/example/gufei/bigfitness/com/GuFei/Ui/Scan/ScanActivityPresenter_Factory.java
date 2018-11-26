package com.example.gufei.bigfitness.com.GuFei.Ui.Scan;

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
public final class ScanActivityPresenter_Factory implements Factory<ScanActivityPresenter> {
  private final MembersInjector<ScanActivityPresenter> scanActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ScanActivityPresenter_Factory(
      MembersInjector<ScanActivityPresenter> scanActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert scanActivityPresenterMembersInjector != null;
    this.scanActivityPresenterMembersInjector = scanActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ScanActivityPresenter get() {
    return MembersInjectors.injectMembers(
        scanActivityPresenterMembersInjector, new ScanActivityPresenter(apiProvider.get()));
  }

  public static Factory<ScanActivityPresenter> create(
      MembersInjector<ScanActivityPresenter> scanActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ScanActivityPresenter_Factory(scanActivityPresenterMembersInjector, apiProvider);
  }
}
