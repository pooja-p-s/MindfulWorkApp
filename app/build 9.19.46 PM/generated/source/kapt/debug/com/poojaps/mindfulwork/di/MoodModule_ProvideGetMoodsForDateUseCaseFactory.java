package com.poojaps.mindfulwork.di;

import com.poojaps.mindfulwork.data.repository.MoodRepository;
import com.poojaps.mindfulwork.domain.usecase.mood.GetMoodsForDateUseCase;
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
public final class MoodModule_ProvideGetMoodsForDateUseCaseFactory implements Factory<GetMoodsForDateUseCase> {
  private final Provider<MoodRepository> repoProvider;

  private MoodModule_ProvideGetMoodsForDateUseCaseFactory(Provider<MoodRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetMoodsForDateUseCase get() {
    return provideGetMoodsForDateUseCase(repoProvider.get());
  }

  public static MoodModule_ProvideGetMoodsForDateUseCaseFactory create(
      Provider<MoodRepository> repoProvider) {
    return new MoodModule_ProvideGetMoodsForDateUseCaseFactory(repoProvider);
  }

  public static GetMoodsForDateUseCase provideGetMoodsForDateUseCase(MoodRepository repo) {
    return Preconditions.checkNotNullFromProvides(MoodModule.INSTANCE.provideGetMoodsForDateUseCase(repo));
  }
}
