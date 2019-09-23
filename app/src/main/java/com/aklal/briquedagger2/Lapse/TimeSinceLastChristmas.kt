package com.aklal.briquedagger2.Lapse


import javax.inject.Inject


/**
 * TimeSinceLastChristmas computes a time since last christmas
 */
class TimeSinceLastChristmas @Inject constructor(): ChristmasTime {

    /**
     * Public field to get a string representing the time
     * since last christmas
     */
    override fun getLapseOfTime() = "SINCE TEST"

}

