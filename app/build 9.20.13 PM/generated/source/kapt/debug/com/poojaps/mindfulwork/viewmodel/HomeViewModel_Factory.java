package com.poojaps.mindfulwork.viewmodel;

import com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import error.NonExistentClass;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetHomeSummaryUseCase> getHomeSummaryProvider;

  private final Provider<NonExistentClass> getQuoteOfDayProvider;

  private HomeViewModel_Factory(Provider<GetHomeSummaryUseCase> getHomeSummaryProvider,
      Provider<NonExistentClass> getQuoteOfDayProvider) {
    this.getHomeSummaryProvider = getHomeSummaryProvider;
    this.getQuoteOfDayProvider = getQuoteOfDayProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getHomeSummaryProvider.get(), getQuoteOfDayProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<GetHomeSummaryUseCase> getHomeSummaryProvider,
      Provider<NonExistentClass> getQuoteOfDayProvider) {
    return new HomeViewModel_Factory(getHomeSummaryProvider, getQuoteOfDayProvider);
  }

  public static HomeViewModel newInstance(GetHomeSummaryUseCase getHomeSummary,
      NonExistentClass getQuoteOfDay) {
    return new HomeViewModel(getHomeSummary, getQuoteOfDay);
  }
}
