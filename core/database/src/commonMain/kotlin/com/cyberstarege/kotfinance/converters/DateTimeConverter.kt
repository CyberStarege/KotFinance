package com.cyberstarege.kotfinance.converters

import androidx.room.TypeConverter
import kotlin.time.Instant

class DateTimeConverter {
    @TypeConverter
    fun fromLongToInstant(timeInMillis: Long): Instant {
        return Instant.fromEpochMilliseconds(timeInMillis)
    }

    @TypeConverter
    fun fromInstantToLong(instant: Instant): Long {
        return instant.toEpochMilliseconds()
    }
}