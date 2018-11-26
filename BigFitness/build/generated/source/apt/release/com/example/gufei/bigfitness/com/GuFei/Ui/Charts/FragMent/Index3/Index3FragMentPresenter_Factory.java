package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3;

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
public final class Index3FragMentPresenter_Factory implements Factory<Index3FragMentPresenter> {
  private final MembersInjector<Index3FragMentPresenter> index3FragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public Index3FragMentPresenter_Factory(
      MembersInjector<Index3FragMentPresenter> index3FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert index3FragMentPresenterMembersInjector != null;
    this.index3FragMentPresenterMembersInjector = index3FragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public Index3FragMentPresenter get() {
    return MembersInjectors.injectMembers(
        index3FragMentPresenterMembersInjector, new Index3FragMentPresenter(apiProvider.get()));
  }

  public static Factory<Index3FragMentPresenter> create(
      MembersInjector<Index3FragMentPresenter> index3FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new Index3FragMentPresenter_Factory(index3FragMentPresenterMembersInjector, apiProvider);
  }
}
