package com.aklal.briquedagger2.Lapse

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Provides particular implementations
 */
@Module
interface LapseOfTimeModule {
    @Binds
    @IntoMap
    @TimeKey(TIME.UNTIL)
    fun provideLapsesOfTimeUntil(t: TimeUntilNextChristmas): ChristmasTime

    @Binds
    @IntoMap
    @TimeKey(TIME.SINCE)
    fun provideLapsesOfTimeSince(t: TimeSinceLastChristmas): ChristmasTime
}
