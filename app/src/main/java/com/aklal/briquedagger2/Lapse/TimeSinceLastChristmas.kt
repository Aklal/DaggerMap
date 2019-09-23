package com.aklal.briquedagger2.Lapse

import android.os.Build
import android.util.Log
import com.aklal.briquedagger2.TAG
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
import javax.inject.Inject


/**
 * TimeSinceLastChristmas computes a time since last christmas
 */
class TimeSinceLastChristmas @Inject constructor(): ChristmasTime {

    /**
     * Public field to get a string representing the time
     * since last christmas
     */
    //override fun getLapseOfTime() = convertDateInString(computeTimeSinceLastChristmas())
    override fun getLapseOfTime() = "SINCE TEST"

    /**
     * Compute time since Christmas
     */
    /*private fun computeTimeSinceLastChristmas():Long {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val timeNow = LocalDateTime.now()
            val timeChristmas = LocalDateTime.of(2018, 12, 24,0,0)

            Log.d(TAG, "computeTimeSinceLastChristmas | current timeNow: $timeNow")
            Log.d(TAG, "computeTimeSinceLastChristmas | timeChristmas: $timeChristmas")

            val timeSince: Long = timeChristmas.until(timeNow, ChronoUnit.DAYS)
            Log.d(TAG, "computeTimeSinceLastChristmas | timeUntil: $timeSince")

            return timeSince
        } else {
            return computeOldTimeSinceLastChristmas()
        }
    }

    /**
     * Compute difference between 2 Date for API < Build.VERSION_CODES.O
     */
    private fun computeOldTimeSinceLastChristmas():Long {

        val timeNow = getCurrentTime()

        Log.d(TAG, "computeOldTimeSinceLastChristmas | timeNow: $timeNow")

        val timeChristmas = "12/24/2018 00:00:0"

        //HH converts hour in 24 hours format (0-23), day calculation
        val format = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")

        var d1: Date?
        var d2: Date?
        var diff: Long = 0

        try {
            d2 = format.parse(timeNow)
            d1 = format.parse(timeChristmas)

            //in milliseconds
            diff = d2!!.time - d1!!.time

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return diff
    }

    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        val date = Date(System.currentTimeMillis())
        return formatter.format(date)
    }

    /**
     * Convert a long in human readable string
     */
    private fun convertDateInString(date: Long): String {
        val diffSeconds = date / 1000 % 60
        val diffMinutes = date / (60 * 1000) % 60
        val diffHours = date / (60 * 60 * 1000) % 24
        val diffDays = date / (24 * 60 * 60 * 1000)
        Log.d(TAG, "convertDateInString | $diffDays days, $diffHours hours, $diffMinutes minutes, $diffSeconds seconds.")

        return "$diffDays days, $diffHours hours, $diffMinutes minutes, $diffSeconds seconds"
    }*/
}

