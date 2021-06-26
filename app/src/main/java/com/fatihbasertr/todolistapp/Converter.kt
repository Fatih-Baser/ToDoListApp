package com.fatihbasertr.todolistapp

import androidx.room.TypeConverter
import com.fatihbasertr.todolistapp.models.Priority


class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }

}