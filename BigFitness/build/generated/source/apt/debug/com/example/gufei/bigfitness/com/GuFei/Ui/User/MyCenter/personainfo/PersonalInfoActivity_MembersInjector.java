package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalInfoActivity_MembersInjector
    implements MembersInjector<PersonalInfoActivity> {
  private final Provider<PersonalInfoActivityPresenter> mPresenterProvider;

  public PersonalInfoActivity_MembersInjector(
      Provider<PersonalInfoActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PersonalInfoActivity> create(
      Provider<PersonalInfoActivityPresenter> mPresenterProvider) {
    return new PersonalInfoActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PersonalInfoActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.Base2Activity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
