package com.aklal.briquedagger2.Lapse

import dagger.Binds
import dagger.Module

/**
 * Binds concrete implementations with interface
 */
@Module
interface ChristmasModule {
    @Binds
    fun bindSinceChristmas(time: TimeSinceLastChristmas): ChristmasTime

    @Binds
    fun bindUntilChristmas(time: TimeUntilNextChristmas): ChristmasTime
}
