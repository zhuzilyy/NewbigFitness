package com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MembersInfoActivity_MembersInjector
    implements MembersInjector<MembersInfoActivity> {
  private final Provider<MembersInfoActivityPresenter> mPresenterProvider;

  public MembersInfoActivity_MembersInjector(
      Provider<MembersInfoActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MembersInfoActivity> create(
      Provider<MembersInfoActivityPresenter> mPresenterProvider) {
    return new MembersInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MembersInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
