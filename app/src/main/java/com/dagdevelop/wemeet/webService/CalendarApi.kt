package com.dagdevelop.wemeet.webService

import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dataTransferObject.Calendar
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

private const val CAL = "calendar/"
interface CalendarApiService {
    @GET("${CAL}/{id}")
    suspend fun getAllCalendars() : Response<List<Calendar>>

    @GET("${CAL}/{id}/{date}")
    suspend fun getCalendar(id: Int, date: String) : Response<Calendar>

    @POST(CAL)
    suspend fun createCalendar() : okhttp3.Response

    @PATCH(CAL)
    suspend fun updateCalendar() : okhttp3.Response

    @DELETE(CAL)
    suspend fun deleteCalendar() : okhttp3.Response
}

object CalendarApi {
    val service: CalendarApiService by lazy { ApiConfig.getClient().create(CalendarApiService::class.java) }
}
