package com.aklal.briquedagger2

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet
import javax.inject.Named
import kotlin.random.Random

/**
 * Create a random RGB code
 */
fun createRandomRgbCode(): String {
    // create object of Random class
    val obj = Random
    val randNum = obj.nextInt(0xffffff + 1)

    // format it as hexadecimal string and print
    val colorCode = String.format("#%06x", randNum)

    Log.d("createRandomRgbCode", "StringModule | createRandomRgbCode | generated color: $colorCode")

    return colorCode
}


/**
 * Provides particular implementations
 */
@Module
object StringModule {
    @JvmStatic
    @Provides
    @ElementsIntoSet
    fun provideSetOfStrings(): Set<String> = setOf(
        createRandomRgbCode(),
        createRandomRgbCode()
    )
}
