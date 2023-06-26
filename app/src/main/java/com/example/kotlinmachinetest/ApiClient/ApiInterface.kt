package com.example.kotlinmachinetest.ApiClient

import com.example.kotlinmachinetest.User
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    suspend fun getUsers(): List<User>
}