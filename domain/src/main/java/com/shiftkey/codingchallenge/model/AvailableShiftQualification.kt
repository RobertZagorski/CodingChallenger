package com.shiftkey.codingchallenge.model

data class AvailableShiftQualification(
    val address: String,
    val start: ShiftkeyTime,
    val type: WorkWeek,
    val radius: Int
)
