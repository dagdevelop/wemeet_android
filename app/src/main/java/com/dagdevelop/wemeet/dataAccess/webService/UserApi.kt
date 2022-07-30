package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.configuration.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.User
import retrofit2.Call
import retrofit2.http.*

interface UserApiService {
    @GET("user/{id}")
    suspend fun getUser(@Path("id") id : Int) : Call<User> // Call = valeur retournée par la requête Retrofit

    @POST("user/login")
    suspend fun login() : Call<User>

    @POST("user")
    suspend fun createUser() : okhttp3.Call
}

object UserApi {
    val service: UserApiService by lazy { ApiConfig.getClient().create(UserApiService::class.java) }
}
