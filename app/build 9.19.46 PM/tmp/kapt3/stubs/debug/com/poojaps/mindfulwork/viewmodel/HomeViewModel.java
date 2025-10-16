package com.poojaps.mindfulwork.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u000e\u0010\u0018\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/poojaps/mindfulwork/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "getHomeSummary", "Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase;", "getQuoteOfDay", "error/NonExistentClass", "<init>", "(Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "_homeSummary", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase$HomeSummary;", "homeSummary", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_quote", "quote", "getQuote", "refreshJob", "Lkotlinx/coroutines/Job;", "loadHome", "", "epochMs", "", "loadQuote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadQuoteDaily", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase getHomeSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass getQuoteOfDay = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase.HomeSummary> _homeSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase.HomeSummary> homeSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<error.NonExistentClass> _quote = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<error.NonExistentClass> quote = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job refreshJob;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase getHomeSummary, @org.jetbrains.annotations.NotNull()
    error.NonExistentClass getQuoteOfDay) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase.HomeSummary> getHomeSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<error.NonExistentClass> getQuote() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void loadHome(long epochMs) {
    }
    
    private final java.lang.Object loadQuote(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void loadQuoteDaily() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}