package com.dagdevelop.wemeet.dataAccess.dataTransferObject

import com.squareup.moshi.Json

data class SurveyLine(
    val survey: Int,
    @Json(name = "line_number") val lineNumber: Int,
    val label: String,
    @Json(name = "nb_votes") val nbVotes: Int
)
