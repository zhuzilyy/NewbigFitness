package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ImgVideoListActivityPresenter_Factory
    implements Factory<ImgVideoListActivityPresenter> {
  private final MembersInjector<ImgVideoListActivityPresenter>
      imgVideoListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public ImgVideoListActivityPresenter_Factory(
      MembersInjector<ImgVideoListActivityPresenter> imgVideoListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert imgVideoListActivityPresenterMembersInjector != null;
    this.imgVideoListActivityPresenterMembersInjector =
        imgVideoListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public ImgVideoListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        imgVideoListActivityPresenterMembersInjector,
        new ImgVideoListActivityPresenter(apiProvider.get()));
  }

  public static Factory<ImgVideoListActivityPresenter> create(
      MembersInjector<ImgVideoListActivityPresenter> imgVideoListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new ImgVideoListActivityPresenter_Factory(
        imgVideoListActivityPresenterMembersInjector, apiProvider);
  }
}
