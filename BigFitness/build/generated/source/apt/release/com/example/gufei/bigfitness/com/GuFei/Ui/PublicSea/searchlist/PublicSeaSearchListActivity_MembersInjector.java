package com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PublicSeaSearchListActivity_MembersInjector
    implements MembersInjector<PublicSeaSearchListActivity> {
  private final Provider<PublicSeaSearchListPresenter> mPresenterProvider;

  public PublicSeaSearchListActivity_MembersInjector(
      Provider<PublicSeaSearchListPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PublicSeaSearchListActivity> create(
      Provider<PublicSeaSearchListPresenter> mPresenterProvider) {
    return new PublicSeaSearchListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PublicSeaSearchListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
