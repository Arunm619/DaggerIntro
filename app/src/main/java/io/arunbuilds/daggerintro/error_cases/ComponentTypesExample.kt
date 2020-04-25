package io.arunbuilds.daggerintro.error_cases

import dagger.Component
import dagger.Module
import dagger.Provides

open class Wheels
class FireWheels : Wheels()

@Module
class WheelsModule {
    @Provides
    fun provideFireWheels(): FireWheels = FireWheels()
}

//@Component(modules = [WheelsModule::class])
interface Component {
    // Will error, since it doesn't know FireWheels are Wheels.
    fun getMeaWheel(): Wheels
}
