package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.models.User
import retrofit2.Call
import retrofit2.http.*

interface UserDAO {
    @GET("user/id")

    fun getUserById(
        @Query("id") id : Int
    ) : Call<User>
}