package com.shiftkey.codingchallenge.data.datasource

import com.shiftkey.codingchallenge.data.model.ApiDay
import com.shiftkey.codingchallenge.model.AvailableShiftQualification
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ShiftRemoteDataSource
@Inject constructor(
    private val shiftApi: ShiftApi,
    private val dataLayerConverter: DataLayerConverter
) {

    fun getAvailableShifts(qualification: AvailableShiftQualification): Single<List<ApiDay>> {
        return shiftApi.getAvailableShifts(
            address = qualification.address,
            radius = qualification.radius,
            timeSpan = dataLayerConverter.convertWorkType(qualification.type),
            date = dataLayerConverter.convertStartDate(qualification.start)
        )
    }
}
