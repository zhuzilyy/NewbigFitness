package com.example.gufei.bigfitness.base;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Base2Activity_MembersInjector<T extends BasePresenter>
    implements MembersInjector<Base2Activity<T>> {
  private final Provider<T> mPresenterProvider;

  public Base2Activity_MembersInjector(Provider<T> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <T extends BasePresenter> MembersInjector<Base2Activity<T>> create(
      Provider<T> mPresenterProvider) {
    return new Base2Activity_MembersInjector<T>(mPresenterProvider);
  }

  @Override
  public void injectMembers(Base2Activity<T> instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static <T extends BasePresenter> void injectMPresenter(
      Base2Activity<T> instance, Provider<T> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
