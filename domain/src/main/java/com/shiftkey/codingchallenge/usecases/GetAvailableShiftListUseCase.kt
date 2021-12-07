package com.shiftkey.codingchallenge.usecases

import com.shiftkey.codingchallenge.model.Day
import com.shiftkey.codingchallenge.model.ShiftkeyTime
import com.shiftkey.codingchallenge.repositories.ShiftListRepository

class GetAvailableShiftListUseCase(repository: ShiftListRepository) {

    fun execute(params: Params): List<Day> {
    }

    data class Params(val start: ShiftkeyTime, val location: String)
}
