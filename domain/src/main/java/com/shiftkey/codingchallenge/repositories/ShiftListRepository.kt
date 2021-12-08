package com.shiftkey.codingchallenge.repositories

import com.shiftkey.codingchallenge.model.AvailableShiftQualification
import com.shiftkey.codingchallenge.model.Day
import io.reactivex.rxjava3.core.Single

interface ShiftListRepository {

    fun getShifts(qualification: AvailableShiftQualification): Single<List<Day>>
}
