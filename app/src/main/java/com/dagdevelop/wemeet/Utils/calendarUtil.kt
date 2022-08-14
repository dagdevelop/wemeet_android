package com.dagdevelop.wemeet.Utils

import android.icu.text.SimpleDateFormat
import java.util.*

class calendarUtil {
    companion object {
        fun dateToString(date: Date): String {
            val pattern = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(pattern)
            return simpleDateFormat.format(date)
        }

        fun stringToDate(string: String) : Date {
            val pattern = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(pattern)
            return simpleDateFormat.parse(string)
        }
    }
}