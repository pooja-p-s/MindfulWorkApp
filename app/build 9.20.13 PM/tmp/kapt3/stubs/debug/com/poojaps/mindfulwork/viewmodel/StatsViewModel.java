package com.poojaps.mindfulwork.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/poojaps/mindfulwork/viewmodel/StatsViewModel;", "Landroidx/lifecycle/ViewModel;", "getWeeklyStats", "Lcom/poojaps/mindfulwork/domain/usecase/stats/GetWeeklyStatsUseCase;", "<init>", "(Lcom/poojaps/mindfulwork/domain/usecase/stats/GetWeeklyStatsUseCase;)V", "_weeklyStats", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/poojaps/mindfulwork/domain/usecase/stats/GetWeeklyStatsUseCase$DailyStat;", "weeklyStats", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "loadWeeklyStats", "", "todayEpochMs", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class StatsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase getWeeklyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase.DailyStat>> _weeklyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase.DailyStat>> weeklyStats = null;
    
    @javax.inject.Inject()
    public StatsViewModel(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase getWeeklyStats) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase.DailyStat>> getWeeklyStats() {
        return null;
    }
    
    public final void loadWeeklyStats(long todayEpochMs) {
    }
}