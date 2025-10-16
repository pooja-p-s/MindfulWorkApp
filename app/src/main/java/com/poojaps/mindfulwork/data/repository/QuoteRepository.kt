package com.poojaps.mindfulwork.data.repository

import com.poojaps.mindfulwork.data.local.dao.QuoteDao
import com.poojaps.mindfulwork.data.local.entity.QuoteEntity
import java.util.Calendar

class QuoteRepository(private val dao: QuoteDao) {

    private val predefinedQuotes = listOf(
        QuoteEntity(text = "Focus on being productive instead of busy.", author = "Tim Ferriss"),
        QuoteEntity(text = "Do what you can, with what you have, where you are.", author = "Theodore Roosevelt"),
        QuoteEntity(text = "Discipline is the bridge between goals and accomplishment.", author = "Jim Rohn"),
        QuoteEntity(text = "The secret of getting ahead is getting started.", author = "Mark Twain"),
        QuoteEntity(text = "Don’t count the days, make the days count.", author = "Muhammad Ali"),
        QuoteEntity(text = "It always seems impossible until it’s done.", author = "Nelson Mandela"),
        QuoteEntity(text = "Push yourself, because no one else is going to do it for you.", author = "Unknown"),
        QuoteEntity(text = "Great things are done by a series of small things brought together.", author = "Vincent Van Gogh"),
        QuoteEntity(text = "The way to get started is to quit talking and begin doing.", author = "Walt Disney"),
        QuoteEntity(text = "Your time is limited, so don’t waste it living someone else’s life.", author = "Steve Jobs")
    )

    suspend fun preload() {
        dao.insertAll(predefinedQuotes)
    }

    suspend fun getQuoteForToday(): QuoteEntity? {
        val allQuotes = dao.getAll()
        if (allQuotes.isEmpty()) return null

        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        val index = dayOfYear % allQuotes.size
        return allQuotes[index]
    }
}
