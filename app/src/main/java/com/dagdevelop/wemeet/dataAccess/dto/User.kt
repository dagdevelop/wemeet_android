package com.dagdevelop.wemeet.dataAccess.dto

import com.squareup.moshi.Json

data class User(
    val id: Int,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    val email: String,
    val password: String,
    val address: String?,
    @Json(name = "postal_code") val postalCode: Int?,
    @Json(name = "is_admin") val isAdmin: Boolean
) {
    override fun toString(): String {
        return "${id} $firstName $lastName"
    }
}