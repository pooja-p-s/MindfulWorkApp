package com.poojaps.mindfulwork.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/poojaps/mindfulwork/data/repository/QuoteRepository;", "", "dao", "Lcom/poojaps/mindfulwork/data/local/dao/QuoteDao;", "<init>", "(Lcom/poojaps/mindfulwork/data/local/dao/QuoteDao;)V", "predefinedQuotes", "", "Lcom/poojaps/mindfulwork/data/local/entity/QuoteEntity;", "getPredefinedQuotes", "()Ljava/util/List;", "preload", "", "quotes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuoteForToday", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class QuoteRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.local.dao.QuoteDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.poojaps.mindfulwork.data.local.entity.QuoteEntity> predefinedQuotes = null;
    
    public QuoteRepository(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.local.dao.QuoteDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.poojaps.mindfulwork.data.local.entity.QuoteEntity> getPredefinedQuotes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object preload(@org.jetbrains.annotations.NotNull()
    java.util.List<com.poojaps.mindfulwork.data.local.entity.QuoteEntity> quotes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getQuoteForToday(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.poojaps.mindfulwork.data.local.entity.QuoteEntity> $completion) {
        return null;
    }
}