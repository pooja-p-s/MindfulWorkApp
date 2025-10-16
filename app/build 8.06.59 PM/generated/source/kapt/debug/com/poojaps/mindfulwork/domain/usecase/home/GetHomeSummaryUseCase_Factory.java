package com.poojaps.mindfulwork.domain.usecase.home;

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
public final class GetHomeSummaryUseCase_Factory implements Factory<GetHomeSummaryUseCase> {
  private final Provider<FocusRepository> focusRepoProvider;

  private final Provider<MoodRepository> moodRepoProvider;

  private GetHomeSummaryUseCase_Factory(Provider<FocusRepository> focusRepoProvider,
      Provider<MoodRepository> moodRepoProvider) {
    this.focusRepoProvider = focusRepoProvider;
    this.moodRepoProvider = moodRepoProvider;
  }

  @Override
  public GetHomeSummaryUseCase get() {
    return newInstance(focusRepoProvider.get(), moodRepoProvider.get());
  }

  public static GetHomeSummaryUseCase_Factory create(Provider<FocusRepository> focusRepoProvider,
      Provider<MoodRepository> moodRepoProvider) {
    return new GetHomeSummaryUseCase_Factory(focusRepoProvider, moodRepoProvider);
  }

  public static GetHomeSummaryUseCase newInstance(FocusRepository focusRepo,
      MoodRepository moodRepo) {
    return new GetHomeSummaryUseCase(focusRepo, moodRepo);
  }
}
