package com.poojaps.mindfulwork.domain.usecase.home;

import com.poojaps.mindfulwork.data.repository.QuoteRepository;
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
public final class GetQuoteOfDayUseCase_Factory implements Factory<GetQuoteOfDayUseCase> {
  private final Provider<QuoteRepository> repoProvider;

  private GetQuoteOfDayUseCase_Factory(Provider<QuoteRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetQuoteOfDayUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetQuoteOfDayUseCase_Factory create(Provider<QuoteRepository> repoProvider) {
    return new GetQuoteOfDayUseCase_Factory(repoProvider);
  }

  public static GetQuoteOfDayUseCase newInstance(QuoteRepository repo) {
    return new GetQuoteOfDayUseCase(repo);
  }
}
