package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.local.db.AppDatabase;
import com.poojaps.mindfulwork.data.repository.MoodRepository;
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
public final class AppModule_ProvideMoodRepositoryFactory implements Factory<MoodRepository> {
  private final Provider<AppDatabase> dbProvider;

  private AppModule_ProvideMoodRepositoryFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public MoodRepository get() {
    return provideMoodRepository(dbProvider.get());
  }

  public static AppModule_ProvideMoodRepositoryFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideMoodRepositoryFactory(dbProvider);
  }

  public static MoodRepository provideMoodRepository(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMoodRepository(db));
  }
}
