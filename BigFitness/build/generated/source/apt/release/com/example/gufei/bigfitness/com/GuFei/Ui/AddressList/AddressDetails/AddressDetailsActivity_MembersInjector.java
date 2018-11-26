package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddressDetailsActivity_MembersInjector
    implements MembersInjector<AddressDetailsActivity> {
  private final Provider<AddressDetailsActivityPresenter> mPresenterProvider;

  public AddressDetailsActivity_MembersInjector(
      Provider<AddressDetailsActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddressDetailsActivity> create(
      Provider<AddressDetailsActivityPresenter> mPresenterProvider) {
    return new AddressDetailsActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddressDetailsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
