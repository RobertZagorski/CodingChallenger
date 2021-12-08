package com.shiftkey.codingchallenge.data.datasource.jsondeserialiser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.util.TimeZone

class TimezoneDeserializer : JsonDeserializer<TimeZone> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TimeZone {
        val timezoneId = json!!.asJsonPrimitive.asString
        if (timezoneId.isNullOrEmpty()) return US_CENTRAL_TIMEZONE
        if (timezoneId == US_CENTRAL_TIMEZONE_ALIAS) {
            return US_CENTRAL_TIMEZONE
        } else {
            try {
                return TimeZone.getTimeZone(timezoneId)
            } catch (e: Exception) {
            }
        }
        throw JsonParseException("Invalid date format fo timezone")
    }
}

private const val US_CENTRAL_TIMEZONE_ALIAS: String = "Central"
private val US_CENTRAL_TIMEZONE: TimeZone = TimeZone.getTimeZone("US/Central")
