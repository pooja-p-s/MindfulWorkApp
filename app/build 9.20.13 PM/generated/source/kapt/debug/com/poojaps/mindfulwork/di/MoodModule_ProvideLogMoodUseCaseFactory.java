package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.repository.MoodRepository;
import com.poojaps.mindfulwork.domain.usecase.mood.LogMoodUseCase;
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
public final class MoodModule_ProvideLogMoodUseCaseFactory implements Factory<LogMoodUseCase> {
  private final Provider<MoodRepository> repoProvider;

  private MoodModule_ProvideLogMoodUseCaseFactory(Provider<MoodRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public LogMoodUseCase get() {
    return provideLogMoodUseCase(repoProvider.get());
  }

  public static MoodModule_ProvideLogMoodUseCaseFactory create(
      Provider<MoodRepository> repoProvider) {
    return new MoodModule_ProvideLogMoodUseCaseFactory(repoProvider);
  }

  public static LogMoodUseCase provideLogMoodUseCase(MoodRepository repo) {
    return Preconditions.checkNotNullFromProvides(MoodModule.INSTANCE.provideLogMoodUseCase(repo));
  }
}
