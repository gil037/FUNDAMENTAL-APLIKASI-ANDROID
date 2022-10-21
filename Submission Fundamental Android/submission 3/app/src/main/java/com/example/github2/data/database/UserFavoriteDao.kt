package com.example.github2.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserFavoriteDao {
    @Insert
    fun insert(userFavorite: UserFavorite)

    @Query("SELECT * FROM user_favorite")
    fun getAllUserFavorite(): LiveData<List<UserFavorite>>

    @Query("DELETE FROM user_favorite WHERE user_favorite.id = :id")
    fun delete(id: Int): Int

    @Query("SELECT count(*) FROM user_favorite WHERE user_favorite.id = :id")
    fun checkUserFavorite(id: Int): Int
}