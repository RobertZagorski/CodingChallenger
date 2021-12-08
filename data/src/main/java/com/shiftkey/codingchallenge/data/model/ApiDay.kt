package com.shiftkey.codingchallenge.data.model

import java.util.*

data class ApiDay(
    val date: Calendar,
    val shifts: List<ApiShift>
) {
}
