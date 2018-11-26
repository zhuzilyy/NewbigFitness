package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails;

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
public final class AddressDetailsActivityPresenter_Factory
    implements Factory<AddressDetailsActivityPresenter> {
  private final MembersInjector<AddressDetailsActivityPresenter>
      addressDetailsActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddressDetailsActivityPresenter_Factory(
      MembersInjector<AddressDetailsActivityPresenter>
          addressDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addressDetailsActivityPresenterMembersInjector != null;
    this.addressDetailsActivityPresenterMembersInjector =
        addressDetailsActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddressDetailsActivityPresenter get() {
    return MembersInjectors.injectMembers(
        addressDetailsActivityPresenterMembersInjector,
        new AddressDetailsActivityPresenter(apiProvider.get()));
  }

  public static Factory<AddressDetailsActivityPresenter> create(
      MembersInjector<AddressDetailsActivityPresenter>
          addressDetailsActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddressDetailsActivityPresenter_Factory(
        addressDetailsActivityPresenterMembersInjector, apiProvider);
  }
}
