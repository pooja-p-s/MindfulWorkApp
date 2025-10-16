package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.repository.QuoteRepository;
import com.poojaps.mindfulwork.domain.usecase.home.GetQuoteOfDayUseCase;
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
public final class HomeModule_ProvideGetQuoteUseCaseFactory implements Factory<GetQuoteOfDayUseCase> {
  private final Provider<QuoteRepository> repoProvider;

  private HomeModule_ProvideGetQuoteUseCaseFactory(Provider<QuoteRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetQuoteOfDayUseCase get() {
    return provideGetQuoteUseCase(repoProvider.get());
  }

  public static HomeModule_ProvideGetQuoteUseCaseFactory create(
      Provider<QuoteRepository> repoProvider) {
    return new HomeModule_ProvideGetQuoteUseCaseFactory(repoProvider);
  }

  public static GetQuoteOfDayUseCase provideGetQuoteUseCase(QuoteRepository repo) {
    return Preconditions.checkNotNullFromProvides(HomeModule.INSTANCE.provideGetQuoteUseCase(repo));
  }
}
