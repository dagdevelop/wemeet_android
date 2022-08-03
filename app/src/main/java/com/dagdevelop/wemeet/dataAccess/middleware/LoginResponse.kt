package com.dagdevelop.wemeet.dataAccess.middleware

import com.dagdevelop.wemeet.dataAccess.dto.User
import com.squareup.moshi.Json

data class LoginResponse (
    @Json(name = "status_code")
    var statusCode: Int,

    @Json(name = "auth_token")
    var authToken: String,

    @Json(name = "user")
    var user: User
)
