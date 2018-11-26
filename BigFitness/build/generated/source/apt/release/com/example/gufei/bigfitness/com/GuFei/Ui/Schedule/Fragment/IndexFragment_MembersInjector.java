package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IndexFragment_MembersInjector implements MembersInjector<IndexFragment> {
  private final Provider<IndexPresenter> mPresenterProvider;

  public IndexFragment_MembersInjector(Provider<IndexPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<IndexFragment> create(Provider<IndexPresenter> mPresenterProvider) {
    return new IndexFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(IndexFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
