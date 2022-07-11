package com.dagdevelop.wemeet.dataAccess.dto

import com.google.gson.annotations.SerializedName

data class SurveyLine(val survey : Int,
                      @SerializedName("line_number") val lineNumber : Int,
                      val label : String,
                      @SerializedName("nb_votes") val nbVotes : Int)
