package com.shiftkey.codingchallenge.data.datasource

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class DateConverter
@Inject constructor() {

    fun timestampToApiParamFormat(timestamp: Long): String =
        DATE_FORMAT.format(Date(timestamp))
}

val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd", Locale.US)
val DATE_AND_TIME_WITH_TIMEZONE = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.US)
