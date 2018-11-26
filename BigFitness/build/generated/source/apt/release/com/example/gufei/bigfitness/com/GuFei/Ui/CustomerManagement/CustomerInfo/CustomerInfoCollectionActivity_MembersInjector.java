package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerInfoCollectionActivity_MembersInjector
    implements MembersInjector<CustomerInfoCollectionActivity> {
  private final Provider<CustomerInfoCollectionPresenter> mPresenterProvider;

  public CustomerInfoCollectionActivity_MembersInjector(
      Provider<CustomerInfoCollectionPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerInfoCollectionActivity> create(
      Provider<CustomerInfoCollectionPresenter> mPresenterProvider) {
    return new CustomerInfoCollectionActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerInfoCollectionActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
