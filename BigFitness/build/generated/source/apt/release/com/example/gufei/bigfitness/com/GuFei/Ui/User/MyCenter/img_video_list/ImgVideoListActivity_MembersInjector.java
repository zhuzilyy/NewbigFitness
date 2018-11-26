package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ImgVideoListActivity_MembersInjector
    implements MembersInjector<ImgVideoListActivity> {
  private final Provider<ImgVideoListActivityPresenter> mPresenterProvider;

  public ImgVideoListActivity_MembersInjector(
      Provider<ImgVideoListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ImgVideoListActivity> create(
      Provider<ImgVideoListActivityPresenter> mPresenterProvider) {
    return new ImgVideoListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ImgVideoListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
