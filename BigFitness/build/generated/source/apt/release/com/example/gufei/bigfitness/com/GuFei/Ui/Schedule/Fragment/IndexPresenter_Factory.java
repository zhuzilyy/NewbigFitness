package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment;

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
public final class IndexPresenter_Factory implements Factory<IndexPresenter> {
  private final MembersInjector<IndexPresenter> indexPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public IndexPresenter_Factory(
      MembersInjector<IndexPresenter> indexPresenterMembersInjector, Provider<Api> apiProvider) {
    assert indexPresenterMembersInjector != null;
    this.indexPresenterMembersInjector = indexPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public IndexPresenter get() {
    return MembersInjectors.injectMembers(
        indexPresenterMembersInjector, new IndexPresenter(apiProvider.get()));
  }

  public static Factory<IndexPresenter> create(
      MembersInjector<IndexPresenter> indexPresenterMembersInjector, Provider<Api> apiProvider) {
    return new IndexPresenter_Factory(indexPresenterMembersInjector, apiProvider);
  }
}
