package com.poojaps.mindfulwork.di;

import android.content.Context;
import com.poojaps.mindfulwork.data.prefs.SettingsDataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideSettingsDataStoreFactory implements Factory<SettingsDataStore> {
  private final Provider<Context> contextProvider;

  private AppModule_ProvideSettingsDataStoreFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SettingsDataStore get() {
    return provideSettingsDataStore(contextProvider.get());
  }

  public static AppModule_ProvideSettingsDataStoreFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideSettingsDataStoreFactory(contextProvider);
  }

  public static SettingsDataStore provideSettingsDataStore(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSettingsDataStore(context));
  }
}
