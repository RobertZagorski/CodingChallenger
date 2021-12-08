package com.shiftkey.codingchallenge.data.datasource.jsondeserialiser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.shiftkey.core.DateProvider.provideCalendar
import java.lang.reflect.Type
import java.text.DateFormat
import java.util.Calendar

class CalendarDeserializer(
    private vararg val dateFormats: DateFormat
) : JsonDeserializer<Calendar> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Calendar? {
        val dateAsString = json.asJsonPrimitive.asString
        if (dateAsString.isNullOrEmpty()) {
            return null
        }
        for (dateFormat in dateFormats) {
            try {
                return convert(dateAsString, dateFormat)
            } catch (e: Exception) {
            }
        }
        throw JsonParseException("Cannot parse $dateAsString - invalid date format.")
    }

    private fun convert(date: String, dateFormat: DateFormat): Calendar {
        val parsedDate = dateFormat.parse(date)
        return provideCalendar().apply { time = parsedDate!! }
    }
}
