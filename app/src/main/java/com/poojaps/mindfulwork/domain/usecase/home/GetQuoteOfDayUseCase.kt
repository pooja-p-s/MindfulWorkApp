package com.poojaps.mindfulwork.domain.usecase.home

import com.poojaps.mindfulwork.data.repository.QuoteRepository
import javax.inject.Inject

class GetQuoteOfDayUseCase @Inject constructor(
    private val repo: QuoteRepository
) {
    suspend operator fun invoke(): QuoteDto? {

        var quote = repo.getQuoteForToday()

        if (quote == null) {
            repo.preload()
            quote = repo.getQuoteForToday()
        }

        return quote?.let {
            QuoteDto(text = it.text, author = it.author)
        }
    }

    data class QuoteDto(val text: String, val author: String?)
}
