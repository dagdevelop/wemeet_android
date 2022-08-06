package com.dagdevelop.wemeet.middleware

import com.dagdevelop.wemeet.dataAccess.dataTransferObject.User
import com.squareup.moshi.Json

data class LoginResponse (
    @Json(name = "status") // because of API : status === "admin" || "user"
    var status: Boolean,

    @Json(name = "auth_token")
    var authToken: String,

    @Json(name = "user")
    var user: User
)
