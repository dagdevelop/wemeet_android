package com.dagdevelop.wemeet.middleware

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiConfig {

    // terminal > ipconfig/all > chercher IPv4 (192.168.0.XXXX:3001)
    val BASE_URL = "http://192.168.0.13:3001" //"http://localhost:3001/"

    /**
     * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
     */
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    /**
     * The Retrofit object with the Moshi converter.
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    // Interceptor : permet opérations sur requêtes
    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(RequestInteceptor)
        .build()

    // va permettre des opérations sur les requêtes
    object RequestInteceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request() 
            return chain.proceed(request)
        }
    }

    // Expose the client to be used elsewhere (API service layer)
    fun getClient(): Retrofit = retrofit
}
