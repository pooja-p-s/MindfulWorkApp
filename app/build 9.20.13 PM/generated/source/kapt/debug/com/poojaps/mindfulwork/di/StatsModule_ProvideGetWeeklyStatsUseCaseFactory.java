package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.repository.FocusRepository;
import com.poojaps.mindfulwork.data.repository.MoodRepository;
import com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase;
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
public final class StatsModule_ProvideGetWeeklyStatsUseCaseFactory implements Factory<GetWeeklyStatsUseCase> {
  private final Provider<FocusRepository> focusRepoProvider;

  private final Provider<MoodRepository> moodRepoProvider;

  private StatsModule_ProvideGetWeeklyStatsUseCaseFactory(
      Provider<FocusRepository> focusRepoProvider, Provider<MoodRepository> moodRepoProvider) {
    this.focusRepoProvider = focusRepoProvider;
    this.moodRepoProvider = moodRepoProvider;
  }

  @Override
  public GetWeeklyStatsUseCase get() {
    return provideGetWeeklyStatsUseCase(focusRepoProvider.get(), moodRepoProvider.get());
  }

  public static StatsModule_ProvideGetWeeklyStatsUseCaseFactory create(
      Provider<FocusRepository> focusRepoProvider, Provider<MoodRepository> moodRepoProvider) {
    return new StatsModule_ProvideGetWeeklyStatsUseCaseFactory(focusRepoProvider, moodRepoProvider);
  }

  public static GetWeeklyStatsUseCase provideGetWeeklyStatsUseCase(FocusRepository focusRepo,
      MoodRepository moodRepo) {
    return Preconditions.checkNotNullFromProvides(StatsModule.INSTANCE.provideGetWeeklyStatsUseCase(focusRepo, moodRepo));
  }
}
