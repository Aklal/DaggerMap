package com.aklal.briquedagger2

import com.aklal.briquedagger2.Lapse.ChristmasModule
import com.aklal.briquedagger2.Lapse.LapseOfTimeModule
import dagger.Component

@Component(modules = [MainModule::class, LapseOfTimeModule::class])
interface MainComponent {
    fun presenter(): Presenter
}