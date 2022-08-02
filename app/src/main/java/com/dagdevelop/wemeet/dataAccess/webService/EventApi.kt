package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.Event
import com.dagdevelop.wemeet.dataAccess.dto.User
import retrofit2.Response
import retrofit2.http.*

private const val EVENT = "event/"
interface EventApiService {
    @GET(EVENT)
    suspend fun getAllEvents() : Response<List<Event>>

    @GET("${EVENT}/{id}")
    suspend fun getEvent(id: Int) : Response<Event>

    @GET("${EVENT}{id}/participants")
    suspend fun getParticipants(id: Int) : Response<List<User>>

    @POST(EVENT)
    suspend fun createEvent() : okhttp3.Response

    @PATCH(EVENT)
    suspend fun updateEvent() : okhttp3.Response

    @DELETE(EVENT)
    suspend fun deleteEvent() : okhttp3.Response
}

object EventApi {
    val service: EventApiService by lazy { ApiConfig.getClient().create(EventApiService::class.java) }
}
