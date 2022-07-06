package com.dagdevelop.wemeet.dataAccess.configuration

import com.dagdevelop.wemeet.dataAccess.webService.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    val BASE_URL = "http://10.0.2.2:3001/"

    // le by lazy veut dire : on initialise la variable retrofit seulement si on l'appelle ou si on l'utilise
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun buildWebService () : ApiService = retrofit.create(ApiService::class.java)
}
