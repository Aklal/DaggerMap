package com.aklal.briquedagger2.Lapse


import javax.inject.Inject


/**
 * TimeUntilNextChristmas computes a time before christmas
 */
class TimeUntilNextChristmas @Inject constructor(): ChristmasTime {
    override fun getLapseOfTime() = "UNTIL TEST"
}


