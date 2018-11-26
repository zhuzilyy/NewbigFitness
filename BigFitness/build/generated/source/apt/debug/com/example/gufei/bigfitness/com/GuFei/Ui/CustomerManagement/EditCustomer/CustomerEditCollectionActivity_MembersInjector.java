package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerEditCollectionActivity_MembersInjector
    implements MembersInjector<CustomerEditCollectionActivity> {
  private final Provider<CustomerEditCollectionActivityPresenter> mPresenterProvider;

  public CustomerEditCollectionActivity_MembersInjector(
      Provider<CustomerEditCollectionActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerEditCollectionActivity> create(
      Provider<CustomerEditCollectionActivityPresenter> mPresenterProvider) {
    return new CustomerEditCollectionActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerEditCollectionActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
