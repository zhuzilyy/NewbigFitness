package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PublicSeaInfoActivity_MembersInjector
    implements MembersInjector<PublicSeaInfoActivity> {
  private final Provider<PublicSeaInfoActivityPresenter> mPresenterProvider;

  public PublicSeaInfoActivity_MembersInjector(
      Provider<PublicSeaInfoActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PublicSeaInfoActivity> create(
      Provider<PublicSeaInfoActivityPresenter> mPresenterProvider) {
    return new PublicSeaInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PublicSeaInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
