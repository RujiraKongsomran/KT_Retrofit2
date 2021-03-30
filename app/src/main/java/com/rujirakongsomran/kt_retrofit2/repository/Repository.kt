package com.rujirakongsomran.kt_retrofit2.repository

import com.rujirakongsomran.kt_retrofit2.api.RetrofitInstance
import com.rujirakongsomran.kt_retrofit2.model.Post

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}