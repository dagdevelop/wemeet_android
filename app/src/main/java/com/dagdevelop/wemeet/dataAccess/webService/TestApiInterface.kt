package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.dto.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface TestApiInterface {
    @GET("posts")
    fun getData(): Call<List<MyDataItem>>
}