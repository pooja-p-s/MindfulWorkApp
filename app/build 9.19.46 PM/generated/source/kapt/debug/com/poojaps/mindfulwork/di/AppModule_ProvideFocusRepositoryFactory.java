package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.local.db.AppDatabase;
import com.poojaps.mindfulwork.data.repository.FocusRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideFocusRepositoryFactory implements Factory<FocusRepository> {
  private final Provider<AppDatabase> dbProvider;

  private AppModule_ProvideFocusRepositoryFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FocusRepository get() {
    return provideFocusRepository(dbProvider.get());
  }

  public static AppModule_ProvideFocusRepositoryFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideFocusRepositoryFactory(dbProvider);
  }

  public static FocusRepository provideFocusRepository(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFocusRepository(db));
  }
}
