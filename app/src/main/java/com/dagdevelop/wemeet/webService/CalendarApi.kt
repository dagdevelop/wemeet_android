package com.dagdevelop.wemeet.webService

import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.Calendar
import retrofit2.Response
import retrofit2.http.*

private const val CAL = "calendar/"

interface CalendarApiService {
    @GET("${CAL}/{id}")
    suspend fun getAllCalendars(@Path("id") id: Int): Response<List<Calendar>>

    @POST(CAL)
    suspend fun createCalendar(): okhttp3.Response

    @PATCH(CAL)
    suspend fun updateCalendar(): okhttp3.Response

    @DELETE(CAL)
    suspend fun deleteCalendar(): okhttp3.Response
}

object CalendarApi {
    val service: CalendarApiService by lazy {
        ApiConfig.getClient().create(CalendarApiService::class.java)
    }
}
