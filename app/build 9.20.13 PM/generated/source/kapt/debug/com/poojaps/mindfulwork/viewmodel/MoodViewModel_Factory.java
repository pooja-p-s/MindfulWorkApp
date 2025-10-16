package com.poojaps.mindfulwork.viewmodel;

import com.poojaps.mindfulwork.domain.usecase.mood.GetMoodsForDateUseCase;
import com.poojaps.mindfulwork.domain.usecase.mood.LogMoodUseCase;
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
public final class MoodViewModel_Factory implements Factory<MoodViewModel> {
  private final Provider<LogMoodUseCase> logMoodUseCaseProvider;

  private final Provider<GetMoodsForDateUseCase> getMoodsForDateUseCaseProvider;

  private MoodViewModel_Factory(Provider<LogMoodUseCase> logMoodUseCaseProvider,
      Provider<GetMoodsForDateUseCase> getMoodsForDateUseCaseProvider) {
    this.logMoodUseCaseProvider = logMoodUseCaseProvider;
    this.getMoodsForDateUseCaseProvider = getMoodsForDateUseCaseProvider;
  }

  @Override
  public MoodViewModel get() {
    return newInstance(logMoodUseCaseProvider.get(), getMoodsForDateUseCaseProvider.get());
  }

  public static MoodViewModel_Factory create(Provider<LogMoodUseCase> logMoodUseCaseProvider,
      Provider<GetMoodsForDateUseCase> getMoodsForDateUseCaseProvider) {
    return new MoodViewModel_Factory(logMoodUseCaseProvider, getMoodsForDateUseCaseProvider);
  }

  public static MoodViewModel newInstance(LogMoodUseCase logMoodUseCase,
      GetMoodsForDateUseCase getMoodsForDateUseCase) {
    return new MoodViewModel(logMoodUseCase, getMoodsForDateUseCase);
  }
}
