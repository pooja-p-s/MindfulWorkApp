package com.poojaps.mindfulwork.domain.usecase.mood;

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
public final class LogMoodUseCase_Factory implements Factory<LogMoodUseCase> {
  private final Provider<MoodRepository> repoProvider;

  private LogMoodUseCase_Factory(Provider<MoodRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public LogMoodUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static LogMoodUseCase_Factory create(Provider<MoodRepository> repoProvider) {
    return new LogMoodUseCase_Factory(repoProvider);
  }

  public static LogMoodUseCase newInstance(MoodRepository repo) {
    return new LogMoodUseCase(repo);
  }
}
