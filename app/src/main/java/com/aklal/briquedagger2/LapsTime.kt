package com.aklal.briquedagger2

import android.os.Build
import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.text.SimpleDateFormat
import java.time.*
import java.time.temporal.ChronoUnit
import java.util.*
import javax.inject.Inject
import dagger.MapKey


@MapKey
internal annotation class TimeKey(val value: TIME)

enum class TIME {
    UNTIL,
    SINCE
}


/*

interface MainModule {
    @Binds
    fun getMainPresenter(connection: MainPresenter): Presenter
}

* */

/**
 * Binds concrete implementations with interface
 */
@Module
interface ChristmasModule {
    @Binds
    fun bindSinceChristmas(time: TimeSinceLastChristmas): ChristmasTime

    @Binds
    fun bindUntilChristmas(time: TimeUntilChristmas): ChristmasTime
}



/**
 * Provides particular implementations
 */
@Module
object LapseOfTimeModule {
    @JvmStatic
    @Provides
    @IntoMap
    @TimeKey(TIME.UNTIL)
    fun provideLapsesOfTimeUntil()= TimeUntilChristmas()

    @JvmStatic
    @Provides
    @IntoMap
    @TimeKey(TIME.SINCE)
    fun provideLapsesOfTimeSince()= TimeSinceLastChristmas()
}


interface ChristmasTime {
    fun getLapseOfTime():String
}

/**
 * TimeUntilChristmas computes a time before christmas
 */
class TimeUntilChristmas @Inject constructor(): ChristmasTime{

    /**
     * Public field to get a string representing the remaining time
     * before christmas
     */
    //override fun getLapseOfTime() = convertDateInString(computeTimeUntilChristmas())
    override fun getLapseOfTime() = "UNTIL TEST"

    /**
     * Compute time before Christmas
     */
    private fun computeTimeUntilChristmas():Long {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val timeNow = LocalDateTime.now()
            val timeChristmas = LocalDateTime.of(2019, 12, 24,0,0)

            Log.d(TAG, "computeTimeUntilChristmas | current timeNow: $timeNow")
            Log.d(TAG, "computeTimeUntilChristmas | timeChristmas: $timeChristmas")

            val timeUntil: Long = timeNow.until(timeChristmas, ChronoUnit.DAYS)
            Log.d(TAG, "computeTimeUntilChristmas | timeUntil: $timeUntil")

            return timeUntil
        } else {
            return computeOldTimeUntilChristmas()
        }
    }


    /**
     * Compute difference between 2 Date for API < Build.VERSION_CODES.O
     */
    private fun computeOldTimeUntilChristmas():Long {

        val timeNow = getCurrentTime()

        Log.d(TAG, "computeOldTimeUntilChristmas | timeNow: $timeNow")

        val timeChristmas = "12/24/2019 00:00:0"

        //HH converts hour in 24 hours format (0-23), day calculation
        val format = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")

        var d1: Date?
        var d2: Date?
        var diff: Long = 0

        try {
            d1 = format.parse(timeNow)
            d2 = format.parse(timeChristmas)

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
    }
}



/**
 * TimeSinceLastChristmas computes a time since last christmas
 */
class TimeSinceLastChristmas @Inject constructor(): ChristmasTime{

    /**
     * Public field to get a string representing the time
     * since last christmas
     */
    //override fun getLapseOfTime() = convertDateInString(computeTimeSinceLastChristmas())
    override fun getLapseOfTime() = "SINCE TEST"

    /**
     * Compute time since Christmas
     */
    private fun computeTimeSinceLastChristmas():Long {
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
    }
}

