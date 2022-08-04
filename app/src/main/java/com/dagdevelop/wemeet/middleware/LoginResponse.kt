package com.dagdevelop.wemeet.middleware

import com.dagdevelop.wemeet.dataAccess.dataTransferObject.User
import com.squareup.moshi.Json

data class LoginResponse (
    @Json(name = "status_code")
    var statusCode: Int,

    @Json(name = "auth_token")
    var authToken: String,

    @Json(name = "user")
    var user: User
)
