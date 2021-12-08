package com.shiftkey.codingchallenge.data.model

import java.util.*

data class ApiShift(
    val shiftId: Long,
    val startTime: Calendar,
    val endTime: Calendar,
    val normalizedStartDateTime: String,
    val normalizedEndDateTime: String,
    val timezone: TimeZone,
    val premiumRate: Boolean,
    val covid: Boolean,
    val shiftKind: String,
    val withinDistance: Int,
    val facilityType: ApiFacilityType,
    val skill: ApiSkill,
    val localizedSpecialty: ApiLocalizedSpecialty
) {
}
