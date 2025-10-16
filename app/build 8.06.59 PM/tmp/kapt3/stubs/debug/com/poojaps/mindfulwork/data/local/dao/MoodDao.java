package com.poojaps.mindfulwork.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010\u00c0\u0006\u0003"}, d2 = {"Lcom/poojaps/mindfulwork/data/local/dao/MoodDao;", "", "insert", "", "mood", "Lcom/poojaps/mindfulwork/data/local/entity/MoodEntity;", "(Lcom/poojaps/mindfulwork/data/local/entity/MoodEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByDate", "", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBetweenDates", "from", "to", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MoodDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.entity.MoodEntity mood, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM moods WHERE moodDate = :date ORDER BY moodTs DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.poojaps.mindfulwork.data.local.entity.MoodEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM moods WHERE moodDate BETWEEN :from AND :to ORDER BY moodDate DESC, moodTs DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBetweenDates(@org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String to, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.poojaps.mindfulwork.data.local.entity.MoodEntity>> $completion);
}