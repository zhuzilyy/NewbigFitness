package com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddMembersFollowActivity_MembersInjector
    implements MembersInjector<AddMembersFollowActivity> {
  private final Provider<AddMembersFollowActivityPresenter> mPresenterProvider;

  public AddMembersFollowActivity_MembersInjector(
      Provider<AddMembersFollowActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddMembersFollowActivity> create(
      Provider<AddMembersFollowActivityPresenter> mPresenterProvider) {
    return new AddMembersFollowActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddMembersFollowActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
