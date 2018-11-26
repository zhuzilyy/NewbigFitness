package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Index2FragMent_MembersInjector implements MembersInjector<Index2FragMent> {
  private final Provider<Index2FragMentPresenter> mPresenterProvider;

  public Index2FragMent_MembersInjector(Provider<Index2FragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Index2FragMent> create(
      Provider<Index2FragMentPresenter> mPresenterProvider) {
    return new Index2FragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Index2FragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
