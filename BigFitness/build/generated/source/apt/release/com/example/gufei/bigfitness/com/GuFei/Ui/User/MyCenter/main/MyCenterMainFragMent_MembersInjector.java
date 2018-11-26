package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyCenterMainFragMent_MembersInjector
    implements MembersInjector<MyCenterMainFragMent> {
  private final Provider<MyCenterMainFragMentPresenter> mPresenterProvider;

  public MyCenterMainFragMent_MembersInjector(
      Provider<MyCenterMainFragMentPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MyCenterMainFragMent> create(
      Provider<MyCenterMainFragMentPresenter> mPresenterProvider) {
    return new MyCenterMainFragMent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MyCenterMainFragMent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
