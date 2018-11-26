package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList;

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
public final class SelectListPresenter_Factory implements Factory<SelectListPresenter> {
  private final MembersInjector<SelectListPresenter> selectListPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public SelectListPresenter_Factory(
      MembersInjector<SelectListPresenter> selectListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert selectListPresenterMembersInjector != null;
    this.selectListPresenterMembersInjector = selectListPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public SelectListPresenter get() {
    return MembersInjectors.injectMembers(
        selectListPresenterMembersInjector, new SelectListPresenter(apiProvider.get()));
  }

  public static Factory<SelectListPresenter> create(
      MembersInjector<SelectListPresenter> selectListPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new SelectListPresenter_Factory(selectListPresenterMembersInjector, apiProvider);
  }
}
