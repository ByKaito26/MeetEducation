package com.example.meeteducation.database.likes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feedback")
data class likes (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "likes") val like: Int
)