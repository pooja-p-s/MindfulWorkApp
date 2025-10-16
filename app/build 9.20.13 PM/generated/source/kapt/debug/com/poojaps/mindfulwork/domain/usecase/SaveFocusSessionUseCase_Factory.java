package com.poojaps.mindfulwork.domain.usecase;

import com.poojaps.mindfulwork.data.repository.FocusRepository;
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
public final class SaveFocusSessionUseCase_Factory implements Factory<SaveFocusSessionUseCase> {
  private final Provider<FocusRepository> focusRepositoryProvider;

  private SaveFocusSessionUseCase_Factory(Provider<FocusRepository> focusRepositoryProvider) {
    this.focusRepositoryProvider = focusRepositoryProvider;
  }

  @Override
  public SaveFocusSessionUseCase get() {
    return newInstance(focusRepositoryProvider.get());
  }

  public static SaveFocusSessionUseCase_Factory create(
      Provider<FocusRepository> focusRepositoryProvider) {
    return new SaveFocusSessionUseCase_Factory(focusRepositoryProvider);
  }

  public static SaveFocusSessionUseCase newInstance(FocusRepository focusRepository) {
    return new SaveFocusSessionUseCase(focusRepository);
  }
}
