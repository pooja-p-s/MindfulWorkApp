package com.poojaps.mindfulwork.domain.usecase.home;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087B\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase;", "", "focusRepo", "Lcom/poojaps/mindfulwork/data/repository/FocusRepository;", "moodRepo", "Lcom/poojaps/mindfulwork/data/repository/MoodRepository;", "<init>", "(Lcom/poojaps/mindfulwork/data/repository/FocusRepository;Lcom/poojaps/mindfulwork/data/repository/MoodRepository;)V", "invoke", "Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase$HomeSummary;", "epochMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeStreak", "", "sessions", "", "HomeSummary", "app_debug"})
public final class GetHomeSummaryUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.repository.FocusRepository focusRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.data.repository.MoodRepository moodRepo = null;
    
    @javax.inject.Inject()
    public GetHomeSummaryUseCase(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.repository.FocusRepository focusRepo, @org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.data.repository.MoodRepository moodRepo) {
        super();
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(long epochMs, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase.HomeSummary> $completion) {
        return null;
    }
    
    private final int computeStreak(java.util.List<? extends java.lang.Object> sessions) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase$HomeSummary;", "", "totalFocusSeconds", "", "todayMood", "", "streak", "<init>", "(ILjava/lang/String;I)V", "getTotalFocusSeconds", "()I", "getTodayMood", "()Ljava/lang/String;", "getStreak", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class HomeSummary {
        private final int totalFocusSeconds = 0;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String todayMood = null;
        private final int streak = 0;
        
        public HomeSummary(int totalFocusSeconds, @org.jetbrains.annotations.Nullable()
        java.lang.String todayMood, int streak) {
            super();
        }
        
        public final int getTotalFocusSeconds() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTodayMood() {
            return null;
        }
        
        public final int getStreak() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase.HomeSummary copy(int totalFocusSeconds, @org.jetbrains.annotations.Nullable()
        java.lang.String todayMood, int streak) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}