package com.dagdevelop.wemeet.dataAccess.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Calendar(val event : Int,
                    val date : Date,
                    @SerializedName("nb_yes") val nbYes : Int,
                    @SerializedName("nb_no") val nbNo : Int,
                    @SerializedName("nb_maybe") val nbMaybe : Int)
