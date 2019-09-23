package com.aklal.briquedagger2

import androidx.lifecycle.ViewModel
import com.aklal.briquedagger2.Lapse.ChristmasTime
import com.aklal.briquedagger2.Lapse.TIME
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val mapOfLapse: Map<TIME, Class<out ChristmasTime>>
) : Presenter {

    override fun getDateUntil(): String {
        val t: ChristmasTime = mapOfLapse[TIME.UNTIL] as ChristmasTime
        return t.getLapseOfTime()
    }


    //override fun getDateSince(): String = mapOfLapse[TIME.SINCE]?.getLapseOfTime() ?: "SINCE FAILED"
}

