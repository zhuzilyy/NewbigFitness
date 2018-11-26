package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

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
public final class Index4FragMentPresenter_Factory implements Factory<Index4FragMentPresenter> {
  private final MembersInjector<Index4FragMentPresenter> index4FragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public Index4FragMentPresenter_Factory(
      MembersInjector<Index4FragMentPresenter> index4FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert index4FragMentPresenterMembersInjector != null;
    this.index4FragMentPresenterMembersInjector = index4FragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public Index4FragMentPresenter get() {
    return MembersInjectors.injectMembers(
        index4FragMentPresenterMembersInjector, new Index4FragMentPresenter(apiProvider.get()));
  }

  public static Factory<Index4FragMentPresenter> create(
      MembersInjector<Index4FragMentPresenter> index4FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new Index4FragMentPresenter_Factory(index4FragMentPresenterMembersInjector, apiProvider);
  }
}
