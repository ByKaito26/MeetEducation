package com.example.meeteducation.database.likes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.meeteducation.database.user.User

@Dao
interface LikeDao {
    @Query("SELECT COUNT(*) FROM feedback")
    abstract suspend fun getVotosCount(): Int

    @Query("SELECT COUNT(*) FROM feedback WHERE likes = 1")
    suspend fun getLikesCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLike(like: likes)

    @Query("SELECT COUNT(*) FROM feedback WHERE Id = :userId")
    suspend fun getUserVotesCount(userId: Int): Int

    suspend fun hasUserVoted(userId: Int): Boolean {
        val count = getUserVotesCount(userId)
        return count > 0
    }






}