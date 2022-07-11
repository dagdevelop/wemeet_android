package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.configuration.RetrofitConfig
import com.dagdevelop.wemeet.dataAccess.dto.User
import okhttp3.ResponseBody

class UserService {
    private val retrofit = RetrofitConfig.getClient()
    private val userApi = retrofit.create(UserApi::class.java)

    fun getUser(id : Int) : User {
        val userResponse = userApi.getUser(id).execute()

        val successful = userResponse.isSuccessful
        val httpStatusCode = userResponse.code()
        val httpsStatusMessage = userResponse.message()

        val body: User? = userResponse.body()
        return body!!
    }
}