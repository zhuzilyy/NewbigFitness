package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerListActivity_MembersInjector
    implements MembersInjector<CustomerListActivity> {
  private final Provider<CustomerListPresenter> mPresenterProvider;

  public CustomerListActivity_MembersInjector(Provider<CustomerListPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerListActivity> create(
      Provider<CustomerListPresenter> mPresenterProvider) {
    return new CustomerListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
