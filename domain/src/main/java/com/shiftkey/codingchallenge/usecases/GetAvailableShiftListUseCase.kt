package com.shiftkey.codingchallenge.usecases

import com.shiftkey.codingchallenge.model.AvailableShiftQualification
import com.shiftkey.codingchallenge.model.Day
import com.shiftkey.codingchallenge.model.ShiftkeyTime
import com.shiftkey.codingchallenge.repositories.ShiftListRepository

class GetAvailableShiftListUseCase(private val repository: ShiftListRepository) {

    fun execute(params: Params): List<Day> {
        val qualification = AvailableShiftQualification(
            address = params.location,
            start = params.start,
            radius = DefaultValues.RADIUS,
            type = DefaultValues.SHIFT_TYPE
        )
        return repository.getShifts(qualification)
    }

    data class Params(val start: ShiftkeyTime, val location: String)
}
