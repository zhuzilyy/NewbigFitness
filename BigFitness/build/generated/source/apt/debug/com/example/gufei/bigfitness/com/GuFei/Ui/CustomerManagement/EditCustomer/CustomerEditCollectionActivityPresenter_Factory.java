package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer;

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
public final class CustomerEditCollectionActivityPresenter_Factory
    implements Factory<CustomerEditCollectionActivityPresenter> {
  private final MembersInjector<CustomerEditCollectionActivityPresenter>
      customerEditCollectionActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CustomerEditCollectionActivityPresenter_Factory(
      MembersInjector<CustomerEditCollectionActivityPresenter>
          customerEditCollectionActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert customerEditCollectionActivityPresenterMembersInjector != null;
    this.customerEditCollectionActivityPresenterMembersInjector =
        customerEditCollectionActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CustomerEditCollectionActivityPresenter get() {
    return MembersInjectors.injectMembers(
        customerEditCollectionActivityPresenterMembersInjector,
        new CustomerEditCollectionActivityPresenter(apiProvider.get()));
  }

  public static Factory<CustomerEditCollectionActivityPresenter> create(
      MembersInjector<CustomerEditCollectionActivityPresenter>
          customerEditCollectionActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CustomerEditCollectionActivityPresenter_Factory(
        customerEditCollectionActivityPresenterMembersInjector, apiProvider);
  }
}
