package com.poojaps.mindfulwork.domain.usecase.settings;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/poojaps/mindfulwork/domain/usecase/settings/GetSettingsUseCase;", "", "dataStore", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;", "<init>", "(Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDto;", "app_debug"})
public final class GetSettingsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.prefs.SettingsDataStore dataStore = null;
    
    @javax.inject.Inject()
    public GetSettingsUseCase(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.prefs.SettingsDataStore dataStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.poojaps.mindfulwork.data.prefs.SettingsDto> invoke() {
        return null;
    }
}