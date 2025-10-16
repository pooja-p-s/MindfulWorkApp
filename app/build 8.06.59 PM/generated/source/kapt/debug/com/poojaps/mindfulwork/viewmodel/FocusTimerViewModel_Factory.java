package com.poojaps.mindfulwork.viewmodel;

import com.poojaps.mindfulwork.domain.usecase.GetTodaySummaryUseCase;
import com.poojaps.mindfulwork.domain.usecase.SaveFocusSessionUseCase;
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
public final class FocusTimerViewModel_Factory implements Factory<FocusTimerViewModel> {
  private final Provider<SaveFocusSessionUseCase> saveSessionProvider;

  private final Provider<GetTodaySummaryUseCase> getTodaySummaryProvider;

  private FocusTimerViewModel_Factory(Provider<SaveFocusSessionUseCase> saveSessionProvider,
      Provider<GetTodaySummaryUseCase> getTodaySummaryProvider) {
    this.saveSessionProvider = saveSessionProvider;
    this.getTodaySummaryProvider = getTodaySummaryProvider;
  }

  @Override
  public FocusTimerViewModel get() {
    return newInstance(saveSessionProvider.get(), getTodaySummaryProvider.get());
  }

  public static FocusTimerViewModel_Factory create(
      Provider<SaveFocusSessionUseCase> saveSessionProvider,
      Provider<GetTodaySummaryUseCase> getTodaySummaryProvider) {
    return new FocusTimerViewModel_Factory(saveSessionProvider, getTodaySummaryProvider);
  }

  public static FocusTimerViewModel newInstance(SaveFocusSessionUseCase saveSession,
      GetTodaySummaryUseCase getTodaySummary) {
    return new FocusTimerViewModel(saveSession, getTodaySummary);
  }
}
