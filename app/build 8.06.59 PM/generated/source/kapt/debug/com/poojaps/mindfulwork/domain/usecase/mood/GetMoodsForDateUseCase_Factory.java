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
public final class GetMoodsForDateUseCase_Factory implements Factory<GetMoodsForDateUseCase> {
  private final Provider<MoodRepository> repoProvider;

  private GetMoodsForDateUseCase_Factory(Provider<MoodRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetMoodsForDateUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetMoodsForDateUseCase_Factory create(Provider<MoodRepository> repoProvider) {
    return new GetMoodsForDateUseCase_Factory(repoProvider);
  }

  public static GetMoodsForDateUseCase newInstance(MoodRepository repo) {
    return new GetMoodsForDateUseCase(repo);
  }
}
