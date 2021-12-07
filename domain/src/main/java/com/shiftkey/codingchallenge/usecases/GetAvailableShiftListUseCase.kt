package com.shiftkey.codingchallenge.usecases

import com.shiftkey.codingchallenge.model.ShiftkeyTime

class GetAvailableShiftListUseCase {

    fun execute(params: Params) {
    }

    data class Params(val start: ShiftkeyTime, val location: String)
}
