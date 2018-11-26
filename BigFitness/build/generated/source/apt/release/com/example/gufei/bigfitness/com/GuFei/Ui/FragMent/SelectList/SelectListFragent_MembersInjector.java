package com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SelectListFragent_MembersInjector implements MembersInjector<SelectListFragent> {
  private final Provider<SelectListPresenter> mPresenterProvider;

  public SelectListFragent_MembersInjector(Provider<SelectListPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<SelectListFragent> create(
      Provider<SelectListPresenter> mPresenterProvider) {
    return new SelectListFragent_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(SelectListFragent instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
