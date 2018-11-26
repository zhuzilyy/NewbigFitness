package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerAddCollectionActivity_MembersInjector
    implements MembersInjector<CustomerAddCollectionActivity> {
  private final Provider<CustomerAddCollectionActivityPresenter> mPresenterProvider;

  public CustomerAddCollectionActivity_MembersInjector(
      Provider<CustomerAddCollectionActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerAddCollectionActivity> create(
      Provider<CustomerAddCollectionActivityPresenter> mPresenterProvider) {
    return new CustomerAddCollectionActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerAddCollectionActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
