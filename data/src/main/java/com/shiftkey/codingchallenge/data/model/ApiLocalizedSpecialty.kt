package com.shiftkey.codingchallenge.data.model

data class ApiLocalizedSpecialty(
    val id: String,
    val specialtyId: Long,
    val stateId: Long,
    val name: String,
    val abbreviation: String,
    val specialty: ApiSpecialty
)
