package com.retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

  private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)



    val api : RetrofitApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://getyourapi.site/api/leads/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(RetrofitApi::class.java)
    }
}