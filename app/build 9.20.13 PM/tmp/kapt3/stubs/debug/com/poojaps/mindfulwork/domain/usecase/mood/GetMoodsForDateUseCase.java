package com.poojaps.mindfulwork.domain.usecase.mood;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086B\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/poojaps/mindfulwork/domain/usecase/mood/GetMoodsForDateUseCase;", "", "repo", "Lcom/poojaps/mindfulwork/data/repository/MoodRepository;", "<init>", "(Lcom/poojaps/mindfulwork/data/repository/MoodRepository;)V", "invoke", "", "Lcom/poojaps/mindfulwork/data/local/entity/MoodEntity;", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetMoodsForDateUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.repository.MoodRepository repo = null;
    
    @javax.inject.Inject()
    public GetMoodsForDateUseCase(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.repository.MoodRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.poojaps.mindfulwork.data.local.entity.MoodEntity>> $completion) {
        return null;
    }
}