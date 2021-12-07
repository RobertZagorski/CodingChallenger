package com.shiftkey.codingchallenge.model

data class Day(
    val date: ShiftkeyTime,
    val shifts: List<Shift>
)
