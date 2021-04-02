package com.rujirakongsomran.kt_retrofit2.api

import com.rujirakongsomran.kt_retrofit2.model.Affirmation
import com.rujirakongsomran.kt_retrofit2.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("./")
    suspend fun getAffirmation(): Response<Affirmation>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    // https://jsonplaceholder.typicode.com/posts?userId=3
    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    // https://jsonplaceholder.typicode.com/posts?userId=3&_sort=id&_order=desc
    @GET("posts")
    suspend fun getCustomQueryPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomQueryMapPosts(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>


}