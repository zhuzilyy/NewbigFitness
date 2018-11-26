package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Index1FragMent_MembersInjector implements MembersInjector<Index1FragMent> {
  private final Provider<Index1FragMentPresenter> mPresenterProvider;

  public Index1FragMent_MembersInjector(Provider<Index1FragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Index1FragMent> create(
      Provider<Index1FragMentPresenter> mPresenterProvider) {
    return new Index1FragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Index1FragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
