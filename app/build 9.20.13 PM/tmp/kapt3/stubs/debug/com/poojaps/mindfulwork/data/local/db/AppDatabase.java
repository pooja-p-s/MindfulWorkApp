package com.poojaps.mindfulwork.data.local.db;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/poojaps/mindfulwork/data/local/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "focusSessionDao", "Lcom/poojaps/mindfulwork/data/local/dao/FocusSessionDao;", "moodDao", "Lcom/poojaps/mindfulwork/data/local/dao/MoodDao;", "quoteDao", "Lcom/poojaps/mindfulwork/data/local/dao/QuoteDao;", "app_debug"})
@androidx.room.Database(entities = {com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity.class, com.poojaps.mindfulwork.data.local.entity.MoodEntity.class, com.poojaps.mindfulwork.data.local.entity.QuoteEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.poojaps.mindfulwork.data.local.dao.FocusSessionDao focusSessionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.poojaps.mindfulwork.data.local.dao.MoodDao moodDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.poojaps.mindfulwork.data.local.dao.QuoteDao quoteDao();
}