package com.example.github2.data.remote.retrofit

import com.example.github2.data.remote.response.ResponseDetailUser
import com.example.github2.data.remote.response.ResponseUser
import com.example.github2.data.remote.response.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getUser(@Query("q") value: String): Call<ResponseUser>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetailUser(@Path("username") username: String): Call<ResponseDetailUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(@Path("username") username: String): Call<List<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(@Path("username") username: String): Call<List<User>>
}