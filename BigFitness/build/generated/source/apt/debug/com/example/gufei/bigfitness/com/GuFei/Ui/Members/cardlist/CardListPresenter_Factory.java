package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist;

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
public final class CardListPresenter_Factory implements Factory<CardListPresenter> {
  private final MembersInjector<CardListPresenter> cardListPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public CardListPresenter_Factory(
      MembersInjector<CardListPresenter> cardListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert cardListPresenterMembersInjector != null;
    this.cardListPresenterMembersInjector = cardListPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public CardListPresenter get() {
    return MembersInjectors.injectMembers(
        cardListPresenterMembersInjector, new CardListPresenter(apiProvider.get()));
  }

  public static Factory<CardListPresenter> create(
      MembersInjector<CardListPresenter> cardListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new CardListPresenter_Factory(cardListPresenterMembersInjector, apiProvider);
  }
}
