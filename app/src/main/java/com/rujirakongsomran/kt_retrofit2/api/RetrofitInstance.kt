package com.rujirakongsomran.kt_retrofit2.api

import com.rujirakongsomran.kt_retrofit2.uitls.Constants.Companion.BASE_URL
import com.rujirakongsomran.kt_retrofit2.uitls.Constants.Companion.BASE_URL_AFFIRMATION
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_AFFIRMATION)
            //.client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}