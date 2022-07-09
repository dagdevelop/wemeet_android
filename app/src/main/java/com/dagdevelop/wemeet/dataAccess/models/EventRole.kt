package com.dagdevelop.wemeet.dataAccess.models

import com.google.gson.annotations.SerializedName

data class EventRole(@SerializedName("user") val user : Int,
                     @SerializedName("event") val event : Int,
                     @SerializedName("role") val role : String)
