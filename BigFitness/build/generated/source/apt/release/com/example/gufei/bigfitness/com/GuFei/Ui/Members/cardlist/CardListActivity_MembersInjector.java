package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CardListActivity_MembersInjector implements MembersInjector<CardListActivity> {
  private final Provider<CardListPresenter> mPresenterProvider;

  public CardListActivity_MembersInjector(Provider<CardListPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CardListActivity> create(
      Provider<CardListPresenter> mPresenterProvider) {
    return new CardListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CardListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
