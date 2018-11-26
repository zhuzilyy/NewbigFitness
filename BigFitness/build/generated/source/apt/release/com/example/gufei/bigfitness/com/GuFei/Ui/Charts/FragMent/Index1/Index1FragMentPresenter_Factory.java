package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1;

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
public final class Index1FragMentPresenter_Factory implements Factory<Index1FragMentPresenter> {
  private final MembersInjector<Index1FragMentPresenter> index1FragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public Index1FragMentPresenter_Factory(
      MembersInjector<Index1FragMentPresenter> index1FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert index1FragMentPresenterMembersInjector != null;
    this.index1FragMentPresenterMembersInjector = index1FragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public Index1FragMentPresenter get() {
    return MembersInjectors.injectMembers(
        index1FragMentPresenterMembersInjector, new Index1FragMentPresenter(apiProvider.get()));
  }

  public static Factory<Index1FragMentPresenter> create(
      MembersInjector<Index1FragMentPresenter> index1FragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new Index1FragMentPresenter_Factory(index1FragMentPresenterMembersInjector, apiProvider);
  }
}
