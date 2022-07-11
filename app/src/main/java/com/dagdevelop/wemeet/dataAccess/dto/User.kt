package com.dagdevelop.wemeet.dataAccess.dto

import com.google.gson.annotations.SerializedName

data class User (val id : Int,
                 @SerializedName("first_name") val firstName : String,
                 @SerializedName("last_name") val lastName : String,
                 val email : String,
                 val password : String,
                 val address : String?,
                 @SerializedName("postal_code") val postalCode : Int?,
                 @SerializedName("is_admin") val isAdmin : Boolean)