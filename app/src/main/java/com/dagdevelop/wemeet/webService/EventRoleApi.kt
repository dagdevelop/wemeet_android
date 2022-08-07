package com.dagdevelop.wemeet.webService

import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.EventRole
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

private const val ER = "eventRole/"
interface EventRoleApiService {
    @GET("${ER}/{eventId}")
    suspend fun getEventRoles(eventId : Int) : Response<List<EventRole>>

    @POST(ER)
    suspend fun createEventRole() : okhttp3.Response

    @PATCH(ER)
    suspend fun updateEventRole() : okhttp3.Response

    @DELETE(ER)
    suspend fun deleteEventRole() : okhttp3.Response
}

object EventRoleApi {
    val service: EventRoleApiService by lazy { ApiConfig.getClient().create(EventRoleApiService::class.java) }
}