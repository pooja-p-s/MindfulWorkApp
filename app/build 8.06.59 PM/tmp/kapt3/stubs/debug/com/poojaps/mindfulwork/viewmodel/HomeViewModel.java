package com.poojaps.mindfulwork.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u0016H\u0082@\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/poojaps/mindfulwork/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "getHomeSummary", "Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase;", "getQuoteOfDay", "error/NonExistentClass", "<init>", "(Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "_homeSummary", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/poojaps/mindfulwork/domain/usecase/home/GetHomeSummaryUseCase$HomeSummary;", "homeSummary", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_quote", "LGetQuoteOfDayUseCase$QuoteDto;", "quote", "getQuote", "refreshJob", "Lkotlinx/coroutines/Job;", "loadHome", "", "epochMs", "", "loadQuote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadQuoteDaily", "onCleared", "app_debug"})
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
    private final kotlinx.coroutines.flow.MutableStateFlow<GetQuoteOfDayUseCase.QuoteDto> _quote = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<GetQuoteOfDayUseCase.QuoteDto> quote = null;
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
    public final kotlinx.coroutines.flow.StateFlow<GetQuoteOfDayUseCase.QuoteDto> getQuote() {
        return null;
    }
    
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