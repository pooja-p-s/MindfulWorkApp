package com.poojaps.mindfulwork.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/poojaps/mindfulwork/viewmodel/MoodViewModel;", "Landroidx/lifecycle/ViewModel;", "logMoodUseCase", "Lcom/poojaps/mindfulwork/domain/usecase/mood/LogMoodUseCase;", "getMoodsForDateUseCase", "Lcom/poojaps/mindfulwork/domain/usecase/mood/GetMoodsForDateUseCase;", "<init>", "(Lcom/poojaps/mindfulwork/domain/usecase/mood/LogMoodUseCase;Lcom/poojaps/mindfulwork/domain/usecase/mood/GetMoodsForDateUseCase;)V", "_moodsForDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/poojaps/mindfulwork/data/local/entity/MoodEntity;", "moodsForDate", "Lkotlinx/coroutines/flow/StateFlow;", "getMoodsForDate", "()Lkotlinx/coroutines/flow/StateFlow;", "logMood", "", "moodDate", "", "moodTs", "", "emoji", "label", "loadMoodsForDate", "date", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MoodViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.mood.LogMoodUseCase logMoodUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.poojaps.mindfulwork.domain.usecase.mood.GetMoodsForDateUseCase getMoodsForDateUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.poojaps.mindfulwork.data.local.entity.MoodEntity>> _moodsForDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.poojaps.mindfulwork.data.local.entity.MoodEntity>> moodsForDate = null;
    
    @javax.inject.Inject()
    public MoodViewModel(@org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.mood.LogMoodUseCase logMoodUseCase, @org.jetbrains.annotations.NotNull()
    com.poojaps.mindfulwork.domain.usecase.mood.GetMoodsForDateUseCase getMoodsForDateUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.poojaps.mindfulwork.data.local.entity.MoodEntity>> getMoodsForDate() {
        return null;
    }
    
    public final void logMood(@org.jetbrains.annotations.NotNull()
    java.lang.String moodDate, long moodTs, @org.jetbrains.annotations.NotNull()
    java.lang.String emoji, @org.jetbrains.annotations.NotNull()
    java.lang.String label) {
    }
    
    public final void loadMoodsForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
}