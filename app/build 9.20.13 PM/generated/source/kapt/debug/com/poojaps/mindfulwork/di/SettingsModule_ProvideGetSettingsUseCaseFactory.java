package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.prefs.SettingsDataStore;
import com.poojaps.mindfulwork.domain.usecase.settings.GetSettingsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class SettingsModule_ProvideGetSettingsUseCaseFactory implements Factory<GetSettingsUseCase> {
  private final Provider<SettingsDataStore> dataStoreProvider;

  private SettingsModule_ProvideGetSettingsUseCaseFactory(
      Provider<SettingsDataStore> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public GetSettingsUseCase get() {
    return provideGetSettingsUseCase(dataStoreProvider.get());
  }

  public static SettingsModule_ProvideGetSettingsUseCaseFactory create(
      Provider<SettingsDataStore> dataStoreProvider) {
    return new SettingsModule_ProvideGetSettingsUseCaseFactory(dataStoreProvider);
  }

  public static GetSettingsUseCase provideGetSettingsUseCase(SettingsDataStore dataStore) {
    return Preconditions.checkNotNullFromProvides(SettingsModule.INSTANCE.provideGetSettingsUseCase(dataStore));
  }
}
