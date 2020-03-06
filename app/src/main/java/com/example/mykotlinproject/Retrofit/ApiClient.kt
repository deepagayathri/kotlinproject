package com.example.mykotlinproject.Retrofit

import com.example.mykotlinproject.utils.CommonClass
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

//    val BASE_URL ="https://www.fairpackers.com/"
    val BASE_URL ="https://jsonplaceholder.typicode.com/"
    val BASE_URL1 ="http://192.168.1.244/cabily/customization/laisha/v1/"

    private var retrofit: Retrofit? = null


    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
                .baseUrl(BASE_URL1)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())

                .build()
        }
        return retrofit
    }


    internal var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
}
