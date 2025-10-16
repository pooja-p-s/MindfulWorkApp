package com.poojaps.mindfulwork.domain.usecase.settings;

import com.poojaps.mindfulwork.data.prefs.SettingsDataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class GetSettingsUseCase_Factory implements Factory<GetSettingsUseCase> {
  private final Provider<SettingsDataStore> dataStoreProvider;

  private GetSettingsUseCase_Factory(Provider<SettingsDataStore> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public GetSettingsUseCase get() {
    return newInstance(dataStoreProvider.get());
  }

  public static GetSettingsUseCase_Factory create(Provider<SettingsDataStore> dataStoreProvider) {
    return new GetSettingsUseCase_Factory(dataStoreProvider);
  }

  public static GetSettingsUseCase newInstance(SettingsDataStore dataStore) {
    return new GetSettingsUseCase(dataStore);
  }
}
