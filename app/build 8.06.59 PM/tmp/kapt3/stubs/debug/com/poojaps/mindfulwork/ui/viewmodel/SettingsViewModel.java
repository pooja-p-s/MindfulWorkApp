package com.poojaps.mindfulwork.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/poojaps/mindfulwork/ui/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "getSettings", "Lcom/poojaps/mindfulwork/domain/usecase/settings/GetSettingsUseCase;", "updateSettings", "Lcom/poojaps/mindfulwork/domain/usecase/settings/UpdateSettingsUseCase;", "<init>", "(Lcom/poojaps/mindfulwork/domain/usecase/settings/GetSettingsUseCase;Lcom/poojaps/mindfulwork/domain/usecase/settings/UpdateSettingsUseCase;)V", "settings", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDto;", "()Lkotlinx/coroutines/flow/StateFlow;", "setDisplayName", "Lkotlinx/coroutines/Job;", "name", "", "setDarkMode", "enabled", "", "setNotifications", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.settings.UpdateSettingsUseCase updateSettings = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.poojaps.mindfulwork.data.prefs.SettingsDto> settings = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.settings.GetSettingsUseCase getSettings, @org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.settings.UpdateSettingsUseCase updateSettings) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.poojaps.mindfulwork.data.prefs.SettingsDto> getSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setDisplayName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setDarkMode(boolean enabled) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setNotifications(boolean enabled) {
        return null;
    }
}