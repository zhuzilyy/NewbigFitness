package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main;

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
public final class MyCenterMainFragMentPresenter_Factory
    implements Factory<MyCenterMainFragMentPresenter> {
  private final MembersInjector<MyCenterMainFragMentPresenter>
      myCenterMainFragMentPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MyCenterMainFragMentPresenter_Factory(
      MembersInjector<MyCenterMainFragMentPresenter> myCenterMainFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert myCenterMainFragMentPresenterMembersInjector != null;
    this.myCenterMainFragMentPresenterMembersInjector =
        myCenterMainFragMentPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MyCenterMainFragMentPresenter get() {
    return MembersInjectors.injectMembers(
        myCenterMainFragMentPresenterMembersInjector,
        new MyCenterMainFragMentPresenter(apiProvider.get()));
  }

  public static Factory<MyCenterMainFragMentPresenter> create(
      MembersInjector<MyCenterMainFragMentPresenter> myCenterMainFragMentPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MyCenterMainFragMentPresenter_Factory(
        myCenterMainFragMentPresenterMembersInjector, apiProvider);
  }
}
