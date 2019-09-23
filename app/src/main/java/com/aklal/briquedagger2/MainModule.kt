package com.aklal.briquedagger2

import dagger.Binds
import dagger.Module

@Module
interface MainModule {
    @Binds
    fun getMainPresenter(connection: MainPresenter): Presenter
}