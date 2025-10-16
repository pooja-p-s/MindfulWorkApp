package com.poojaps.mindfulwork.domain.usecase.stats;

import com.poojaps.mindfulwork.data.repository.FocusRepository;
import com.poojaps.mindfulwork.data.repository.MoodRepository;
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
public final class GetWeeklyStatsUseCase_Factory implements Factory<GetWeeklyStatsUseCase> {
  private final Provider<FocusRepository> focusRepoProvider;

  private final Provider<MoodRepository> moodRepoProvider;

  private GetWeeklyStatsUseCase_Factory(Provider<FocusRepository> focusRepoProvider,
      Provider<MoodRepository> moodRepoProvider) {
    this.focusRepoProvider = focusRepoProvider;
    this.moodRepoProvider = moodRepoProvider;
  }

  @Override
  public GetWeeklyStatsUseCase get() {
    return newInstance(focusRepoProvider.get(), moodRepoProvider.get());
  }

  public static GetWeeklyStatsUseCase_Factory create(Provider<FocusRepository> focusRepoProvider,
      Provider<MoodRepository> moodRepoProvider) {
    return new GetWeeklyStatsUseCase_Factory(focusRepoProvider, moodRepoProvider);
  }

  public static GetWeeklyStatsUseCase newInstance(FocusRepository focusRepo,
      MoodRepository moodRepo) {
    return new GetWeeklyStatsUseCase(focusRepo, moodRepo);
  }
}
