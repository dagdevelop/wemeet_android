package com.dagdevelop.wemeet.dataAccess.dto

import com.squareup.moshi.Json

data class EventDetailsResponse(
    val id: Int,
    val label: String,
    val description: String,
    @Json(name = "city_name") val cityName : String,
    @Json(name = "is_private") val isPrivate : Boolean,
    val participants : List<User>,
    var calendars : List<Calendar>?
) {
    override fun toString(): String {
        return "id = ${id}" + "\n" +
                "label = $label" + "\n" +
                "description = $description" + "\n" +
                "city name = $cityName" + "\n" +
                "is private = ${isPrivate}" + "\n" +
                "participants = $participants" + "\n" +
                "calendars = $calendars"
    }
}