package io.arunbuilds.daggerintro.basic_module_inject_mix

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Wheel
class Car @Inject constructor(val wheels: Wheel)

@Module
class WheelsModule {
    @Provides
    fun providesWheels() = Wheel()
}

@Component(modules = [WheelsModule::class])
interface CarComponentMix {
    fun getMeaCar(): Car
}