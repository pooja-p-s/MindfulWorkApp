package com.poojaps.mindfulwork.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poojaps.mindfulwork.data.local.entity.QuoteEntity

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)

    @Query("SELECT * FROM quotes")
    suspend fun getAll(): List<QuoteEntity>
}
