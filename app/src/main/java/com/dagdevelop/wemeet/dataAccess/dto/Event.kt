package com.dagdevelop.wemeet.dataAccess.dto

import com.squareup.moshi.Json

data class Event(
    val id: Int,
    val label: String,
    val description: String?,
    @Json(name = "city_name") val cityName: String,
    @Json(name = "is_private") val isPrivate: Boolean
)