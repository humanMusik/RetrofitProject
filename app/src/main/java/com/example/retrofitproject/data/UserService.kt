package com.example.retrofitproject.data

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

interface UserService {
    @GET("/users")
    suspend fun getUsers(
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): List<User>

    @GET("/users/{username}")
    suspend fun getUser(@Path("username") username: String)
}
