package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List;

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
public final class PublicSeaListPresenter_Factory implements Factory<PublicSeaListPresenter> {
  private final MembersInjector<PublicSeaListPresenter> publicSeaListPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public PublicSeaListPresenter_Factory(
      MembersInjector<PublicSeaListPresenter> publicSeaListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert publicSeaListPresenterMembersInjector != null;
    this.publicSeaListPresenterMembersInjector = publicSeaListPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public PublicSeaListPresenter get() {
    return MembersInjectors.injectMembers(
        publicSeaListPresenterMembersInjector, new PublicSeaListPresenter(apiProvider.get()));
  }

  public static Factory<PublicSeaListPresenter> create(
      MembersInjector<PublicSeaListPresenter> publicSeaListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new PublicSeaListPresenter_Factory(publicSeaListPresenterMembersInjector, apiProvider);
  }
}
