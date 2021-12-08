package com.shiftkey.codingchallenge.data.datasource

import com.shiftkey.codingchallenge.model.ShiftkeyTime
import com.shiftkey.codingchallenge.model.WorkWeek
import com.shiftkey.codingchallenge.model.WorkWeek.FOUR_DAY
import com.shiftkey.codingchallenge.model.WorkWeek.WEEK
import javax.inject.Inject

class DataLayerConverter
@Inject constructor(
    private val dateConverter: DateConverter
) {

    fun convertWorkType(workWeek: WorkWeek): String =
        when (workWeek) {
            FOUR_DAY -> PARAM_VALUE_MODE_WEEK
            WEEK -> PARAM_VALUE_MODE_4DAY
        }

    fun convertStartDate(time: ShiftkeyTime): String =
        dateConverter.timestampToApiParamFormat(time.timestamp)
}
