package com.dagdevelop.wemeet.webService

import android.widget.Toast
import com.dagdevelop.wemeet.dataAccess.dto.Calendar
import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.Event
import com.dagdevelop.wemeet.dataAccess.dto.EventDetailsResponse
import com.dagdevelop.wemeet.dataAccess.dto.User
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import retrofit2.http.*

private const val EVENT = "event/"
interface EventApiService {
    @GET(EVENT)
    suspend fun getAllEvents() : Response<List<Event>>

    @GET("${EVENT}/{id}")
    suspend fun getEvent(@Path("id")id: Int) : Response<EventDetailsResponse>

    @GET("${EVENT}/{id}/participants")
    suspend fun getParticipants(@Path("id")id: Int) : Response<List<User>>

    @POST(EVENT)
    suspend fun createEvent(@Body event: Event) : okhttp3.Response

    @PATCH(EVENT)
    suspend fun updateEvent(@Body event: Event) : okhttp3.Response

    @DELETE(EVENT)
    suspend fun deleteEvent(@Body id: Int) : okhttp3.Response
}

object EventApi {
    val service: EventApiService by lazy { ApiConfig.getClient().create(EventApiService::class.java) }

    fun getAllEvents() : List<Event> {
        var res: List<Event>
        try {
            runBlocking {
                res = service.getAllEvents().body()!!
            }
        } catch (e: Exception) {
            throw java.lang.Exception(e.message)
        }
        return res
    }

    fun getEvent(id: Int) : EventDetailsResponse {
        var res: EventDetailsResponse
        var calendars: List<Calendar>
        try {
            runBlocking {
                res = service.getEvent(id).body()!!
                calendars = CalendarApi.service.getAllCalendars(id).body()!!
                res.calendars = calendars
            }
        }catch (e: Exception) {
            throw java.lang.Exception(e.message)
        }
        return res
    }
}
