package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.dto.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("user/{id}")
    fun getUser(@Path("id") id : Int) : Call<User> // Call = valeur retournée par la requête Retrofit
}