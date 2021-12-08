package com.shiftkey.codingchallenge.data.mapper

import com.shiftkey.codingchallenge.data.model.ApiDay
import com.shiftkey.codingchallenge.data.model.ApiShift
import com.shiftkey.codingchallenge.data.model.ApiSpecialty
import com.shiftkey.codingchallenge.model.Day
import com.shiftkey.codingchallenge.model.FacilityType
import com.shiftkey.codingchallenge.model.LocalizedSpecialty
import com.shiftkey.codingchallenge.model.Shift
import com.shiftkey.codingchallenge.model.ShiftkeyTime
import com.shiftkey.codingchallenge.model.Skill
import com.shiftkey.codingchallenge.model.Specialty
import javax.inject.Inject

class ShiftDataLayerMapper
@Inject constructor() {

    fun map(apiDay: ApiDay): Day =
        Day(
            date = mapDayDate(apiDay),
            shifts = apiDay.shifts.map { map(it) }
        )

    fun map(apiShift: ApiShift): Shift =
        Shift(
            shiftId = apiShift.shiftId,
            startTime = mapStartTime(apiShift),
            endTime = mapEndTime(apiShift),
            premiumRate = apiShift.premiumRate,
            covid = apiShift.covid,
            shiftKind = apiShift.shiftKind,
            withinDistance = apiShift.withinDistance,
            facilityType = mapFacilityType(apiShift),
            skill = mapSkill(apiShift),
            localizedSpecialty = mapLocalizedSpecialty(apiShift)
        )

    private fun mapLocalizedSpecialty(apiShift: ApiShift): LocalizedSpecialty =
        LocalizedSpecialty(
            id = apiShift.localizedSpecialty.id,
            specialtyId = apiShift.localizedSpecialty.specialtyId,
            stateId = apiShift.localizedSpecialty.stateId,
            name = apiShift.localizedSpecialty.name,
            abbreviation = apiShift.localizedSpecialty.abbreviation,
            specialty = mapSpeciality(apiShift.localizedSpecialty.specialty)
        )

    private fun mapSpeciality(specialty: ApiSpecialty): Specialty =
        Specialty(
            id = specialty.id,
            name = specialty.name,
            color = specialty.color,
            abbreviation = specialty.abbreviation
        )

    private fun mapSkill(apiShift: ApiShift): Skill =
        Skill(
            id = apiShift.skill.id,
            name = apiShift.skill.name,
            color = apiShift.skill.color
        )

    private fun mapFacilityType(apiShift: ApiShift): FacilityType =
        FacilityType(
            apiShift.facilityType.id,
            apiShift.facilityType.name,
            apiShift.facilityType.color
        )

    private fun mapDayDate(apiDay: ApiDay) =
        ShiftkeyTime(apiDay.date.timeInMillis, apiDay.date.timeZone)

    private fun mapEndTime(apiShift: ApiShift): ShiftkeyTime =
        ShiftkeyTime(apiShift.endTime.timeInMillis, apiShift.timezone)

    private fun mapStartTime(apiShift: ApiShift): ShiftkeyTime =
        ShiftkeyTime(apiShift.startTime.timeInMillis, apiShift.timezone)
}
