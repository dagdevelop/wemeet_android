package com.dagdevelop.wemeet.dataAccess.dataTransferObject

import com.squareup.moshi.Json
import java.util.*

data class Calendar(
    val event: Int,
    val date: Date,
    @Json(name = "nb_yes") val nbYes: Int,
    @Json(name = "nb_no") val nbNo: Int,
    @Json(name = "nb_maybe") val nbMaybe: Int
)