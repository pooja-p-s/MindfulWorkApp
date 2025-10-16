package com.poojaps.mindfulwork.domain.usecase;

import com.poojaps.mindfulwork.data.repository.FocusRepository;
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
public final class GetTodaySummaryUseCase_Factory implements Factory<GetTodaySummaryUseCase> {
  private final Provider<FocusRepository> repoProvider;

  private GetTodaySummaryUseCase_Factory(Provider<FocusRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetTodaySummaryUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetTodaySummaryUseCase_Factory create(Provider<FocusRepository> repoProvider) {
    return new GetTodaySummaryUseCase_Factory(repoProvider);
  }

  public static GetTodaySummaryUseCase newInstance(FocusRepository repo) {
    return new GetTodaySummaryUseCase(repo);
  }
}
