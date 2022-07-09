package com.dagdevelop.wemeet.dataAccess.models

import com.google.gson.annotations.SerializedName

data class SurveyLine(@SerializedName("survey") val survey : Int,
                      @SerializedName("line_number") val lineNumber : Int,
                      @SerializedName("label") val label : String,
                      @SerializedName("nb_votes") val nbVotes : Int)
