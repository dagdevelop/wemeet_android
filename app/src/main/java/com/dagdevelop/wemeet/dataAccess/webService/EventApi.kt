package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.configuration.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.Event
import retrofit2.Response
import retrofit2.http.*

interface EventApiService {
    @GET("event")
    suspend fun getAllEvents() : Response<List<Event>>

    @GET("event/{id}")
    suspend fun getEvent(id: Int) : Response<Event>
}

object EventApi {
    val service: EventApiService by lazy { ApiConfig.getClient().create(EventApiService::class.java) }
}
