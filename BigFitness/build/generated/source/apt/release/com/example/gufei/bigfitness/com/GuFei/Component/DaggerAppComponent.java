package com.example.gufei.bigfitness.com.GuFei.Component;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.com.GuFei.Moudel.AppModule;
import com.example.gufei.bigfitness.com.GuFei.Moudel.AppModule_ProvideApplicationContextFactory;
import com.example.gufei.bigfitness.com.GuFei.Moudel.AppModule_ProviderGsonFactory;
import com.example.gufei.bigfitness.com.GuFei.Moudel.AppModule_ProviderNetServiceFactory;
import com.example.gufei.bigfitness.com.GuFei.Moudel.AppModule_ProviderOkHttpClientFactory;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<App> provideApplicationContextProvider;

  private Provider<Gson> providerGsonProvider;

  private Provider<OkHttpClient> providerOkHttpClientProvider;

  private Provider<Api> providerNetServiceProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationContextProvider =
        DoubleCheck.provider(AppModule_ProvideApplicationContextFactory.create(builder.appModule));

    this.providerGsonProvider =
        DoubleCheck.provider(AppModule_ProviderGsonFactory.create(builder.appModule));

    this.providerOkHttpClientProvider =
        DoubleCheck.provider(AppModule_ProviderOkHttpClientFactory.create(builder.appModule));

    this.providerNetServiceProvider =
        DoubleCheck.provider(
            AppModule_ProviderNetServiceFactory.create(
                builder.appModule, providerGsonProvider, providerOkHttpClientProvider));
  }

  @Override
  public void inject(App app) {
    MembersInjectors.<App>noOp().injectMembers(app);
  }

  @Override
  public App getContext() {
    return provideApplicationContextProvider.get();
  }

  @Override
  public Api getApi() {
    return providerNetServiceProvider.get();
  }

  @Override
  public OkHttpClient getOkHttpClient() {
    return providerOkHttpClientProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
