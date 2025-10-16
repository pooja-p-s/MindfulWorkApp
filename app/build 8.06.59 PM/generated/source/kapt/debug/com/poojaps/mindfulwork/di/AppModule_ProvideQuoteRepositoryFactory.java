package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.local.db.AppDatabase;
import com.poojaps.mindfulwork.data.repository.QuoteRepository;
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
public final class AppModule_ProvideQuoteRepositoryFactory implements Factory<QuoteRepository> {
  private final Provider<AppDatabase> dbProvider;

  private AppModule_ProvideQuoteRepositoryFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public QuoteRepository get() {
    return provideQuoteRepository(dbProvider.get());
  }

  public static AppModule_ProvideQuoteRepositoryFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideQuoteRepositoryFactory(dbProvider);
  }

  public static QuoteRepository provideQuoteRepository(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideQuoteRepository(db));
  }
}
