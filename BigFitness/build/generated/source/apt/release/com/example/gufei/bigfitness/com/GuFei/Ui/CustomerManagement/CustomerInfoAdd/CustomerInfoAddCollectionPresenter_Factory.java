package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd;

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
public final class CustomerInfoAddCollectionPresenter_Factory
    implements Factory<CustomerInfoAddCollectionPresenter> {
  private final MembersInjector<CustomerInfoAddCollectionPresenter>
      customerInfoAddCollectionPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CustomerInfoAddCollectionPresenter_Factory(
      MembersInjector<CustomerInfoAddCollectionPresenter>
          customerInfoAddCollectionPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert customerInfoAddCollectionPresenterMembersInjector != null;
    this.customerInfoAddCollectionPresenterMembersInjector =
        customerInfoAddCollectionPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CustomerInfoAddCollectionPresenter get() {
    return MembersInjectors.injectMembers(
        customerInfoAddCollectionPresenterMembersInjector,
        new CustomerInfoAddCollectionPresenter(apiProvider.get()));
  }

  public static Factory<CustomerInfoAddCollectionPresenter> create(
      MembersInjector<CustomerInfoAddCollectionPresenter>
          customerInfoAddCollectionPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CustomerInfoAddCollectionPresenter_Factory(
        customerInfoAddCollectionPresenterMembersInjector, apiProvider);
  }
}
