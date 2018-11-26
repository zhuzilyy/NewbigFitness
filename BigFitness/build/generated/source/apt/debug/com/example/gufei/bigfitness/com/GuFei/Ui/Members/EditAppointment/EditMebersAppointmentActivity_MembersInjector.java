package com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class EditMebersAppointmentActivity_MembersInjector
    implements MembersInjector<EditMebersAppointmentActivity> {
  private final Provider<EditMebersAppointmentActivityPresenter> mPresenterProvider;

  public EditMebersAppointmentActivity_MembersInjector(
      Provider<EditMebersAppointmentActivityPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<EditMebersAppointmentActivity> create(
      Provider<EditMebersAppointmentActivityPresenter> mPresenterProvider) {
    return new EditMebersAppointmentActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(EditMebersAppointmentActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.example.gufei.bigfitness.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
