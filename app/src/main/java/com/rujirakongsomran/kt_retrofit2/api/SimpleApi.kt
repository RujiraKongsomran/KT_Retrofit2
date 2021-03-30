package com.rujirakongsomran.kt_retrofit2.api

import com.rujirakongsomran.kt_retrofit2.model.Post
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Post
}