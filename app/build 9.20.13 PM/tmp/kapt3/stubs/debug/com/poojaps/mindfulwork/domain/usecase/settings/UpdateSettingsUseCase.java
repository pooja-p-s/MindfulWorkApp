package com.poojaps.mindfulwork.domain.usecase.settings;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/poojaps/mindfulwork/domain/usecase/settings/UpdateSettingsUseCase;", "", "dataStore", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;", "<init>", "(Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;)V", "updateDisplayName", "", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDarkMode", "enabled", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotifications", "app_debug"})
public final class UpdateSettingsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.prefs.SettingsDataStore dataStore = null;
    
    @javax.inject.Inject()
    public UpdateSettingsUseCase(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.prefs.SettingsDataStore dataStore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDisplayName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDarkMode(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNotifications(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}