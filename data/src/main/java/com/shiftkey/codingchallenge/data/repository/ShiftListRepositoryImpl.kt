package com.shiftkey.codingchallenge.data.repository

import com.shiftkey.codingchallenge.data.datasource.ShiftRemoteDataSource
import com.shiftkey.codingchallenge.data.mapper.ShiftDataLayerMapper
import com.shiftkey.codingchallenge.model.AvailableShiftQualification
import com.shiftkey.codingchallenge.model.Day
import com.shiftkey.codingchallenge.repositories.ShiftListRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ShiftListRepositoryImpl
@Inject constructor(
    private val shiftRemoteDataSource: ShiftRemoteDataSource,
    private val shiftDataLayerMapper: ShiftDataLayerMapper
) : ShiftListRepository {

    override fun getShifts(qualification: AvailableShiftQualification): Single<List<Day>> {
        return shiftRemoteDataSource.getAvailableShifts(qualification)
            .flatMapObservable { Observable.fromIterable(it) }
            .map { shiftDataLayerMapper.map(it) }
            .toList()
    }
}
