package com.example.gufei.bigfitness.com.GuFei.Moudel;

import com.example.gufei.bigfitness.App;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideApplicationContextFactory implements Factory<App> {
  private final AppModule module;

  public AppModule_ProvideApplicationContextFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public App get() {
    return Preconditions.checkNotNull(
        module.provideApplicationContext(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<App> create(AppModule module) {
    return new AppModule_ProvideApplicationContextFactory(module);
  }
}
