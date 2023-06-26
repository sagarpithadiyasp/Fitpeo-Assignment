package com.example.kotlinmachinetest.ApiClient

import com.example.kotlinmachinetest.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {
    private val userService: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create(ApiInterface::class.java)
    }

    suspend fun getUsers(): List<User> {
        return userService.getUsers()
    }
}