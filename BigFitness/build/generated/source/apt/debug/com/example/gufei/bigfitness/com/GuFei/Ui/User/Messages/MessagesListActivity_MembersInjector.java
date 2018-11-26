package com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MessagesListActivity_MembersInjector
    implements MembersInjector<MessagesListActivity> {
  private final Provider<MessagesListActivityPresenter> mPresenterProvider;

  public MessagesListActivity_MembersInjector(
      Provider<MessagesListActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MessagesListActivity> create(
      Provider<MessagesListActivityPresenter> mPresenterProvider) {
    return new MessagesListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MessagesListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
