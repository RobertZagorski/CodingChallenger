package com.shiftkey.codingchallenge.repositories

import com.shiftkey.codingchallenge.model.AvailableShiftQualification
import com.shiftkey.codingchallenge.model.Day

interface ShiftListRepository {

    fun getShifts(qualification: AvailableShiftQualification) : List<Day>
}
