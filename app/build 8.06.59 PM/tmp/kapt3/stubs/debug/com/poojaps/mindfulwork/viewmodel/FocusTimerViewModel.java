package com.poojaps.mindfulwork.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/poojaps/mindfulwork/viewmodel/FocusTimerViewModel;", "Landroidx/lifecycle/ViewModel;", "saveSession", "Lcom/poojaps/mindfulwork/domain/usecase/SaveFocusSessionUseCase;", "getTodaySummary", "Lcom/poojaps/mindfulwork/domain/usecase/GetTodaySummaryUseCase;", "<init>", "(Lcom/poojaps/mindfulwork/domain/usecase/SaveFocusSessionUseCase;Lcom/poojaps/mindfulwork/domain/usecase/GetTodaySummaryUseCase;)V", "_todaySummary", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/poojaps/mindfulwork/viewmodel/FocusTimerViewModel$TodaySummary;", "todaySummary", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "", "startTs", "", "endTs", "durationSec", "", "completed", "", "(JLjava/lang/Long;IZ)V", "loadTodaySummary", "epochMs", "TodaySummary", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FocusTimerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.SaveFocusSessionUseCase saveSession = null;
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.GetTodaySummaryUseCase getTodaySummary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.poojaps.mindfulwork.viewmodel.FocusTimerViewModel.TodaySummary> _todaySummary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.poojaps.mindfulwork.viewmodel.FocusTimerViewModel.TodaySummary> todaySummary = null;
    
    @javax.inject.Inject()
    public FocusTimerViewModel(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.SaveFocusSessionUseCase saveSession, @org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.GetTodaySummaryUseCase getTodaySummary) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.poojaps.mindfulwork.viewmodel.FocusTimerViewModel.TodaySummary> getTodaySummary() {
        return null;
    }
    
    public final void saveSession(long startTs, @org.jetbrains.annotations.Nullable()
    java.lang.Long endTs, int durationSec, boolean completed) {
    }
    
    public final void loadTodaySummary(long epochMs) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/poojaps/mindfulwork/viewmodel/FocusTimerViewModel$TodaySummary;", "", "totalSeconds", "", "sessionsCount", "<init>", "(II)V", "getTotalSeconds", "()I", "getSessionsCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class TodaySummary {
        private final int totalSeconds = 0;
        private final int sessionsCount = 0;
        
        public TodaySummary(int totalSeconds, int sessionsCount) {
            super();
        }
        
        public final int getTotalSeconds() {
            return 0;
        }
        
        public final int getSessionsCount() {
            return 0;
        }
        
        public TodaySummary() {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.poojaps.mindfulwork.viewmodel.FocusTimerViewModel.TodaySummary copy(int totalSeconds, int sessionsCount) {
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