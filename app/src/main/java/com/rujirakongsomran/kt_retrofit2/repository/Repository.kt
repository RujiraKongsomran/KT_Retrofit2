package com.rujirakongsomran.kt_retrofit2.repository

import com.rujirakongsomran.kt_retrofit2.api.RetrofitInstance
import com.rujirakongsomran.kt_retrofit2.model.Affirmation
import com.rujirakongsomran.kt_retrofit2.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getAffirmation(): Response<Affirmation> {
        return RetrofitInstance.api.getAffirmation()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId)
    }

    suspend fun getCustomQueryPosts(
        userId: Int,
        sort: String,
        order: String
    ): Response<List<Post>> {
        return RetrofitInstance.api.getCustomQueryPosts(userId, sort, order)
    }
}