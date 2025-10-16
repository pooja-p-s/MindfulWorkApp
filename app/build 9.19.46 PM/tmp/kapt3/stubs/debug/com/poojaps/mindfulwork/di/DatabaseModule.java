package com.poojaps.mindfulwork.di;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/poojaps/mindfulwork/di/DatabaseModule;", "", "<init>", "()V", "dbInstance", "Lcom/poojaps/mindfulwork/data/local/db/AppDatabase;", "provideDatabase", "context", "Landroid/content/Context;", "provideFocusRepository", "Lcom/poojaps/mindfulwork/data/repository/FocusRepository;", "provideMoodRepository", "Lcom/poojaps/mindfulwork/data/repository/MoodRepository;", "provideQuoteRepository", "Lcom/poojaps/mindfulwork/data/repository/QuoteRepository;", "provideSettingsDataStore", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;", "app_debug"})
public final class DatabaseModule {
    @org.jetbrains.annotations.Nullable()
    private static com.poojaps.mindfulwork.data.local.db.AppDatabase dbInstance;
    @org.jetbrains.annotations.NotNull()
    public static final com.poojaps.mindfulwork.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.local.db.AppDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.repository.FocusRepository provideFocusRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.repository.MoodRepository provideMoodRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.repository.QuoteRepository provideQuoteRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.prefs.SettingsDataStore provideSettingsDataStore(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}