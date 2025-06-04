package com.est.crudsample.dto

data class GeneralApiResponse<T>(
    val data: T? = null,
    val msg: String,
)