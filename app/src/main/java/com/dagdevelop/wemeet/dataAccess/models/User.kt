package com.dagdevelop.wemeet.dataAccess.models

import com.google.gson.annotations.SerializedName

data class User (@SerializedName("id") val id : Int,
                 @SerializedName("first_name") val firstName : String,
                 @SerializedName("last_name") val lastName : String,
                 @SerializedName("email") val email : String,
                 @SerializedName("password") val password : String,
                 @SerializedName("address") val address : String?,
                 @SerializedName("postal_code") val postalCode : Int?,
                 @SerializedName("is_admin") val isAdmin : Boolean)