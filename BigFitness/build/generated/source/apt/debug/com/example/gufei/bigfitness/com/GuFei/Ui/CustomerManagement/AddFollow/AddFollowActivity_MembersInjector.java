package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddFollowActivity_MembersInjector implements MembersInjector<AddFollowActivity> {
  private final Provider<AddFollowActivityPresenter> mPresenterProvider;

  public AddFollowActivity_MembersInjector(
      Provider<AddFollowActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddFollowActivity> create(
      Provider<AddFollowActivityPresenter> mPresenterProvider) {
    return new AddFollowActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddFollowActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
