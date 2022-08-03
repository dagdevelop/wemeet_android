package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.User
import com.dagdevelop.wemeet.dataAccess.middleware.LoginRequest
import com.dagdevelop.wemeet.dataAccess.middleware.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

private const val USER = "user/"
interface UserApiService {
    @GET("${USER}/{id}")
    suspend fun getUser(@Path("id") id : Int) : Response<User> // Call = valeur retournée par la requête Retrofit

    @POST("${USER}/login")
    fun login(@Body request: LoginRequest) : Call<LoginResponse>

    @POST(USER)
    suspend fun createUser() : okhttp3.Response

    @PATCH(USER)
    suspend fun updateUser() : okhttp3.Response

    @DELETE(USER)
    suspend fun deleteUser() : okhttp3.Response
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
