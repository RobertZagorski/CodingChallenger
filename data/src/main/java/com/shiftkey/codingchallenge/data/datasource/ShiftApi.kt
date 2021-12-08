package com.shiftkey.codingchallenge.data.datasource

import com.shiftkey.codingchallenge.data.model.ApiDay
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ShiftApi {

    @GET(AVAILABLE_SHIFTS)
    fun getAvailableShifts(
        @Query(PATH_PARAM_DATE) date: String,
        @Query(PARAM_ADDRESS) address: String,
        @Query(PARAM_TYPE) timeSpan: String,
        @Query(PARAM_RADIUS) radius: Int
    ): Single<List<ApiDay>>
}

const val AVAILABLE_SHIFTS = "available_shifts"
const val PATH_PARAM_DATE = "start"
const val PARAM_ADDRESS = "address"
const val PARAM_TYPE = "type"
const val PARAM_RADIUS = "radius"
const val PARAM_VALUE_MODE_WEEK = "week"
const val PARAM_VALUE_MODE_4DAY = "4day"
