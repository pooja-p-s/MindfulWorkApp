package com.poojaps.mindfulwork.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/poojaps/mindfulwork/di/SettingsModule;", "", "<init>", "()V", "provideGetSettingsUseCase", "Lcom/poojaps/mindfulwork/domain/usecase/settings/GetSettingsUseCase;", "dataStore", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;", "provideUpdateSettingsUseCase", "Lcom/poojaps/mindfulwork/domain/usecase/settings/UpdateSettingsUseCase;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class SettingsModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.poojaps.mindfulwork.di.SettingsModule INSTANCE = null;
    
    private SettingsModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.domain.usecase.settings.GetSettingsUseCase provideGetSettingsUseCase(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.prefs.SettingsDataStore dataStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.domain.usecase.settings.UpdateSettingsUseCase provideUpdateSettingsUseCase(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.prefs.SettingsDataStore dataStore) {
        return null;
    }
}