package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2;

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
public final class Index2FragMentPresenter_Factory implements Factory<Index2FragMentPresenter> {
  private final MembersInjector<Index2FragMentPresenter> index2FragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public Index2FragMentPresenter_Factory(
      MembersInjector<Index2FragMentPresenter> index2FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert index2FragMentPresenterMembersInjector != null;
    this.index2FragMentPresenterMembersInjector = index2FragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public Index2FragMentPresenter get() {
    return MembersInjectors.injectMembers(
        index2FragMentPresenterMembersInjector, new Index2FragMentPresenter(apiProvider.get()));
  }

  public static Factory<Index2FragMentPresenter> create(
      MembersInjector<Index2FragMentPresenter> index2FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new Index2FragMentPresenter_Factory(index2FragMentPresenterMembersInjector, apiProvider);
  }
}
