package com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CardInfoActivity_MembersInjector implements MembersInjector<CardInfoActivity> {
  private final Provider<CardInfoPresenter> mPresenterProvider;

  public CardInfoActivity_MembersInjector(Provider<CardInfoPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CardInfoActivity> create(
      Provider<CardInfoPresenter> mPresenterProvider) {
    return new CardInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CardInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
