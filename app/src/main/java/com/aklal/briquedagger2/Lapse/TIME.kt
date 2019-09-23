package com.aklal.briquedagger2.Lapse

import dagger.MapKey

@MapKey
annotation class TimeKey(val value: TIME)

enum class TIME {
    UNTIL,
    SINCE
}
