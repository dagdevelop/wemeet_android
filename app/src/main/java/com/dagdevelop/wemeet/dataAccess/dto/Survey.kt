package com.dagdevelop.wemeet.dataAccess.dto

data class Survey(
    val id: Int,
    val label: String,
    val description: String?,
    val event: Int
)