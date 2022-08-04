package com.dagdevelop.wemeet.dataAccess.dataTransferObject

data class Survey(
    val id: Int,
    val label: String,
    val description: String?,
    val event: Int
)