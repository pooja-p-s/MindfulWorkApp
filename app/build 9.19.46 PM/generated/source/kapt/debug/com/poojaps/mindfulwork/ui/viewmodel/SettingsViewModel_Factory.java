package com.poojaps.mindfulwork.ui.viewmodel;

import com.poojaps.mindfulwork.domain.usecase.settings.GetSettingsUseCase;
import com.poojaps.mindfulwork.domain.usecase.settings.UpdateSettingsUseCase;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<GetSettingsUseCase> getSettingsProvider;

  private final Provider<UpdateSettingsUseCase> updateSettingsProvider;

  private SettingsViewModel_Factory(Provider<GetSettingsUseCase> getSettingsProvider,
      Provider<UpdateSettingsUseCase> updateSettingsProvider) {
    this.getSettingsProvider = getSettingsProvider;
    this.updateSettingsProvider = updateSettingsProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(getSettingsProvider.get(), updateSettingsProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<GetSettingsUseCase> getSettingsProvider,
      Provider<UpdateSettingsUseCase> updateSettingsProvider) {
    return new SettingsViewModel_Factory(getSettingsProvider, updateSettingsProvider);
  }

  public static SettingsViewModel newInstance(GetSettingsUseCase getSettings,
      UpdateSettingsUseCase updateSettings) {
    return new SettingsViewModel(getSettings, updateSettings);
  }
}
