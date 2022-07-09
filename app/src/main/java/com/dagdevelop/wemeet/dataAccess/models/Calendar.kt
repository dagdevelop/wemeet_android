package com.dagdevelop.wemeet.dataAccess.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Calendar(@SerializedName("event") val event : Int,
                    @SerializedName("date") val date : Date,
                    @SerializedName("nb_yes") val nbYes : Int,
                    @SerializedName("nb_no") val nbNo : Int,
                    @SerializedName("nb_maybe") val nbMaybe : Int)
