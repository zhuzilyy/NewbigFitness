package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Index3FragMent_MembersInjector implements MembersInjector<Index3FragMent> {
  private final Provider<Index3FragMentPresenter> mPresenterProvider;

  public Index3FragMent_MembersInjector(Provider<Index3FragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Index3FragMent> create(
      Provider<Index3FragMentPresenter> mPresenterProvider) {
    return new Index3FragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Index3FragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
