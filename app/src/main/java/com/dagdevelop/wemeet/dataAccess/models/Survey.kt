package com.dagdevelop.wemeet.dataAccess.models

import com.google.gson.annotations.SerializedName

data class Survey (@SerializedName("id") val id : Int,
                   @SerializedName("label") val label : String,
                   @SerializedName("description") val description : String?,
                   @SerializedName("event") val event : Int)