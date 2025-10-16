package com.poojaps.mindfulwork.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/poojaps/mindfulwork/di/AppModule;", "", "<init>", "()V", "provideDatabase", "Lcom/poojaps/mindfulwork/data/local/db/AppDatabase;", "context", "Landroid/content/Context;", "provideFocusRepository", "Lcom/poojaps/mindfulwork/data/repository/FocusRepository;", "db", "provideMoodRepository", "Lcom/poojaps/mindfulwork/data/repository/MoodRepository;", "provideQuoteRepository", "Lcom/poojaps/mindfulwork/data/repository/QuoteRepository;", "provideSettingsDataStore", "Lcom/poojaps/mindfulwork/data/prefs/SettingsDataStore;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.poojaps.mindfulwork.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.local.db.AppDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.repository.FocusRepository provideFocusRepository(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.repository.MoodRepository provideMoodRepository(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.repository.QuoteRepository provideQuoteRepository(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.poojaps.mindfulwork.data.prefs.SettingsDataStore provideSettingsDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}