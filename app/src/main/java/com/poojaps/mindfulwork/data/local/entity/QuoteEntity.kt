package com.poojaps.mindfulwork.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val author: String?
)
