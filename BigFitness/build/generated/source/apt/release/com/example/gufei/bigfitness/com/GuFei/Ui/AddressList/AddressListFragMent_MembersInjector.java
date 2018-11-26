package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddressListFragMent_MembersInjector
    implements MembersInjector<AddressListFragMent> {
  private final Provider<AddressListFragMentPresenter> mPresenterProvider;

  public AddressListFragMent_MembersInjector(
      Provider<AddressListFragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddressListFragMent> create(
      Provider<AddressListFragMentPresenter> mPresenterProvider) {
    return new AddressListFragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddressListFragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
