package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index;

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
public final class IndexFragMentPresenter_Factory implements Factory<IndexFragMentPresenter> {
  private final MembersInjector<IndexFragMentPresenter> indexFragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public IndexFragMentPresenter_Factory(
      MembersInjector<IndexFragMentPresenter> indexFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert indexFragMentPresenterMembersInjector != null;
    this.indexFragMentPresenterMembersInjector = indexFragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public IndexFragMentPresenter get() {
    return MembersInjectors.injectMembers(
        indexFragMentPresenterMembersInjector, new IndexFragMentPresenter(apiProvider.get()));
  }

  public static Factory<IndexFragMentPresenter> create(
      MembersInjector<IndexFragMentPresenter> indexFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new IndexFragMentPresenter_Factory(indexFragMentPresenterMembersInjector, apiProvider);
  }
}
