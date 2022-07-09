package com.dagdevelop.wemeet.dataAccess.models

import com.google.gson.annotations.SerializedName

data class Event (@SerializedName("id") val id : Int,
                  @SerializedName("label") val label : String,
                  @SerializedName("description") val description : String?,
                  @SerializedName("city_name") val cityName : String,
                  @SerializedName("is_private") val isPrivate : Boolean)