package com.poojaps.mindfulwork.viewmodel;

import com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase;
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
public final class StatsViewModel_Factory implements Factory<StatsViewModel> {
  private final Provider<GetWeeklyStatsUseCase> getWeeklyStatsProvider;

  private StatsViewModel_Factory(Provider<GetWeeklyStatsUseCase> getWeeklyStatsProvider) {
    this.getWeeklyStatsProvider = getWeeklyStatsProvider;
  }

  @Override
  public StatsViewModel get() {
    return newInstance(getWeeklyStatsProvider.get());
  }

  public static StatsViewModel_Factory create(
      Provider<GetWeeklyStatsUseCase> getWeeklyStatsProvider) {
    return new StatsViewModel_Factory(getWeeklyStatsProvider);
  }

  public static StatsViewModel newInstance(GetWeeklyStatsUseCase getWeeklyStats) {
    return new StatsViewModel(getWeeklyStats);
  }
}
