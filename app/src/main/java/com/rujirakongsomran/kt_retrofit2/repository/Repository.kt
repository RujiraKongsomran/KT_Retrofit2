package com.rujirakongsomran.kt_retrofit2.repository

import com.rujirakongsomran.kt_retrofit2.api.RetrofitInstance
import com.rujirakongsomran.kt_retrofit2.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}