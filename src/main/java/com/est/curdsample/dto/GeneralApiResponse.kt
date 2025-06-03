package com.est.curdsample.dto

import lombok.Builder
import lombok.Getter

data class GeneralApiResponse<T>(
    val data: T? = null,
    val msg: String,
)