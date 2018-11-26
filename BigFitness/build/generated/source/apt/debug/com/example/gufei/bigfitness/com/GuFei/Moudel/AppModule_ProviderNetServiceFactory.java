package com.example.gufei.bigfitness.com.GuFei.Moudel;

import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProviderNetServiceFactory implements Factory<Api> {
  private final AppModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public AppModule_ProviderNetServiceFactory(
      AppModule module, Provider<Gson> gsonProvider, Provider<OkHttpClient> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Api get() {
    return Preconditions.checkNotNull(
        module.providerNetService(gsonProvider.get(), okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Api> create(
      AppModule module, Provider<Gson> gsonProvider, Provider<OkHttpClient> okHttpClientProvider) {
    return new AppModule_ProviderNetServiceFactory(module, gsonProvider, okHttpClientProvider);
  }
}
