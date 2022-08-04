package com.dagdevelop.wemeet.webService

import com.dagdevelop.wemeet.middleware.ApiConfig
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST

private const val SL = "surveyLine/"
interface SurveyLineApiService {
    @POST(SL)
    suspend fun createSurveyLine() : okhttp3.Response

    @PATCH(SL)
    suspend fun updateSurveyLine() : okhttp3.Response

    @DELETE(SL)
    suspend fun deleteSurveyLine() : okhttp3.Response
}

object SurveyLineApi {
    val service: SurveyLineApiService by lazy { ApiConfig.getClient().create(SurveyLineApiService::class.java) }
}