package com.aklal.briquedagger2

import com.aklal.briquedagger2.Lapse.ChristmasTime
import com.aklal.briquedagger2.Lapse.TIME
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val mapOfLapse: Map<TIME, ChristmasTime>
) : Presenter {

    override fun getDateUntil(): String = mapOfLapse[TIME.UNTIL]?.getLapseOfTime() ?: "UNTIL FAILED"

    //override fun getDateSince(): String = mapOfLapse[TIME.SINCE]?.getLapseOfTime() ?: "SINCE FAILED"
}

