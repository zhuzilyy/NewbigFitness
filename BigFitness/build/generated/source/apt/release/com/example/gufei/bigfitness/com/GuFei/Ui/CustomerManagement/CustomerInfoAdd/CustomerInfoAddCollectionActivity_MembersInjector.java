package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerInfoAddCollectionActivity_MembersInjector
    implements MembersInjector<CustomerInfoAddCollectionActivity> {
  private final Provider<CustomerInfoAddCollectionPresenter> mPresenterProvider;

  public CustomerInfoAddCollectionActivity_MembersInjector(
      Provider<CustomerInfoAddCollectionPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerInfoAddCollectionActivity> create(
      Provider<CustomerInfoAddCollectionPresenter> mPresenterProvider) {
    return new CustomerInfoAddCollectionActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerInfoAddCollectionActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
