package com.dagdevelop.wemeet.dataAccess.dto

import com.squareup.moshi.Json

val FOO_events = listOf<Event>(
    Event(1, "FOO event 1", "No description 1 [public]", "Namur", false),
    Event(2, "FOO event 2", "No description 2 [private]", "Liège", true),
    Event(3, "FOO event 3", "No description 3 [public]", "Bruxelles", false)
)