package com.dagdevelop.wemeet.dataAccess.configuration

import com.dagdevelop.wemeet.dataAccess.webService.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    val BASE_URL = "http://192.168.0.19:3001" //"http://localhost:3001/"

    // le by lazy veut dire : on initialise la variable retrofit seulement si on l'appelle ou si on l'utilise
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getClient(): Retrofit = retrofit

    val TEST_URL = "https://jsonplaceholder.typicode.com/"
    private val retroTest by lazy {
        Retrofit.Builder()
            .baseUrl(TEST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getTestClient() : Retrofit = retroTest

    // va permettre des opérations sur les requêtes
    object RequestInteceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            println("Outgoing request to ${request.url()}")
            return chain.proceed(request)
        }
    }

    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(RequestInteceptor)
        .build()
}
