package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details;

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
public final class PublicSeaInfoActivityPresenter_Factory
    implements Factory<PublicSeaInfoActivityPresenter> {
  private final MembersInjector<PublicSeaInfoActivityPresenter>
      publicSeaInfoActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public PublicSeaInfoActivityPresenter_Factory(
      MembersInjector<PublicSeaInfoActivityPresenter> publicSeaInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert publicSeaInfoActivityPresenterMembersInjector != null;
    this.publicSeaInfoActivityPresenterMembersInjector =
        publicSeaInfoActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public PublicSeaInfoActivityPresenter get() {
    return MembersInjectors.injectMembers(
        publicSeaInfoActivityPresenterMembersInjector,
        new PublicSeaInfoActivityPresenter(apiProvider.get()));
  }

  public static Factory<PublicSeaInfoActivityPresenter> create(
      MembersInjector<PublicSeaInfoActivityPresenter> publicSeaInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new PublicSeaInfoActivityPresenter_Factory(
        publicSeaInfoActivityPresenterMembersInjector, apiProvider);
  }
}
