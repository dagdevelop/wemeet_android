package com.dagdevelop.wemeet.dataAccess.dto

import com.squareup.moshi.Json
import java.time.Instant
import java.util.*

val FOO_calendars = listOf<Calendar>(
    com.dagdevelop.wemeet.dataAccess.dto.Calendar(1, Date(Instant.now().epochSecond), 1, 1, 5),
    com.dagdevelop.wemeet.dataAccess.dto.Calendar(1, Date(Instant.now().epochSecond), 2, 2, 6),
    com.dagdevelop.wemeet.dataAccess.dto.Calendar(1, Date(Instant.now().epochSecond), 3, 3, 7)
)
