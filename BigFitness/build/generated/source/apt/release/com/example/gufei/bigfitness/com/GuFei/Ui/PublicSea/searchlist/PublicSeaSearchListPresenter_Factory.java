package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist;

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
public final class PublicSeaSearchListPresenter_Factory
    implements Factory<PublicSeaSearchListPresenter> {
  private final MembersInjector<PublicSeaSearchListPresenter>
      publicSeaSearchListPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public PublicSeaSearchListPresenter_Factory(
      MembersInjector<PublicSeaSearchListPresenter> publicSeaSearchListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert publicSeaSearchListPresenterMembersInjector != null;
    this.publicSeaSearchListPresenterMembersInjector = publicSeaSearchListPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public PublicSeaSearchListPresenter get() {
    return MembersInjectors.injectMembers(
        publicSeaSearchListPresenterMembersInjector,
        new PublicSeaSearchListPresenter(apiProvider.get()));
  }

  public static Factory<PublicSeaSearchListPresenter> create(
      MembersInjector<PublicSeaSearchListPresenter> publicSeaSearchListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new PublicSeaSearchListPresenter_Factory(
        publicSeaSearchListPresenterMembersInjector, apiProvider);
  }
}
