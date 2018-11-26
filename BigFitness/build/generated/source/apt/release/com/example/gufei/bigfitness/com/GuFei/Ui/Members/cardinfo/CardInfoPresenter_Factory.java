package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo;

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
public final class CardInfoPresenter_Factory implements Factory<CardInfoPresenter> {
  private final MembersInjector<CardInfoPresenter> cardInfoPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CardInfoPresenter_Factory(
      MembersInjector<CardInfoPresenter> cardInfoPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert cardInfoPresenterMembersInjector != null;
    this.cardInfoPresenterMembersInjector = cardInfoPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CardInfoPresenter get() {
    return MembersInjectors.injectMembers(
        cardInfoPresenterMembersInjector, new CardInfoPresenter(apiProvider.get()));
  }

  public static Factory<CardInfoPresenter> create(
      MembersInjector<CardInfoPresenter> cardInfoPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CardInfoPresenter_Factory(cardInfoPresenterMembersInjector, apiProvider);
  }
}
