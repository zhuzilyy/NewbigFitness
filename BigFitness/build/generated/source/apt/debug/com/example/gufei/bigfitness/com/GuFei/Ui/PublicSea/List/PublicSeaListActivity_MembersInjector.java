package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PublicSeaListActivity_MembersInjector
    implements MembersInjector<PublicSeaListActivity> {
  private final Provider<PublicSeaListPresenter> mPresenterProvider;

  public PublicSeaListActivity_MembersInjector(
      Provider<PublicSeaListPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PublicSeaListActivity> create(
      Provider<PublicSeaListPresenter> mPresenterProvider) {
    return new PublicSeaListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PublicSeaListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
