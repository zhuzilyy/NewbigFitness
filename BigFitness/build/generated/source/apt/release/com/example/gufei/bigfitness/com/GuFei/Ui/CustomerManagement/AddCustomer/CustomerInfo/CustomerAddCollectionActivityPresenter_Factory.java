package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo;

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
public final class CustomerAddCollectionActivityPresenter_Factory
    implements Factory<CustomerAddCollectionActivityPresenter> {
  private final MembersInjector<CustomerAddCollectionActivityPresenter>
      customerAddCollectionActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CustomerAddCollectionActivityPresenter_Factory(
      MembersInjector<CustomerAddCollectionActivityPresenter>
          customerAddCollectionActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert customerAddCollectionActivityPresenterMembersInjector != null;
    this.customerAddCollectionActivityPresenterMembersInjector =
        customerAddCollectionActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CustomerAddCollectionActivityPresenter get() {
    return MembersInjectors.injectMembers(
        customerAddCollectionActivityPresenterMembersInjector,
        new CustomerAddCollectionActivityPresenter(apiProvider.get()));
  }

  public static Factory<CustomerAddCollectionActivityPresenter> create(
      MembersInjector<CustomerAddCollectionActivityPresenter>
          customerAddCollectionActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CustomerAddCollectionActivityPresenter_Factory(
        customerAddCollectionActivityPresenterMembersInjector, apiProvider);
  }
}
