package com.example.github2.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.github2.data.database.UserFavorite
import com.example.github2.data.database.UserFavoriteRepository
import com.example.github2.data.remote.response.ResponseDetailUser
import com.example.github2.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel(application: Application): AndroidViewModel(application) {

    private val _detailUser = MutableLiveData<ResponseDetailUser?>()
    val detailUser: LiveData<ResponseDetailUser?> = _detailUser

    private val userFavoriteRepository = UserFavoriteRepository(application)

    fun addUserFavorite(login: String?, id: Int?, avatar: String?) {
        if ((login != null && id != null) && avatar != null) {
            val userFavorite = UserFavorite(id, login, avatar)
            userFavoriteRepository.insert(userFavorite)
        }
    }

    fun removeUserFavorite(id: Int?) {
        if (id != null) userFavoriteRepository.delete(id)
    }

    fun checkUserFavorite(id: Int) = userFavoriteRepository.checkUserFavorite(id)

    fun getDetailUser(login: String?) {
        if (login != null) {
            val client = ApiConfig.getApiService().getDetailUser(login)
            client.enqueue(object : Callback<ResponseDetailUser> {
                override fun onResponse(
                    call: Call<ResponseDetailUser>,
                    response: Response<ResponseDetailUser>
                ) {
                    val responseBody = response.body()
                    if (responseBody != null && response.isSuccessful)
                        _detailUser.postValue(responseBody)
                    else
                        Log.e(TAG, "onResponse: ${response.message()}", )
                }

                override fun onFailure(call: Call<ResponseDetailUser>, t: Throwable) {
                    Log.e(TAG, "onFailure getDetailUser(): ${t.printStackTrace()}")
                }

            })
        }
    }

    companion object {
        private val TAG = DetailUserViewModel::class.java.simpleName
    }
}