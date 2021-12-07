package com.shiftkey.codingchallenge.model

data class Shift(
    val shiftId: Long,
    val startTime: ShiftkeyTime,
    val endTime: ShiftkeyTime,
    // TODO do sth with other time params from API model
    val premiumRate: Boolean,
    val covid: Boolean,
    val shiftKind: String,
    val withinDistance: Int,
    val facilityType: FacilityType,
    val skill: Skill,
    val localizedSpecialty: LocalizedSpecialty
)
