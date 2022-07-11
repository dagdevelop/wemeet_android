package com.dagdevelop.wemeet.dataAccess.dto

import com.google.gson.annotations.SerializedName

data class Event (val id : Int,
                  val label : String,
                  val description : String?,
                  @SerializedName("city_name") val cityName : String,
                  @SerializedName("is_private") val isPrivate : Boolean)