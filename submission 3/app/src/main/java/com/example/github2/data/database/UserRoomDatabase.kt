package com.example.github2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserFavorite::class], version = 1)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun userFavoriteDao(): UserFavoriteDao

    companion object {
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase {
            if (INSTANCE == null) {
                synchronized(UserRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserRoomDatabase::class.java, "user_db").build()
                }
            }
            return INSTANCE as UserRoomDatabase
        }
    }
}