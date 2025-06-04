package com.est.crudsample.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val pattern: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

fun convertToLocalDate(localDateStr: String): LocalDate {
    return LocalDate.parse(localDateStr, pattern)
}

fun convertToStr(localDate: LocalDate): String {
    return localDate.format(pattern)
}

fun convertToStr(localDate: LocalDateTime): String {
    return localDate.format(pattern)
}