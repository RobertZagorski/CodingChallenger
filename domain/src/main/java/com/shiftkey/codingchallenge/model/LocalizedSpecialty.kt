package com.shiftkey.codingchallenge.model

data class LocalizedSpecialty(
    val id: String,
    val specialtyId: Long,
    val stateId: Long,
    val name: String,
    val abbreviation: String,
    val specialty: Specialty
)
