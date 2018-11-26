package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

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
public final class AddressListFragMentPresenter_Factory
    implements Factory<AddressListFragMentPresenter> {
  private final MembersInjector<AddressListFragMentPresenter>
      addressListFragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public AddressListFragMentPresenter_Factory(
      MembersInjector<AddressListFragMentPresenter> addressListFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert addressListFragMentPresenterMembersInjector != null;
    this.addressListFragMentPresenterMembersInjector = addressListFragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public AddressListFragMentPresenter get() {
    return MembersInjectors.injectMembers(
        addressListFragMentPresenterMembersInjector,
        new AddressListFragMentPresenter(apiProvider.get()));
  }

  public static Factory<AddressListFragMentPresenter> create(
      MembersInjector<AddressListFragMentPresenter> addressListFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new AddressListFragMentPresenter_Factory(
        addressListFragMentPresenterMembersInjector, apiProvider);
  }
}
