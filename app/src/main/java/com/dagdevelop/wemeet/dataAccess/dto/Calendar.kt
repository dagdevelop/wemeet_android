package com.dagdevelop.wemeet.dataAccess.dto

import android.icu.text.SimpleDateFormat
import com.squareup.moshi.Json
import java.time.LocalDate
import java.util.*
import kotlin.reflect.jvm.internal.impl.platform.SimplePlatform

data class Calendar(
    val event: Int,
    val date: String,
    @Json(name = "nb_yes") val nbYes: Int,
    @Json(name = "nb_no") val nbNo: Int,
    @Json(name = "nb_maybe") val nbMaybe: Int
) {
    override fun toString(): String {
        return "event #$event \n" +
                "date = $date \n" +
                "nb_yes = ${nbYes} \n" +
                "nb_no = ${nbNo} \n" +
                "nb_maybe = ${nbMaybe} \n"
    }
}
