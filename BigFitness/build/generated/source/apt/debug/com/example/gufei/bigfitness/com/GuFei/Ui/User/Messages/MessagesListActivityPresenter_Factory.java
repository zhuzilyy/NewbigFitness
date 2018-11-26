package com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages;

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
public final class MessagesListActivityPresenter_Factory
    implements Factory<MessagesListActivityPresenter> {
  private final MembersInjector<MessagesListActivityPresenter>
      messagesListActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public MessagesListActivityPresenter_Factory(
      MembersInjector<MessagesListActivityPresenter> messagesListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert messagesListActivityPresenterMembersInjector != null;
    this.messagesListActivityPresenterMembersInjector =
        messagesListActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public MessagesListActivityPresenter get() {
    return MembersInjectors.injectMembers(
        messagesListActivityPresenterMembersInjector,
        new MessagesListActivityPresenter(apiProvider.get()));
  }

  public static Factory<MessagesListActivityPresenter> create(
      MembersInjector<MessagesListActivityPresenter> messagesListActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new MessagesListActivityPresenter_Factory(
        messagesListActivityPresenterMembersInjector, apiProvider);
  }
}
