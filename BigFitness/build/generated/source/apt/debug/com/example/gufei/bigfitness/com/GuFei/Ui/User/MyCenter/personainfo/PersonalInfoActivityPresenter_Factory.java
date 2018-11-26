package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo;

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
public final class PersonalInfoActivityPresenter_Factory
    implements Factory<PersonalInfoActivityPresenter> {
  private final MembersInjector<PersonalInfoActivityPresenter>
      personalInfoActivityPresenterMembersInjector;

  private final Provider<Api> apiProvider;

  public PersonalInfoActivityPresenter_Factory(
      MembersInjector<PersonalInfoActivityPresenter> personalInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    assert personalInfoActivityPresenterMembersInjector != null;
    this.personalInfoActivityPresenterMembersInjector =
        personalInfoActivityPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public PersonalInfoActivityPresenter get() {
    return MembersInjectors.injectMembers(
        personalInfoActivityPresenterMembersInjector,
        new PersonalInfoActivityPresenter(apiProvider.get()));
  }

  public static Factory<PersonalInfoActivityPresenter> create(
      MembersInjector<PersonalInfoActivityPresenter> personalInfoActivityPresenterMembersInjector,
      Provider<Api> apiProvider) {
    return new PersonalInfoActivityPresenter_Factory(
        personalInfoActivityPresenterMembersInjector, apiProvider);
  }
}
