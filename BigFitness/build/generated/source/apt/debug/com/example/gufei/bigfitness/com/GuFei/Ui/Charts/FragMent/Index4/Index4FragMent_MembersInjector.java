package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Index4FragMent_MembersInjector implements MembersInjector<Index4FragMent> {
  private final Provider<Index4FragMentPresenter> mPresenterProvider;

  public Index4FragMent_MembersInjector(Provider<Index4FragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Index4FragMent> create(
      Provider<Index4FragMentPresenter> mPresenterProvider) {
    return new Index4FragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Index4FragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
