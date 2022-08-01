package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.configuration.ApiConfig
import com.dagdevelop.wemeet.dataAccess.configuration.ApiConfig.getClient
import com.dagdevelop.wemeet.dataAccess.dto.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {
    @GET("user/{id}")
    suspend fun getUser(@Path("id") id : Int) : Response<User> // Call = valeur retournée par la requête Retrofit

    @POST("user/login")
    suspend fun login() : Response<User>

    @POST("user")
    suspend fun createUser() : okhttp3.Response
}

object UserApi {
    val service: UserApiService by lazy { ApiConfig.getClient().create(UserApiService::class.java) }

    suspend fun successfulUsersResponse() {
        // val usersResponse = service.getUser(1)
        //     .execute()
        // val successful = usersResponse.isSuccessful
        // val httpStatusCode = usersResponse.code()
        // val httpStatusMessage = usersResponse.message()
    }
}
