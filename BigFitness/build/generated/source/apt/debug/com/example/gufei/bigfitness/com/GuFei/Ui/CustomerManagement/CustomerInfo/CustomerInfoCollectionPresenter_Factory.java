package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo;

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
public final class CustomerInfoCollectionPresenter_Factory
    implements Factory<CustomerInfoCollectionPresenter> {
  private final MembersInjector<CustomerInfoCollectionPresenter>
      customerInfoCollectionPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CustomerInfoCollectionPresenter_Factory(
      MembersInjector<CustomerInfoCollectionPresenter>
          customerInfoCollectionPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert customerInfoCollectionPresenterMembersInjector != null;
    this.customerInfoCollectionPresenterMembersInjector =
        customerInfoCollectionPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CustomerInfoCollectionPresenter get() {
    return MembersInjectors.injectMembers(
        customerInfoCollectionPresenterMembersInjector,
        new CustomerInfoCollectionPresenter(apiProvider.get()));
  }

  public static Factory<CustomerInfoCollectionPresenter> create(
      MembersInjector<CustomerInfoCollectionPresenter>
          customerInfoCollectionPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CustomerInfoCollectionPresenter_Factory(
        customerInfoCollectionPresenterMembersInjector, apiProvider);
  }
}
