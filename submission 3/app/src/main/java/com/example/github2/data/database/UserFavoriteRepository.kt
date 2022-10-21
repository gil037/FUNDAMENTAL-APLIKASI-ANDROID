package com.example.github2.data.database

import android.app.Application
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserFavoriteRepository(application: Application) {
    private val userFavoriteDao: UserFavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val database = UserRoomDatabase.getDatabase(application)
        userFavoriteDao = database.userFavoriteDao()
    }

    fun getAllUserFavorite() = userFavoriteDao.getAllUserFavorite()

    fun insert(userFavorite: UserFavorite) {
        executorService.execute { userFavoriteDao.insert(userFavorite) }
    }

    fun delete(id: Int): Int {
        val delete = executorService.submit(Callable { userFavoriteDao.delete(id) })
        return delete.get()
    }

    fun checkUserFavorite(id: Int): Int {
        val checkUserFavorite = executorService.submit(Callable {
            userFavoriteDao.checkUserFavorite(id)
        })
        return checkUserFavorite.get()
    }
}