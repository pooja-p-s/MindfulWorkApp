package com.poojaps.mindfulwork.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\'J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015\u00c0\u0006\u0003"}, d2 = {"Lcom/poojaps/mindfulwork/data/local/dao/FocusSessionDao;", "", "insert", "", "session", "Lcom/poojaps/mindfulwork/data/local/entity/FocusSessionEntity;", "(Lcom/poojaps/mindfulwork/data/local/entity/FocusSessionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBetween", "", "from", "", "to", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recent", "Lkotlinx/coroutines/flow/Flow;", "limit", "", "deleteById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface FocusSessionDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM focus_sessions WHERE startTs >= :from AND startTs < :to ORDER BY startTs DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBetween(long from, long to, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM focus_sessions ORDER BY startTs DESC LIMIT :limit")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity>> recent(int limit);
    
    @androidx.room.Query(value = "DELETE FROM focus_sessions WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}