package com.example.kotlinmachinetest

import java.io.Serializable

data class User(
    val albumId: String,
    val id: String,
    val title: String,
    val url: String,
    val thumbnailUrl: String
):Serializable