package com.dagdevelop.wemeet.dataAccess.webService

import com.dagdevelop.wemeet.dataAccess.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.Survey
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

private const val SURVEY = "survey/"
interface SurveyApiService {
    @GET("${SURVEY}/{eventId}")
    suspend fun getSurveysByEventId(id: Int) : Response<List<Survey>>

    @POST(SURVEY)
    suspend fun createSurvey() : okhttp3.Response

    @PATCH(SURVEY)
    suspend fun updateSurvey() : okhttp3.Response

    @DELETE(SURVEY)
    suspend fun deleteSurvey() : okhttp3.Response
}

object SurveyApi {
    val service: SurveyApiService by lazy { ApiConfig.getClient().create(SurveyApiService::class.java) }
}