package com.poojaps.mindfulwork.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0087@\u00a2\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/poojaps/mindfulwork/data/repository/FocusRepository;", "", "dao", "Lcom/poojaps/mindfulwork/data/local/dao/FocusSessionDao;", "<init>", "(Lcom/poojaps/mindfulwork/data/local/dao/FocusSessionDao;)V", "insert", "", "session", "Lcom/poojaps/mindfulwork/data/local/entity/FocusSessionEntity;", "(Lcom/poojaps/mindfulwork/data/local/entity/FocusSessionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsForDay", "", "epochMillis", "", "zoneId", "Ljava/time/ZoneId;", "(JLjava/time/ZoneId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeeklySessions", "fromDateEpoch", "toDateEpoch", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recentSessions", "Lkotlinx/coroutines/flow/Flow;", "limit", "", "deleteById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FocusRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.local.dao.FocusSessionDao dao = null;
    
    public FocusRepository(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.dao.FocusSessionDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionsForDay(long epochMillis, @org.jetbrains.annotations.NotNull()
    java.time.ZoneId zoneId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWeeklySessions(long fromDateEpoch, long toDateEpoch, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity>> recentSessions(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}