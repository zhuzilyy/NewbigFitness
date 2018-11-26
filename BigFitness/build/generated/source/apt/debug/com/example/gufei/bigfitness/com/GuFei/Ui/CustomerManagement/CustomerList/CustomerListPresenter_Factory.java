package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

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
public final class CustomerListPresenter_Factory implements Factory<CustomerListPresenter> {
  private final MembersInjector<CustomerListPresenter> customerListPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CustomerListPresenter_Factory(
      MembersInjector<CustomerListPresenter> customerListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert customerListPresenterMembersInjector != null;
    this.customerListPresenterMembersInjector = customerListPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CustomerListPresenter get() {
    return MembersInjectors.injectMembers(
        customerListPresenterMembersInjector, new CustomerListPresenter(apiProvider.get()));
  }

  public static Factory<CustomerListPresenter> create(
      MembersInjector<CustomerListPresenter> customerListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CustomerListPresenter_Factory(customerListPresenterMembersInjector, apiProvider);
  }
}
